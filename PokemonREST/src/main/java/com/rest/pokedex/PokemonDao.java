package com.rest.pokedex;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class PokemonDao {
    private static final Map<Integer, Pokemon> pokeMap = new HashMap<Integer, Pokemon>();

    static{
        initPokemon();
    }

    private static void initPokemon(){
        Pokemon pok1 = new Pokemon(1, "Bulbasaur", "Grass", "Fire");
        Pokemon pok2 = new Pokemon(2, "Squirtle", "Water", "Grass");
        Pokemon pok3 = new Pokemon(3, "Charmander", "Fire", "Water");

        pokeMap.put(pok1.getId(), pok1);
        pokeMap.put(pok2.getId(), pok2);
        pokeMap.put(pok3.getId(), pok3);
    }

    public List<Pokemon> findAll(){
        List<Pokemon> list = new ArrayList<>();
        Set<Map.Entry<Integer, Pokemon>> set = pokeMap.entrySet();
        for(Map.Entry p : set){
            list.add((Pokemon) p.getValue());
        }
        return list;
    }

    public void save(Pokemon poke){
        pokeMap.put(poke.getId(), poke);
    }
}
