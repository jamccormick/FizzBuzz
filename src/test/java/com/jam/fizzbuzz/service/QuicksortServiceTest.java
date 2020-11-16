package com.jam.fizzbuzz.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@ExtendWith(MockitoExtension.class)
public class QuicksortServiceTest {

    @InjectMocks
    private QuicksortService service;

    @Test
    public void shouldReturnTheSameNumber(){
        List<Integer> before = new ArrayList<>(){{add(1);}} ;
        List<Integer> after = service.quicksort(before);
        Assertions.assertEquals(before, after);
    }

    @Test
    public void shouldReturnATwoElementSortedArray(){
        List<Integer> before = new ArrayList<>(){{add(3); add(1);}};
        List<Integer> expected = new ArrayList<>(){{add(1); add(3);}};
        List<Integer> actual = service.quicksort(before);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldReturnAThreeElementSortedArray(){
        List<Integer> before = new ArrayList<>(){{add(3); add(1); add(2);}};
        List<Integer> expected = new ArrayList<>(){{add(1); add(2); add(3);}};
        List<Integer> actual = service.quicksort(before);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void shouldQuicksortForReal(){
        List<Integer> before = new ArrayList<>(){{
           add(1);
           add(2);
           add(3);
           add(4);
           add(5);
           add(6);
           add(7);
           add(8);
           add(9);
           add(10);
        }};
        Collections.shuffle(before);
        Assertions.assertEquals(10, before.size());
        Assertions.assertFalse(isSorted(before));
        List<Integer> sorted = service.quicksort(before);
        Assertions.assertTrue(isSorted(sorted));
        Assertions.assertEquals(before.size(), sorted.size());
    }

    @Test
    public void shouldReturnAnEquivalentListWhenElementsAreSorted(){
        List<Integer> before = new ArrayList<>(){{add(1); add(2); add(3); add(4); add(5);}};
        List<Integer> sorted = service.quicksort(before);
        Assertions.assertEquals(before, sorted);
    }

    public static boolean isSorted(List<Integer> check){
        for(int i = 0; i < check.size() - 1; i++){
            if (check.get(i) > check.get(i + 1)){
                return false;
            }
        }
        return true;
    }
}
