package com.example.spring_web_app;

import com.example.spring_web_app.domain.Laptop;
import com.example.spring_web_app.repos.LaptopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class GreetingController {
    @Autowired
    private LaptopRepository laptopRepository;
    @PostMapping(path="/add") // Map ONLY POST Requests
    public @ResponseBody
    String addNewUser (@RequestParam String name
            , @RequestParam int price) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        Laptop n = new Laptop();
        n.setName(name);
        n.setPrice(price);
        laptopRepository.save(n);
        return "Saved";
    }

    @RequestMapping(value = "/index", method = RequestMethod.GET)
    public ResponseEntity<String> index() {
        HttpHeaders responseHeaders = new HttpHeaders();
        responseHeaders.setAccessControlAllowOrigin("*");
        System.out.println("have");
        return new ResponseEntity<String>(laptopRepository.findAll().toString(), responseHeaders, HttpStatus.OK);

    }
}