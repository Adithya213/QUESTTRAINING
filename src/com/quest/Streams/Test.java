package com.quest.Streams;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Test {
    public static void main(String[] args) {

        ArrayList<Integer> list = new ArrayList<>();
        list.add(7);
        list.add(2);
        list.add(2);
        list.add(4);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(10);

        System.out.println(list.stream().findFirst());//to get 1st element of arraylist
        System.out.println(list.stream().findAny());
        // Integer is datatype and compareTo is the method we used
        System.out.println("max "+list.stream().max(Integer::compareTo));//to get max value from list
        //or
        Optional<Integer> m = list.stream().min(Integer::compareTo);
        System.out.println("min "+m);//to get min value from list

        System.out.println("count contain duplicates "+ list.stream().count());

        System.out.println("count without duplicates " + list.stream().distinct().count());

        System.out.println("sum of elements "+list.stream().reduce(0, Integer::sum));//identity will add to sum
        System.out.println("sum of elements "+list.stream().reduce(2, Integer::sum));//identity with 2 add 40+2

        //LAMDA EXPRESSION- (i -> {}) use curly brases when multiple condition
        List<Integer> list2 = list.stream().filter(i -> i%2 == 0).toList();
        System.out.println("list 2 with even no "+ list2);


        List<Integer> list3 = list.stream().map(i -> i*2).toList();
        System.out.println("list 3 with all elements multiplied by 2 "+ list3);//useful instead of using array

        int c = list.stream().map(i -> i*2).reduce(0,Integer::sum);
        System.out.println("list 4 with all elements multiplied by 2 then find sum of elements :"+ c);

        int d = list.stream().map(i -> i*2).max(Integer::compareTo).get();
        int e = list.stream().map(i -> i*2).min(Integer::compareTo).get();
        System.out.println("list 4 with all elements multiplied by 2 then max and min :"+ d + "\t"+e);
    }
}
