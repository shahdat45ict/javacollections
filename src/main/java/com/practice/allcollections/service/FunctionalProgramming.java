package com.practice.allcollections.service;

import com.practice.allcollections.entity.Customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Callable;

public class FunctionalProgramming {


    public void lambda() throws Exception {

        Runnable r = () -> System.out.println("hello");
        r.run(); // print hello

        List<Customer> customers = new ArrayList<>(List.of(new Customer(), new Customer()));

        //( s) -> {return s;};

        // Callable<String> callable =  (String s) -> { int n = s.length(); return n; }

        // s is effectively final (not changed anywhere)
        String s = "foo";

        // s can be referenced in the lambda
        Callable callable = () -> s;

        /// String strResult = (String) callable.call();

        List<String> strings = Arrays.asList("a", "", "b", "", "c");

        // Count the non-empty strings
        long nonEmptyCount = strings.stream()
                .filter(x -> !x.isEmpty())
                .count();

        // Count the empty strings
        long emptyCount = strings.stream()
                .filter(String::isEmpty) // same as .filter(x -> x.isEmpty())
                .count();

    }


}
