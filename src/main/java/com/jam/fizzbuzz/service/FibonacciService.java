package com.jam.fizzbuzz.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FibonacciService {
    private Map<Integer, Integer> fibonaccis;

    public List<Integer> calculateFibonaccisIteratively(int size){
        return Stream.iterate(new int[]{0, 1}, i -> new int[]{i[1], i[0] + i[1]})
                .limit(size)
                .map(i -> i[1])
                .collect(Collectors.toList());
    }

    private int calculateFibonnaciN(int n){
        if (null == fibonaccis){
            fibonaccis = new HashMap<>(){{
                put(0, 0);
                put(1, 1);
            }};
        }
        if(fibonaccis.containsKey(n)){
            return fibonaccis.get(n);
        }
        else{
            fibonaccis.put(n, calculateFibonnaciN(n-1) + calculateFibonnaciN(n - 2));
            return fibonaccis.get(n);
        }
    }

    public List<Integer> calculateFibonaccisRecursively(int size){
        return Stream.iterate(1, i -> i + 1)
                .limit(size)
                .map(this::calculateFibonnaciN)
                .collect(Collectors.toList());
    }
}
