package com.illhab.illhabServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class IllhabServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(IllhabServerApplication.class, args);
    }

}
