package com.mclearn.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/admin")
public class AdminController {
   /* @Autowired
    private WebClient webClient;*/
    @GetMapping
    public HashMap<String, String> getName() {
        HashMap<String, String> result = new HashMap<>();
        result.put("message" , "Hi from admin");
        return result;
    }

  /*  @GetMapping("/student")
    public HashMap<String, String> getAllStudents() {
        Gson g = new Gson();
        *//*return webClient.get().uri("http://localhost:8081/student").
                retrieve().bodyToMono(HashMap.class).block();*//*
    }*/
}
