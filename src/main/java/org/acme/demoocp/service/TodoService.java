package org.acme.demoocp.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.acme.demoocp.entity.TodoEntity;
import org.acme.demoocp.model.TodoInput;
import org.acme.demoocp.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {

    @Autowired
    private TodoRepository repository;

    public String addTodo(TodoInput input){
        TodoEntity entity = new TodoEntity();
        System.out.println("input > " + input.getDescription() + ", " + input.getCompleted());
        entity.setDescription(input.getDescription());
        entity.setCompleted(input.getCompleted());
        entity = repository.save(entity);
        return String.valueOf(entity.getId());
    }

    public List<TodoInput> getAll(){
        try {
            Iterable<TodoEntity> result = repository.findAll();
            List<TodoInput> response = new ArrayList<>();
            for(Iterator<TodoEntity> iter = result.iterator();iter.hasNext();){
                TodoEntity entity = iter.next();
                TodoInput todo = new TodoInput();
                System.out.println("entity description > " + entity.getDescription());
                System.out.println("entity id > " + entity.getId());
                todo.setDescription(entity.getDescription());
                todo.setCompleted(entity.getCompleted());
                todo.setComment("Default Comment");
                response.add(todo);
            }
            return response;    
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
        
    }
    
}
