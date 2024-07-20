package edu.campus.campusLeopoldoMarechal.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class control {
    
    @GetMapping("/cliente")
    public String test(){
        return "Prueba";
    }
}
