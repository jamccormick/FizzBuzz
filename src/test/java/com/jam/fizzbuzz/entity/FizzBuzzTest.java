package com.jam.fizzbuzz.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class FizzBuzzTest {
    @Test
    public void shouldSuccessfullyCompareTwoObjects(){
       FizzBuzz fizz = new FizzBuzz(3, "Fizz", 1);
       FizzBuzz buzz = new FizzBuzz();
       buzz.setIpk(1);
       buzz.setCounter(5);
       buzz.setReplacement("Buzz");
       buzz.setOrdinal(2);
       Assertions.assertTrue(fizz.compareTo(buzz) < 0);
       Assertions.assertEquals(0, fizz.getIpk());
       Assertions.assertEquals(1, fizz.getOrdinal());
       Assertions.assertEquals("Fizz", fizz.getReplacement());
       Assertions.assertEquals(3, fizz.getCounter());
    }

    @Test
    public void shouldFailToCompareUnlikeObjects(){
        FizzBuzz fizz = new FizzBuzz(3, "Fizz", 1);
        String buzz = "buzz";
        Assertions.assertThrows(IllegalArgumentException.class, () -> fizz.compareTo(buzz));
    }
}
