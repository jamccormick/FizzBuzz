package com.jam.fizzbuzz.repository;

import com.jam.fizzbuzz.entity.FizzBuzz;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FizzBuzzRepository extends CrudRepository<FizzBuzz, Integer> {

    @Query(value = "SELECT fizzbuzz FROM FizzBuzz fizzbuzz order by fizzbuzz.ordinal")
    List<FizzBuzz> retrieveAllElements();

    @Query(value = "SELECT fizzbuzz FROM FizzBuzz fizzbuzz where fizzbuzz.ipk = ?1")
    FizzBuzz findById();

}
