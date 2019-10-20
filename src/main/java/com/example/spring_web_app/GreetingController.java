package com.example.spring_web_app;

import com.example.spring_web_app.domain.Laptop;
import com.example.spring_web_app.repos.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController {
    @Autowired
    private LaptopRepository laptopRepository;

    @RequestMapping("/index")
    public Iterable<Laptop> index(@RequestParam(value = "x1", defaultValue = "hello") String x1,
                                  @RequestParam(value = "x2") String x2) {
        System.out.println(x1+x2);
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setAccessControlAllowOrigin("*");
        return laptopRepository.findAll();

    }
}