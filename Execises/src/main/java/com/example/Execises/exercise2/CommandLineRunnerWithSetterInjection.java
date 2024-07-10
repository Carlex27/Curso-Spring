package com.example.Execises.exercise2;

import com.example.Execises.exercise1.DummyLogger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;


/**
 * CommandLineRunnerWithSetterInjection
 * A component that implements DummyLogget with Setter injection
 * the setter needs the @Autowired annotation for the dependency injection
 */
@Component
public class CommandLineRunnerWithSetterInjection implements CommandLineRunner {
    private DummyLogger dummyLogger;

    @Override
    public void run(String... args) throws Exception {
        dummyLogger.hello();
    }

    @Autowired
    public void setDummyLogger(DummyLogger dummyLogger){
        this.dummyLogger = dummyLogger;
    }

}
