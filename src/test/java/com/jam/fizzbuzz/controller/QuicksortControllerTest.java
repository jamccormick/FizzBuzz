package com.jam.fizzbuzz.controller;

import com.jam.fizzbuzz.ro.QuicksortRO;
import com.jam.fizzbuzz.service.QuicksortService;
import com.jam.fizzbuzz.service.QuicksortServiceTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith({MockitoExtension.class})
public class QuicksortControllerTest {
    @InjectMocks
    private QuicksortController controller;

    @Mock
    private QuicksortService service;

    @Test
    public void shouldSuccessfullyQuicksort(){
        Mockito.when(service.quicksort(Mockito.anyList())).thenCallRealMethod();
        QuicksortRO result = controller.quicksort();
        Assertions.assertEquals(result.getUnsorted().size(), result.getSorted().size());
        Assertions.assertFalse(QuicksortServiceTest.isSorted(result.getUnsorted()));
        Assertions.assertTrue(QuicksortServiceTest.isSorted(result.getSorted()));
    }
}
