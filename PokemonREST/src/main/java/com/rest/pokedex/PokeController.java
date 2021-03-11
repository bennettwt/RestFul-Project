package com.rest.pokedex;

import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/pokemon/{id}")
    Pokemon getByID(@PathVariable int id){
        return dao.findByID(id);
    }

    @PostMapping("/pokemon")
    void newPokemon(@RequestBody Pokemon poke){
        dao.save(poke);
    }

    @PutMapping("/pokemon/{id}")
    void updatePokemon(@RequestBody Pokemon poke, @PathVariable int id){
        dao.update(poke, id);
    }

    @DeleteMapping("/pokemon/{id}")
    void deletePokemon(@PathVariable int id){
        dao.delete(id);
    }

     // TODO
     // pokemon query will be its pokedex ID
     // TM id in redis will be its name ex TM02
    // if user tries to look up a tm that a pokemon cant learn send back an error that it cant learn it
}
