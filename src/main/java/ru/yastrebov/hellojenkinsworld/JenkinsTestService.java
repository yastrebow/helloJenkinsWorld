package ru.yastrebov.hellojenkinsworld;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicLong;
@Component
@RequiredArgsConstructor
public class JenkinsTestService {
    private final AtomicLong counter = new AtomicLong();
    public String greeting(String greetings, String name) {
        return String.format(greetings, name);
    }
}
