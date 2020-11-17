package com.jam.fizzbuzz.service;

import com.jam.fizzbuzz.entity.FizzBuzz;
import com.jam.fizzbuzz.repository.FizzBuzzRepository;
import com.jam.fizzbuzz.repository.SessionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class FizzBuzzService {

    @Autowired
    private SessionRepository repo;

    private String replace(int value, FizzBuzz fizzBuzz){
        return value % fizzBuzz.getCounter() == 0 ? fizzBuzz.getReplacement() : "";
    }

    public String replace(int value, List<FizzBuzz> entries){
        if (value < 1){
            throw new IllegalArgumentException("Don't do this with nonpositive values.");
        }
        String possible = entries.stream().map(entry -> replace(value, entry))
                .collect(Collectors.joining());
        return possible.isEmpty() ? Integer.toString(value) : possible;
    }

    public List<String> playFizzBuzz(int size){
        List<FizzBuzz> buzzer = repo.retrieveFizzBuzzesForSession("default");
        return Stream.iterate(1, i -> i+1).limit(size).map(i -> replace(i, buzzer)).collect(Collectors.toList());
    }
}
