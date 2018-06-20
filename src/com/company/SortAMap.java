package com.company;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortAMap {

    public static void main(String[] args) {
        List<KV> list = new ArrayList<>();
        Map<Integer, List<Integer>> map = Stream.of(1, 3, 42, 42, 7, 8, 8, 8, 8, 96, 45, 43567, 886).collect(Collectors.groupingBy(e -> e));
        map.forEach((k, v) -> list.add(new KV(k, v.size())));
        list.sort(new KVComparator());
        System.out.println(list);

        Stream.of(1, 3, 42, 42, 7, 8, 8, 8, 8, 96, 45, 43567, 886).sorted().forEach(System.out::println);
    }

}

class KV {

    Integer k;
    Integer v;

    public KV(Integer k, Integer v) {
        this.k = k;
        this.v = v;
    }

    public Integer key() {
        return this.k;
    }

    public Integer value() {
        return this.v;
    }

    public String toString() {
        return String.format("{%d-%d}", k, v);
    }

}

class KVComparator implements Comparator<KV> {

    @Override // error
    public int compare(KV m, KV n) {
        return n.value().compareTo(m.value());
    }

}


