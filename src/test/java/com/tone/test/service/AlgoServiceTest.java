package com.tone.test.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class AlgoServiceTest {
    @Spy
    private ObjectMapper objectMapper;
    @InjectMocks
    private AlgoService algoService;

    @Test
    public void validationThrowExceptionTest(){
        String invalidInput = "";

        assertThrows(RuntimeException.class, () -> algoService.count(invalidInput));
    }

    @Test
    public void countReturnsRightResultTest(){
        String input = "caabab";
        String expectedResult = "{\"a\":3,\"b\":2,\"c\":1}";

        assertEquals(expectedResult, algoService.count(input));
    }
}