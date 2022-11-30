package com.gch.miscellaneous;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SortMapOnBasisOfValues {

    public static void main(String[] args) {

        Map<String, Long> unSortedMap = new HashMap<>();
        unSortedMap.put("a", 1L);
        unSortedMap.put("b", 8L);
        unSortedMap.put("h", 3L);
        unSortedMap.put("z", 9L);
        unSortedMap.put("c", 1L);

        System.out.println("Before Sorting by value");

        unSortedMap.forEach((k,v)->System.out.println(k+"="+v));
        System.out.println("After Sorting by value");
        unSortedMap.entrySet()
                   .stream()
                   .sorted(Map.Entry.comparingByValue())
                   .forEach(System.out::println);
    }
}
