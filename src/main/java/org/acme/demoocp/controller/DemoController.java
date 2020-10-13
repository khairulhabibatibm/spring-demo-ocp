package org.acme.demoocp.controller;

import java.util.List;

import org.acme.demoocp.model.DemoInput;
import org.acme.demoocp.model.ModelResponse;
import org.acme.demoocp.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class DemoController{

    @Autowired
    private DemoService service;

    @GetMapping("/demo")
    public List<DemoInput> hello(){
        System.out.println("in get demo");
        return service.getAll();
    }

    @CrossOrigin(origins = "http://localhost:8080")
    @PostMapping("/demo")
    public ModelResponse add(DemoInput tutorial){
        System.out.println("in add demo");
        String result = service.addDemo(tutorial);
        ModelResponse response = new ModelResponse();
        response.setId(result);
        response.setMessage("success");
        return response;
    }
}