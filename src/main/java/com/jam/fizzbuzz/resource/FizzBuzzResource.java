package com.jam.fizzbuzz.resource;

import com.jam.fizzbuzz.service.FizzBuzzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class FizzBuzzResource {
    @Autowired
    private FizzBuzzService service;

    @RequestMapping("/fizzbuzz")
    public List<String> playFizzBuzz(){
       return service.playFizzBuzz(100);
    }
}
