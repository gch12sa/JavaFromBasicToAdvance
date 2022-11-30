package com.gch.miscellaneous;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingChar {

    public static void main(String[] args) {
        String str = "aabbcc";
        /*Optional<Character> firstChar = str.chars().mapToObj(value-> (char) value).collect(Collectors.groupingBy( Function.identity(),
                                                                                  LinkedHashMap::new,
                                                                                  Collectors.counting()))
                                            .entrySet()
                                            .stream()
                                            .filter(characterLongEntry -> characterLongEntry.getValue()==1)
                                            .map(Map.Entry::getKey)
                                            .findFirst();*/

        str.chars()
           .mapToObj(value-> (char) value)
           .collect(Collectors.toMap( Function.identity(),
                                      v->1L,
                                      Long::sum,
                                      LinkedHashMap:: new))
           .entrySet()
           .stream()
           .filter(characterLongEntry -> characterLongEntry.getValue()==1)
           .map(Map.Entry::getKey)
           .findFirst()
           .ifPresentOrElse( value->System.out.println("First non repeating character is: "+ value),
                             ()-> System.out.println("there is no non repeating character"));
    }
}
