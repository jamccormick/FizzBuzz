package com.jam.fizzbuzz.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FibonacciService {
    private Map<Integer, Long> fibonaccis;

    public List<Long> calculateFibonaccisIteratively(int size){
        return Stream.iterate(new Long[]{0L, 1L}, i -> new Long[]{i[1], i[0] + i[1]})
                .limit(size)
                .map(i -> i[1])
                .collect(Collectors.toList());
    }

    private Long calculateFibonnaciN(int n){
        if (null == fibonaccis){
            fibonaccis = new HashMap<>(){{
                put(0, 0L);
                put(1, 1L);
            }};
        }
        if(!fibonaccis.containsKey(n)){
            fibonaccis.put(n, calculateFibonnaciN(n-1) + calculateFibonnaciN(n - 2));
        }
        return fibonaccis.get(n);
    }

    public List<Long> calculateFibonaccisRecursively(int size){
        return Stream.iterate(1, i -> i + 1)
                .limit(size)
                .map(this::calculateFibonnaciN)
                .collect(Collectors.toList());
    }
}
