package org.acme.demoocp.model;

import lombok.Getter;
import lombok.Setter;

public class TodoInput {
    
    @Setter @Getter private String description;
    @Setter @Getter private Boolean completed;
    @Setter @Getter private String comment;

    public TodoInput(){

    }

    public TodoInput(String description, Boolean completed){
        this.description = description;
        this.completed = completed;
    }

}
