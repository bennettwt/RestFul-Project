package com.rest.pokedex;

import org.springframework.web.bind.annotation.RestController;

import java.io.Serializable;

public class Pokemon implements Serializable {
    private Integer id;
    private String name;
    private String type;
    private String weakness;

    public Pokemon(Integer id, String name, String type, String weakness){
        this.id = id;
        this.name = name;
        this.type = type;
        this.weakness = weakness;
    }

    public Integer getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getWeakness() { return weakness; }
    public void setWeakness(String weakness) { this.weakness = weakness; }
}
