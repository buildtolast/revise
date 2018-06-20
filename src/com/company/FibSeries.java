package com.company;

import java.util.stream.*;
import java.util.function.*;

class FibSeries implements Supplier<Long> {

    Long previous = 0L;
    Long next = 1L;

    @Override
    public Long get(){
        Long value = previous + next;
        previous = next;
        next = value;
        return previous;
    }

    public static void main(String[] args) {
//        Stream.generate(new FibSeries()).limit(10).collect(Collectors.toList()).forEach(System.out::println);
        Stream.generate(new FibSeries()).limit(30).forEach(System.out::println);
    }

}