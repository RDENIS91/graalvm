package com.graalvm.reflection;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ReflectionApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ReflectionApplication.class, args);
    }

    private static final Logger LOGGER = LoggerFactory.getLogger(ReflectionApplication.class);

    public void run(String... args) {
        Foo foo = new Foo();
        Bar bar = new Bar(foo);
        System.out.println("Start printing... \n \n");
        LOGGER.info(bar.bar());
    }
}
