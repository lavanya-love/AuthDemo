package com.interview.prep;

import com.interview.prep.service.UserServiceClient;
import feign.Feign;
import feign.jackson.JacksonDecoder;
import feign.jackson.JacksonEncoder;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.cloud.openfeign.support.SpringMvcContract;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableFeignClients
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public UserServiceClient userServiceClient() {
        return Feign.builder()
                .contract(new SpringMvcContract())
                .decoder(new JacksonDecoder())
                .encoder(new JacksonEncoder())
                .target(UserServiceClient.class, "http://localhost:8080");
    }
}
