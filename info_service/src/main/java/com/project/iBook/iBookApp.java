package com.project.iBook;

import com.project.iBook.util.AmazonSearch;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@SpringBootApplication
public class iBookApp {
    public static void main(String[] args) {
        SpringApplication.run(iBookApp.class, args);
    }
}
