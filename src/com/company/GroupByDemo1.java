package com.company;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class GroupByDemo1 {

    public static void main(String[] args) {
        Map<Boolean, List<Integer>> m = new HashMap<>();
        Function<? super Object, ?> classifier = new Function<Object, Object>() {
            @Override
            public Object apply(Object o) {
                return null;
            }
        };
//        IntStream.of(1, 23, 4, 5, 6, 67, 7, 8).collect(Collectors.groupingBy(e -> (e%2==0), Collectors.toMap()));
//        Function<? super Integer, ?> f = (Function<Integer, Boolean>) integer -> (integer%2 == 0);
//        Function<? super Integer, ?> e = (Function<Integer, Map<Boolean, List<Integer>>>) integer -> Function.identity();
//        IntStream.of(1, 23, 4, 5, 6, 67, 7, 8).collect(Collectors.toMap(f, e));
        System.out.println(m);
    }

    static int[] matchingStrings(String[] strings, String[] queries) {
        Map<String, List<String>> map = Stream.of(strings).collect(Collectors.groupingBy(e -> e));
//        Stream.of(queries).map(a, b).collect(Collectors.toList());
        return Stream.of(queries).mapToInt(e -> map.containsKey(e) ? map.get(e).size() : 0).toArray();
    }

}
