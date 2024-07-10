package com.example.Execises.exercise3;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component("SecondImplementation")
public class SecondImplementation implements DummyLogger{
    @Override
    public void sayHello(){
        log.info("Hello from SecondImplementation!");
    }
}
