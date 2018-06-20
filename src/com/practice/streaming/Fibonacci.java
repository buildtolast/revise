package com.practice.streaming;

import java.util.*;
import java.util.stream.*;
import java.util.function.*;
public class Fibonacci {


    public static void main(String[] args){
        List<Long> fibSeries = Stream.generate(new FibGenerate()).limit(20).collect(Collectors.toList());
        fibSeries.forEach(System.out::println);

        LongStream.range(0,10).forEach(e -> System.out.println(fib(e)));
    }

    static class FibGenerate implements Supplier<Long> {
        private Long previous = 0L;
        private Long current = 1L;

        @Override
        public Long get() {
            Long next = previous + current;
            previous = current;
            current = next;

            return previous;
        }
    }

    static Long fib(Long l) {
        if(l.equals(0L))
            return 0L;
        else if(l.equals(1L))
            return 1L;

        return fib(l-2) + fib(l-1);
    }

}