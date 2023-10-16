package ru.yastrebov.hellojenkinsworld;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/hello")
public class JenkinsTestController {

    private final JenkinsTestService service;

    private static final String template = "Hello, %s!";

    @GetMapping
    public String greeting(@RequestParam(value = "name", required = false, defaultValue = "JenkinsUser") String name) {
        return service.greeting(template, name);
    }
}
