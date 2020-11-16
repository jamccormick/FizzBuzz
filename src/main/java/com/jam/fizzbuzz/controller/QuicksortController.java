package com.jam.fizzbuzz.controller;

import com.jam.fizzbuzz.ro.QuicksortRO;
import com.jam.fizzbuzz.service.QuicksortService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@RestController
public class QuicksortController {

    @Autowired
    private QuicksortService service;

    @RequestMapping("/quicksort")
    public QuicksortRO quicksort(){
        QuicksortRO ro = new QuicksortRO();
        List<Integer> before = Stream.iterate(1, i -> i + 1).limit(10).collect(Collectors.toList());
        Collections.shuffle(before);
        ro.setUnsorted(before);
        ro.setSorted(service.quicksort(before));
        return ro;
    }
}
