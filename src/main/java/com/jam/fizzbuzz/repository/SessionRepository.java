package com.jam.fizzbuzz.repository;

import com.jam.fizzbuzz.entity.FizzBuzz;
import com.jam.fizzbuzz.entity.Session;
import com.jam.fizzbuzz.entity.SessionEntry;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public interface SessionRepository extends CrudRepository<Session, Integer> {

    @Query(value="SELECT s From Session s where s.sessionId = ?1")
    Session retrieveSessionData(String sessionId);

    default List<FizzBuzz> retrieveFizzBuzzesForSession(String sessionId){
        Session s = retrieveSessionData(sessionId);
        return s.getSessionEntries().stream()
                .map(SessionEntry::getFizzBuzz)
                .sorted()
                .collect(Collectors.toList());
    }
}
