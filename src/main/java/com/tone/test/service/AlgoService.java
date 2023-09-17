package com.tone.test.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class AlgoService {
    private final ObjectMapper objectMapper;

    public String count(String letters) {
        validateInputString(letters);

        Map<Character, Long> result = letters.chars()
                .mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(
                        character -> character,
                        Collectors.counting()
                ))
                .entrySet().stream().sorted((entry1, entry2) -> (int) (entry2.getValue() - entry1.getValue()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (l1, l2) -> l1,
                        LinkedHashMap::new));

        try {
            return objectMapper.writeValueAsString(result);
        } catch (JsonProcessingException e) {
            log.error("Mapping into json error: {}", e.getMessage());
            throw new RuntimeException(e);
        }
    }

    private void validateInputString(String s) {
        if(s.isBlank() || s.isEmpty()){
            throw new IllegalArgumentException("String must have at least one letter");
        }
    }
}
