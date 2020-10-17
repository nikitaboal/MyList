package com.company;

public class Main {
    public static void main(String[] args) {
        List list = new List();
        list.add(11);
        list.add(55);
        list.add(2);
        list.add(43);
        System.out.println(list.toString());
        list.swap(2,4);
        System.out.println(list.toString());
        list.sort();
        System.out.println(list.toString());

        }
    }