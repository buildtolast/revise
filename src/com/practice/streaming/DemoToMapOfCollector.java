package com.practice.streaming;


import java.util.*;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

public class DemoToMapOfCollector {

    public static void main(String[] args) {

        // make key logic
        Function<? super Integer, ?> keymapper = new Function<Integer, Integer>() {

            @Override
            public Integer apply(Integer integer) {
                return integer;
            }
        };


        Function<? super Integer, ?> valuemapper = new Function<Integer, List<Integer>>() {
            @Override
            public List<Integer> apply(Integer o) {
                return Collections.singletonList(o);
            }
        };

        BinaryOperator<?> merge = new BinaryOperator<Object>() {
            @Override
            public Object apply(Object o, Object o2) {
                return null;
            }
        };

        List<Integer> list = Stream.of(1, 2, 4, 65, 57).collect(Collectors.toList());
        Objects.requireNonNull(list);
        Map<?, ?> m = list.stream().collect(toMap(keymapper, valuemapper));
        System.out.println(m);

    }

}
