package com.practice.streaming;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsDemo {

    public static void main(String[] args) {
        //Stream<Person> personStream = Stream.generate(new PersonGenerator()).limit(10).sorted(Comparator.comparing(m -> m.salary));
        Stream<Person> personStream = Stream.generate(new PersonGenerator()).limit(10).sorted(Comparator.naturalOrder());
        Map<Boolean, List<Person>> map = personStream.collect(Collectors.partitioningBy(p -> p.salary() > 2000));
        System.out.println(map);
    }

}

//class Person {
//
//    Integer salary = 0;
//
//    Person(Integer salary) {
//        this.salary = salary;
//    }
//
//    public Integer salary() {
//        return this.salary;
//    }
//
//    @Override
//    public String toString() {
//        return "Person{" +
//                "salary=" + salary +
//                '}';
//    }
//
//}

class Person implements Comparable<Person> {

    Integer salary = 0;

    Person(Integer salary) {
        this.salary = salary;
    }

    public Integer salary() {
        return this.salary;
    }

    @Override
    public String toString() {
        return "Person{" +
                "salary=" + salary +
                '}';
    }

    @Override
    public int compareTo(Person o) {
        return this.salary.compareTo(o.salary);
    }
}

class PersonGenerator implements Supplier<Person> {

    private static Random random = new Random(5000);

    @Override
    public Person get() {
        return new Person(random.nextInt(10000));
    }

}





