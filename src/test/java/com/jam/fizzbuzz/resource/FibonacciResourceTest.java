package com.jam.fizzbuzz.resource;

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
public class FibonacciResourceTest {

    @InjectMocks
    private FibonacciResource resource;

    @Mock
    private FibonacciService service;

    @Test
    public void theTwoImplementationsShouldMatch(){
        ReflectionTestUtils.setField(service, "fibonaccis", new HashMap(){{
            put(0, 0);
            put(1, 1);
        }});
        Mockito.when(service.calculateFibonaccisIteratively(Mockito.anyInt())).thenCallRealMethod();
        Mockito.when(service.calculateFibonaccisRecursively(Mockito.anyInt())).thenCallRealMethod();
        Assertions.assertEquals(resource.fibonacci(), resource.fibonacciResursive());
    }
}
