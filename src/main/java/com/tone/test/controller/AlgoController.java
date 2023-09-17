package com.tone.test.controller;

import com.tone.test.service.AlgoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/algo")
public class AlgoController {
    private final AlgoService algoService;

    @PostMapping
    public String count(@RequestBody String letters){
        return algoService.count(letters);
    }
}
