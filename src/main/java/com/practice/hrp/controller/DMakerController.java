package com.practice.hrp.controller;
import com.practice.hrp.dto.CreateDeveloper;
import com.practice.hrp.service.DMakerService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@Slf4j
@RestController  // = @Controller and @ResponseBody
@RequiredArgsConstructor
public class DMakerController {

    private final DMakerService dMakerService;


    @GetMapping("/developers")
    public List<String> getAllDevelopers() {
//      GET /developers_HTTP/1.1
        log.info("GET /developers_HTTP/1.1");

        return Arrays.asList("snow", "elsa", "olaf");
    }

    @PostMapping("create-developers")
    public List<String> createDevelopers(
            @Valid @RequestBody CreateDeveloper.Request request
            ){
//      GET /create-developers_HTTP/1.1
        log.info("POST /create-developers_HTTP/1.1");
        log.info("request: {} ", request);

        dMakerService.createDeveloper(request);

//      return Arrays.asList("olaf");
        return List.of("olaf");

    }


}
