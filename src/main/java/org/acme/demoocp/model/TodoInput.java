package org.acme.demoocp.model;

import lombok.Getter;
import lombok.Setter;

public class TodoInput {
    
    @Setter @Getter private String description;
    @Setter @Getter private Boolean completed;

    public TodoInput(){

    }

    public TodoInput(String description, Boolean completed){
        this.description = description;
        this.completed = completed;
    }

}
