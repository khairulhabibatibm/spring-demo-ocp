package org.acme.demoocp.repository;

import java.util.List;

import org.acme.demoocp.entity.TodoEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends CrudRepository<TodoEntity,String> {
    
}
