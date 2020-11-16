package com.jam.fizzbuzz.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class QuicksortService {

    public List<Integer> quicksort(List<Integer> unsorted){
        List<Integer> copy = new ArrayList<>(unsorted); //let's *not* modify the list we're sorting.
        List<Integer> sorted;
        if (1 == copy.size()){
            sorted = copy;
        }
        else if(2 == copy.size()){
            sorted = compareAndSwap(unsorted);
        }
        else {
            int pivotposition = (unsorted.size() - 1) / 2;
            Integer pivot = copy.get(pivotposition);
            copy.remove(pivotposition);
            List<Integer> smaller = copy.stream().filter(i -> i < pivot).collect(Collectors.toList());
            List<Integer> larger = copy.stream().filter(i -> i > pivot).collect(Collectors.toList());
            sorted = 0 == smaller.size() ? new ArrayList<>() : quicksort(smaller);
            sorted.add(pivot);
            if(0 < larger.size()) {
                sorted.addAll(quicksort(larger));
            }
        }
        return sorted;
    }

    private List<Integer> compareAndSwap(List<Integer> unsorted){
        List<Integer> sorted = new ArrayList<>();
        if(unsorted.get(1) < unsorted.get(0)){
            sorted.add(unsorted.get(1));
            sorted.add(unsorted.get(0));
        } else {
            sorted = new ArrayList<>(unsorted);
        }
        return sorted;
    }
}
