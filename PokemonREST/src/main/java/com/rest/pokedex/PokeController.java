package com.rest.pokedex;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PokeController {

    private final PokemonDao dao;

    public PokeController(PokemonDao dao){
        this.dao = dao;
    }

    @GetMapping("/pokemon")
    List<Pokemon> all(){
        return dao.findAll();
    }

    @PostMapping("/pokemon")
    void newPokemon(@RequestBody Pokemon poke){
        dao.save(poke);
    }
}
