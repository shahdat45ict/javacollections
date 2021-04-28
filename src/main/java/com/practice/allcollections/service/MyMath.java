package com.practice.allcollections.service;

@FunctionalInterface
public interface MyMath {

    int getDoubleOf(int a);

    default void print(String str){
        System.out.println(str);
    }

    static void print(String str, int a){

    }

}
