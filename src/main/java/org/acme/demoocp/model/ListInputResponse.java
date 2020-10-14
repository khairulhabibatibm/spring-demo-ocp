package org.acme.demoocp.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

public class ListInputResponse {

    @Setter @Getter private List<TodoInput> todos;
    
}
