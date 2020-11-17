package com.jam.fizzbuzz.entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.util.ArrayList;

public class SessionTest {
    @Test
    public void shouldCreateASession(){
        Session s = new Session();
        s.setSessionEntries(new ArrayList<>());
        s.setSessionId("default");
        s.setSessionKey(1);
        s.setExpirationDate(new Date(0L));
        Assertions.assertEquals(new ArrayList<>(), s.getSessionEntries());
        Assertions.assertEquals("default", s.getSessionId());
        Assertions.assertEquals(1, s.getSessionKey());
        Assertions.assertEquals(new Date(0L), s.getExpirationDate());
    }

    @Test
    public void shouldEqual(){
        Session s = new Session("default");
        Session t = s;
        Assertions.assertTrue(s.equals(t));
    }

    @Test
    public void shouldNotEqual(){
        Session s = new Session("default");
        Session t = new Session ("T");
        Assertions.assertFalse(s.equals(t));
    }

    @Test
    public void shouldFailOnEquals(){
        Session s = new Session("default");
        Object o = new Object();
        Assertions.assertThrows(IllegalArgumentException.class, () -> s.equals(o));
    }
}
