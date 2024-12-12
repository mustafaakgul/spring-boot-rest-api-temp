package org.concept.springbootrestapitemp.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AppController {

    @GetMapping("/health-check")
    public String healthCheck() {
        return "OK";
    }
}
