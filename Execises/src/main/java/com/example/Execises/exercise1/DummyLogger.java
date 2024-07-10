package com.example.Execises.exercise1;

//TODO: Implement a Logger class thats says "Hello from task1"

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@Slf4j //interfaz que crea un logger llamado log
public class DummyLogger implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        log.info("Hello from task1");
    }
    public void hello(){
        log.info("Hello from DummyLogger");
    }
}
