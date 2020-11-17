package com.jam.fizzbuzz.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {
    @Test
    public void shouldSuccessfullyCompareTwoObjects(){
       FizzBuzz fizz = new FizzBuzz(3, "Fizz", 1);
       FizzBuzz buzz = new FizzBuzz();
       buzz.setFizzBuzzKey(1);
       buzz.setCounter(5);
       buzz.setReplacement("Buzz");
       buzz.setOrdinal(2);
       Assertions.assertTrue(fizz.compareTo(buzz) < 0);
       Assertions.assertEquals(0, fizz.getFizzBuzzKey());
       Assertions.assertEquals(1, fizz.getOrdinal());
       Assertions.assertEquals("Fizz", fizz.getReplacement());
       Assertions.assertEquals(3, fizz.getCounter());
    }

    @Test
    public void shouldEqual(){
        FizzBuzz f1 = new FizzBuzz(1, "one", 1);
        FizzBuzz f2 = f1;
        Assertions.assertTrue(f1.equals(f2));
    }

    @Test
    public void shouldNotEqual(){
        FizzBuzz fizz = new FizzBuzz(3, "Fizz", 1);
        FizzBuzz buzz = new FizzBuzz(5, "Fizz", 1);
        Assertions.assertFalse(fizz.equals(buzz));
    }

    @Test
    public void shouldNotEqual2(){
        FizzBuzz fizz = new FizzBuzz(3, "Fizz", 1);
        FizzBuzz buzz = new FizzBuzz(3, "Buzz", 1);
        Assertions.assertFalse(fizz.equals(buzz));
    }

    @Test
    public void shouldNotEqual3(){
        FizzBuzz fizz = new FizzBuzz(3, "Fizz", 1);
        FizzBuzz buzz = new FizzBuzz(3, "Fizz", 2);
        Assertions.assertFalse(fizz.equals(buzz));
    }

    @Test
    public void shouldNotEqual4(){
        FizzBuzz fizz = new FizzBuzz(3, "Fizz", 1);
        FizzBuzz buzz = new FizzBuzz(5, "Buzz", 1);
        Assertions.assertFalse(fizz.equals(buzz));
    }

    @Test
    public void shouldNotEqual5(){
        FizzBuzz fizz = new FizzBuzz(3, "Fizz", 1);
        FizzBuzz buzz = new FizzBuzz(5, "Fizz", 2);
        Assertions.assertFalse(fizz.equals(buzz));
    }

    @Test
    public void shouldNotEqual6(){
        FizzBuzz fizz = new FizzBuzz(3, "Fizz", 1);
        FizzBuzz buzz = new FizzBuzz(3, "Buzz", 2);
        Assertions.assertFalse(fizz.equals(buzz));
    }

    @Test
    public void shouldNotEqual7(){
        FizzBuzz fizz = new FizzBuzz(3, "Fizz", 1);
        FizzBuzz buzz = new FizzBuzz(5, "Buzz", 2);
        Assertions.assertFalse(fizz.equals(buzz));
    }

    @Test
    public void shouldFail(){
        FizzBuzz fizz = new FizzBuzz(3, "Fizz", 1);
        Object o = new Object();
        Assertions.assertThrows(IllegalArgumentException.class, () -> fizz.equals(o));
    }
}
