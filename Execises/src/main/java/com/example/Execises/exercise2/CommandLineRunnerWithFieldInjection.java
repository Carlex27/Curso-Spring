package com.example.Execises.exercise2;

import com.example.Execises.exercise1.DummyLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * CommandLineRunnerWithFieldInjection
 * A component that implements DummyLogget with Field injection
 */
@Component
public class CommandLineRunnerWithFieldInjection implements CommandLineRunner {
    @Autowired
    private DummyLogger dummyLogger;

    @Override
    public void run(String... args) throws Exception {
        dummyLogger.hello();
    }

}
