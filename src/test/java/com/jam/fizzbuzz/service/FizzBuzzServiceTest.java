package com.jam.fizzbuzz.service;

import com.jam.fizzbuzz.entity.FizzBuzz;
import com.jam.fizzbuzz.repository.FizzBuzzRepository;
import com.jam.fizzbuzz.repository.SessionRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;


@ExtendWith(MockitoExtension.class)
public class FizzBuzzServiceTest {

    private static final List<FizzBuzz> BUZZER = new ArrayList<>(){{
        add(new FizzBuzz(3, "Fizz", 1));
        add(new FizzBuzz(5, "Buzz", 2));
    }};

    @InjectMocks
    private FizzBuzzService service;

    @Mock
    private SessionRepository repo;

    @Test
    public void shouldSuccessfullyReplaceA3(){
        Assertions.assertEquals("Fizz", service.replace(3, BUZZER));
    }

    @Test
    public void shouldNotReplaceA4(){
        Assertions.assertEquals("4", service.replace(4, BUZZER));
    }

    @Test
    public void shouldSuccesfullyReplaceA5(){
        Assertions.assertEquals("Buzz", service.replace(5, BUZZER));
    }

    @Test
    public void shouldSuccessfullyReplaceA15(){
        Assertions.assertEquals("FizzBuzz", service.replace(15, BUZZER));
    }

    @Test
    public void shouldThrowAnErrorIfTheValueToReplaceIsNonPositive(){
        Assertions.assertThrows(IllegalArgumentException.class, () -> service.replace(-1, BUZZER));
    }

    @Test
    public void shouldPlayFizzBuzzTo15(){
        Mockito.when(repo.retrieveFizzBuzzesForSession(Mockito.anyString())).thenReturn(BUZZER);
        List<String> expected = new ArrayList<>(){{
            add("1");
            add("2");
            add("Fizz");
            add("4");
            add("Buzz");
            add("Fizz");
            add("7");
            add("8");
            add("Fizz");
            add("Buzz");
            add("11");
            add("Fizz");
            add("13");
            add("14");
            add("FizzBuzz");
        }};
        Assert.assertEquals(expected, service.playFizzBuzz(15));
    }
}
