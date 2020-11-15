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
    private static final List<Long> EXPECTED = new ArrayList<>(){{
        add(1L);
        add(1L);
        add(2L);
        add(3L);
        add(5L);
        add(8L);
        add(13L);
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
