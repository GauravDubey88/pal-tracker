package io.pivotal.pal.tracker;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class WelcomeController {

    String welcomeMessage = null;

    public WelcomeController(@Value("${welcome.message}") String Message){
        welcomeMessage = Message;
    }

    @GetMapping("/")
    public String sayHello() {

        return welcomeMessage;

    }

}

