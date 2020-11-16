package com.jam.fizzbuzz.controller;

import com.jam.fizzbuzz.service.FibonacciService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.util.ReflectionTestUtils;

import java.util.HashMap;

@ExtendWith(MockitoExtension.class)
public class FibonacciControllerTest {

    @InjectMocks
    private FibonacciController resource;

    @Mock
    private FibonacciService service;

    @Test
    public void theTwoImplementationsShouldMatch(){
        ReflectionTestUtils.setField(service, "fibonaccis", new HashMap(){{
            put(0, 0L);
            put(1, 1L);
        }});
        Mockito.when(service.calculateFibonaccisIteratively(Mockito.anyInt())).thenCallRealMethod();
        Mockito.when(service.calculateFibonaccisRecursively(Mockito.anyInt())).thenCallRealMethod();
        Assertions.assertEquals(resource.fibonacci(10), resource.fibonacciResursive(10));
    }
}
