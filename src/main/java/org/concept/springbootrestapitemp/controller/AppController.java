package org.concept.springbootrestapitemp.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/v1/app")
public class AppController {

    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }
}
