package com.company;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;

public class ThreadSafe {

    public static void main(String[] args) {

        Set<Integer> set = Collections.synchronizedSet(new TreeSet<>());
        set.add(1);
        set.add(2);
        set.add(3);
        set.add(4);

        System.out.println(set.iterator().next());

    }


}
