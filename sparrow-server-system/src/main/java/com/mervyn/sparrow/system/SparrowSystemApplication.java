package com.mervyn.sparrow.system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 2hen9ao
 * @date 2024/3/5 10:13
 */
@RestController
@SpringBootApplication(scanBasePackages = {"com.mervyn.sparrow.system","com.mervyn.sparrow.config"})
public class SparrowSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(SparrowSystemApplication.class, args);
    }

    @GetMapping("/")
    public String state(){
        return " SparrowSystemApplication is running";
    }
}
