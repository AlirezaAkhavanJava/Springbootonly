package com.me;

import com.me.lifecycle.DumService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringBootOnly {
    static void main() {
        ApplicationContext context = SpringApplication.run(SpringBootOnly.class);
        DumService service = context.getBean(DumService.class);
        System.out.println(service.getAuthor());

    }
}
