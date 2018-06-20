package com.company;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamDemo {

    public static void main(String[] args) {

        Map<Integer, List<Integer>> collect = Stream.of(1, 2, 3, 4, 5, 6, 7, 7, 7).collect(Collectors.groupingBy(e -> e));
        Map<Integer, KeyValue> map = new TreeMap<>();
        collect.keySet().forEach(e -> map.put(e, new KeyValue(e,collect.get(e).size())));
        Collection<KeyValue> value = map.values();
        System.out.println(value);
//        Function<List<Integer>, Integer> vm = List::size;
//        Map<Integer, String> collect =
//                Stream.of(1, 2, 3, 4, 5, 6, 7, 7, 7).collect(Collectors.toMap(Function.identity(), (Function<List<Integer>, Integer>)List::size, (x, y) -> y+x));
//        List<KeyValue> set = new ArrayList<>();
//        collect.forEach((k, v) -> set.add(new KeyValue(k, v.size())));
//        System.out.println(collect);
//        set.sort(new KeyValueComparator());
//        System.out.println(set);

    }

}

class KeyValue implements Comparable<KeyValue>, Comparator<Integer> {

    Integer key;
    Integer value;

    public KeyValue(Integer k, Integer v) {
        this.key = k;
        this.value = v;
    }

    public Integer getKey() {
        return this.key;
    }

    public Integer getValue() {
        return this.value;
    }

    public String toString(){
        return "["+this.key+","+this.value+"]";
    }

    @Override
    public int compareTo(KeyValue o) {
        return o.getValue().compareTo(this.value);
    }

    @Override
    public int compare(Integer o1, Integer o2) {
        return 0;
    }
}

class KeyValueComparator implements Comparator<KeyValue> {

    @Override
    public int compare(KeyValue m, KeyValue n) {
        return n.getValue().compareTo(m.getValue());
    }

}
