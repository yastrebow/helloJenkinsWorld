package ru.yastrebov.hellojenkinsworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
@RequestMapping("/hello")
public class JenkinsTestController {
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @GetMapping
    public JenkinsTest greeting(@RequestParam(value = "name", required = false, defaultValue = "JenkinsUser") String name) {
        return new JenkinsTest(counter.incrementAndGet(),
                String.format(template,name));
    }
}
