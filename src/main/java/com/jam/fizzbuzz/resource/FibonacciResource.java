package com.jam.fizzbuzz.resource;

import com.jam.fizzbuzz.service.FibonacciService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FibonacciResource {

    @Autowired
    private FibonacciService service;

    @RequestMapping("/fibonacci/iterative")
    public List<Integer> fibonacci(){
        return service.calculateFibonaccisIteratively(100);
    }

    @RequestMapping("/fibonacci/recursive")
    public List<Integer> fibonacciResursive(){
        return service.calculateFibonaccisRecursively(100);
    }
}
