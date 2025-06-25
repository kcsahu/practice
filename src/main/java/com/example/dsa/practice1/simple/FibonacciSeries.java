package com.example.dsa.practice1.simple;

import java.util.LinkedList;
import java.util.List;

public class FibonacciSeries {

    public static void main(String[] args) {
        System.out.println(0 + ":" + fibonacci(0));
        System.out.println(1 + ":" + fibonacci(1));
        System.out.println(2 + ":" + fibonacci(2));
        System.out.println(3 + ":" + fibonacci(3));
        System.out.println(4 + ":" + fibonacci(4));
        System.out.println(7 + ":" + fibonacci(7));
    }

    public static List<Integer> fibonacci(int n) {
        int prev = 0, cur = 1;
        List<Integer> res = new LinkedList<>();
        res.add(prev);
        if(n == 0){
            return res;
        }
        res.add(cur);
        while (n >= 2) {
            int next = prev + cur;
            res.add(next);
            prev = cur;
            cur = next;
            n--;
        }
        return res;
    }


}
