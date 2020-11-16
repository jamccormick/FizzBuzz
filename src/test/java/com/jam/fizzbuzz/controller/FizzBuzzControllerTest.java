package com.jam.fizzbuzz.controller;

import com.jam.fizzbuzz.service.FizzBuzzService;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;

@ExtendWith(MockitoExtension.class)
public class FizzBuzzControllerTest {

    @InjectMocks
    private FizzBuzzController resource;

    @Mock
    private FizzBuzzService service;


    @Test
    public void shouldReturnAListOfFizzbuzzedStuff(){
        Mockito.when(service.playFizzBuzz(100)).thenReturn(new ArrayList<>());
        Assert.assertEquals(new ArrayList<String>(), resource.playFizzBuzz(100));
    }
}
