package com.jam.fizzbuzz.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class SessionEntryTest {
    @Test
    public void shouldCreateASessionEntry(){
        SessionEntry se = new SessionEntry();
        se.setFizzBuzz(new FizzBuzz(3, "Fizz", 1));
        se.setSessionEntryKey(1);
        se.setSession(new Session("test"));
        Assertions.assertEquals(new FizzBuzz(3, "Fizz", 1), se.getFizzBuzz());
        Assertions.assertEquals(new Session("test"), se.getSession());
        Assertions.assertEquals(1, se.getSessionEntryKey());
    }
}
