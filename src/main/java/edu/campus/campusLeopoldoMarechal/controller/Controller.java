package edu.campus.campusLeopoldoMarechal.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class Controller {

    @GetMapping("/test")
    public String getMethodName(@RequestParam String param) {
        return param;
    }
    

}
