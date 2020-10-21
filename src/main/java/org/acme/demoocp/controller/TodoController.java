package org.acme.demoocp.controller;

import java.util.List;

import org.acme.demoocp.model.TodoInput;
import org.acme.demoocp.model.ListInputResponse;
import org.acme.demoocp.model.ModelResponse;
import org.acme.demoocp.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class TodoController{

    @Autowired
    private TodoService service;

    @CrossOrigin(origins = "*")
    @GetMapping("/todo")
    public ListInputResponse getAll(){
        System.out.println("in getAll() -- 3: ");
        ListInputResponse response = new ListInputResponse();
        response.setTodos(service.getAll());
        return response;
    }

    @CrossOrigin(origins = "*")
    @PostMapping("/todo")
    public ModelResponse add(@RequestBody TodoInput tutorial){
        System.out.println("in add() -- 3: " + tutorial.getDescription());
        String result = service.addTodo(tutorial);
        ModelResponse response = new ModelResponse();
        response.setId(result);
        response.setMessage("success");
        return response;
    }
}