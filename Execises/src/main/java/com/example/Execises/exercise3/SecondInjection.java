package com.example.Execises.exercise3;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SecondInjection implements CommandLineRunner {
    private final DummyLogger dummyLogger;
    public SecondInjection(@Qualifier("SecondImplementation") final DummyLogger dummyLogger){
        this.dummyLogger = dummyLogger;
    }

    @Override
    public void run(String... args) throws Exception {
        dummyLogger.sayHello();
    }
}
