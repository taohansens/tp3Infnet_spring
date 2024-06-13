package org.taohansen.tp3infnet_spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableCaching
@SpringBootApplication
@EnableJpaRepositories(basePackages = "org.taohansen.tp3infnet_spring.repositories")
public class Tp3infnetSpringApplication {
    public static void main(String[] args) {
        SpringApplication.run(Tp3infnetSpringApplication.class, args);
    }

}
