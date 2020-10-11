package org.acme.demoocp.model;

import lombok.Getter;
import lombok.Setter;

public class DemoInput {
    
    @Setter @Getter private Long id;
    @Setter @Getter private String title;
    @Setter @Getter private String description;
    @Setter @Getter private Boolean published;

}
