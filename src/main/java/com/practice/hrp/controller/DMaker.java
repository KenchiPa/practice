package com.practice.hrp.controller;
import com.practice.hrp.service.DMakerService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController  // = @Controller and @ResponseBody
@RequiredArgsConstructor
public class DMaker {

    private final DMakerService dMakerService;


    @GetMapping("/developers")
    public List<String> getAllDevelopers() {
//      GET /developers_HTTP/1.1
        log.info("GET /developers_HTTP/1.1");

        return Arrays.asList("snow", "elsa", "olaf");
    }

    @GetMapping("create-developers")
    public List<String> createDevelopers(){
//      GET /create-developers_HTTP/1.1
        log.info("GET /create-developers_HTTP/1.1");

        dMakerService.createDeveloper();
//      return Arrays.asList("olaf");
        return List.of("olaf");

    }


}
