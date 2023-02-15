package com.practice.hrp.controller;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController
public class MainController {


    @GetMapping("/developers")
    public List<String> getAllDevelopers() {
//      GET /developers_HTTP/1.1
        log.info("GET /developers_HTTP/1.1");

        return Arrays.asList("snow", "elsa", "olaf");
    }


}
