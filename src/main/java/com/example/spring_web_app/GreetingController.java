package com.example.spring_web_app;

import java.util.concurrent.atomic.AtomicLong;

import org.apache.tomcat.util.http.parser.HttpParser;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @RequestMapping("/greeting")
    public Greeting greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping("/index")
    public ResponseEntity<String> index(@RequestParam(value = "x1", defaultValue = "hello") String x1,
                        @RequestParam(value = "x2") String x2) {
        System.out.println(x1+x2);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setAccessControlAllowOrigin("*");
        return new ResponseEntity<String>(x1+x2, responseHeaders, HttpStatus.OK);

    }
}