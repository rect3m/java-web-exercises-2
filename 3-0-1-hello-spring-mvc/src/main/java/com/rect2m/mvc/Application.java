package com.rect2m.mvc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class Application {
    public static void main(String[] args) {
        SpringApplication.run(com.rect2m.mvc.Application.class, args);
    }

    @GetMapping("/")
    public String Main(Model model) {
        return "Main";
    }
}
