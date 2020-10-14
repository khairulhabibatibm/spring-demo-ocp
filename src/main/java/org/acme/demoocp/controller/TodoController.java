package org.acme.demoocp.controller;

import java.util.List;

import org.acme.demoocp.model.TodoInput;
import org.acme.demoocp.model.ModelResponse;
import org.acme.demoocp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*",allowedHeaders = "*")
@RestController()
public class TodoController{

    @Autowired
    private TodoService service;

    @GetMapping("/todo")
    public List<TodoInput> getAll(){
        System.out.println("in get demo");
        return service.getAll();
    }

    @PostMapping("/todo")
    public ModelResponse add(@RequestBody TodoInput tutorial){
        System.out.println("in add demo > " + tutorial.getDescription());
        String result = service.addTodo(tutorial);
        ModelResponse response = new ModelResponse();
        response.setId(result);
        response.setMessage("success");
        return response;
    }
}