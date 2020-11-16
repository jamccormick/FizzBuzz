package com.jam.fizzbuzz.controller;

import com.jam.fizzbuzz.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FibonacciController {

    @Autowired
    private FibonacciService service;

    @RequestMapping("/fibonacci/{length}/iterative")
    public List<Long> fibonacci(@PathVariable("length") int length){
        return service.calculateFibonaccisIteratively(length);
    }

    @RequestMapping("/fibonacci/{length}/recursive")
    public List<Long> fibonacciResursive(@PathVariable("length") int length){
        return service.calculateFibonaccisRecursively(length);
    }
}
