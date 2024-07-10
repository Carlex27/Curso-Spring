package com.example.Execises.exercise2;

import com.example.Execises.exercise1.DummyLogger;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * CommandLineRunnerWithConstructorInjection
 * A component that implements DummyLogget with Contructor injection
 */
@Component
@RequiredArgsConstructor
public class CommandLineRunnerWithConstructorInjection implements CommandLineRunner {
    private final DummyLogger dummyLogger;

    @Override
    public void run(String... args) throws Exception {
        dummyLogger.hello();
    }


}
