package com.jam.fizzbuzz.repository;

import com.jam.fizzbuzz.entity.FizzBuzz;
import com.jam.fizzbuzz.entity.Session;
import com.jam.fizzbuzz.entity.SessionEntry;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
public class SessionRepositoryTest {

    @Mock
    private SessionRepository repo;

    @Test
    public void shouldGetFizzBuzz(){
        Session s = buildSession();
        Mockito.when(repo.retrieveSessionData(Mockito.anyString())).thenReturn(s);
        Mockito.when(repo.retrieveFizzBuzzesForSession(Mockito.anyString())).thenCallRealMethod();
        List<FizzBuzz> fizzBuzzes = repo.retrieveFizzBuzzesForSession("default");
        FizzBuzz fizz = new FizzBuzz(3, "Fizz", 1);
        FizzBuzz buzz = new FizzBuzz(5, "Buzz", 2);
        List<FizzBuzz> fizzBuzzList = List.of(fizz, buzz);
        Assertions.assertEquals(fizzBuzzList, fizzBuzzes);

    }

    private Session buildSession(){
        FizzBuzz fizz = new FizzBuzz(3, "Fizz", 1);
        FizzBuzz buzz = new FizzBuzz(5, "Buzz", 2);
        SessionEntry fizzEntry = new SessionEntry();
        fizzEntry.setFizzBuzz(fizz);
        SessionEntry buzzEntry = new SessionEntry();
        buzzEntry.setFizzBuzz(buzz);
        List<SessionEntry> entries = List.of(fizzEntry, buzzEntry);
        Session session = new Session();
        session.setSessionEntries(entries);
        session.setSessionId("default");
        return session;
    }
}
