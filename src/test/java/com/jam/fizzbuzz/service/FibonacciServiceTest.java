package com.jam.fizzbuzz.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class FibonacciServiceTest {
    private static final List<Integer> EXPECTED = new ArrayList<>(){{
        add(1);
        add(1);
        add(2);
        add(3);
        add(5);
        add(8);
        add(13);
    }};

    @InjectMocks
    private FibonacciService service;

    @Test
    public void shouldGetTheNthFibonacciNumberIteratively(){
        Assertions.assertEquals(EXPECTED, service.calculateFibonaccisIteratively(7));
    }

    @Test
    public void shouldGetTheNthFibonacciNumberRecursively(){
        Assertions.assertEquals(EXPECTED, service.calculateFibonaccisRecursively(7));
    }
}
