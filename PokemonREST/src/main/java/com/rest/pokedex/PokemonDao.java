package com.rest.pokedex;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.util.SerializationUtils;
import org.springframework.web.server.ResponseStatusException;
import redis.clients.jedis.BinaryJedis;
import redis.clients.jedis.Jedis;

import java.util.*;

@Repository
public class PokemonDao {
    private static BinaryJedis jedis;
    private static String password;
    private static ObjectMapper mapper;

    public PokemonDao(){
        jedis = new Jedis("192.168.1.64");
        password = "Katie10212";
        mapper = new ObjectMapper();
        jedis.auth(password);
        jedis.select(1);
        initPokemon();
    }

    private static void initPokemon() {
        Pokemon pok1 = new Pokemon(1, "Bulbasaur", "Grass", "Fire");
        Pokemon pok2 = new Pokemon(2, "Squirtle", "Water", "Grass");
        Pokemon pok3 = new Pokemon(3, "Charmander", "Fire", "Water");

        jedis.auth(password);
        jedis.set(String.valueOf(pok1.getId()).getBytes(), SerializationUtils.serialize(pok1));
        jedis.set(String.valueOf(pok2.getId()).getBytes(), SerializationUtils.serialize(pok2));
        jedis.set(String.valueOf(pok3.getId()).getBytes(), SerializationUtils.serialize(pok3));
        jedis.save();


    }

    public List<Pokemon> findAll() {
        Set<byte[]> set = new TreeSet<byte[]>();
        List<Pokemon> allPokes = new ArrayList<>();
        jedis.auth(password);
        set = jedis.keys("*".getBytes());
        for(byte[] b : set){
            byte[] array = jedis.get(b);
            Pokemon p = (Pokemon) SerializationUtils.deserialize(array);
            allPokes.add(p);
        }
        return allPokes;
    }

    public Pokemon findByID(int id){
       return (Pokemon) SerializationUtils.deserialize(jedis.get(String.valueOf(id).getBytes()));
    }

    public void save(Pokemon poke) throws ResponseStatusException{

        Set<byte[]> set = new HashSet<>();
        List<Pokemon> allPokes = new ArrayList<>();
        set = jedis.keys("*".getBytes());
        for(byte[] b : set){
            byte[] array = jedis.get(b);
            Pokemon p = (Pokemon) SerializationUtils.deserialize(array);
            allPokes.add(p);
        }
        for(Pokemon p : allPokes){
            if(compareTo(p, poke) == 0) {
                throw new ResponseStatusException(HttpStatus.CONFLICT, "That pokemon already exists.");
            }
        }
        jedis.set(String.valueOf(poke.getId()).getBytes(), SerializationUtils.serialize(poke));
    }

    public void update(Pokemon poke, int id){
        byte[] pBytes = jedis.get(String.valueOf(id).getBytes());
        Pokemon p = (Pokemon) SerializationUtils.deserialize(pBytes);
        if(poke.getId() != null){
            p.setId(poke.getId());
        }
        if(poke.getName() != null){
            p.setName(poke.getName());
        }
        if(poke.getType() != null){
            p.setType(poke.getType());
        }
        if(poke.getWeakness() != null){
            p.setWeakness(poke.getWeakness());
        }

        jedis.set(String.valueOf(p.getId()).getBytes(), SerializationUtils.serialize(p));
    }

    public void delete(int id){
        long del = jedis.del(String.valueOf(id).getBytes());
        if(del == 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The Pokemon with that ID doesn't exist");
        }
    }

    public int compareTo(Pokemon pokemon1, Pokemon pokemon2) {
        int retVal = -1;
        if(pokemon1.getId().intValue() == pokemon2.getId().intValue() &&
                pokemon1.getName().equals(pokemon2.getName()) &&
                pokemon1.getType().equals(pokemon2.getType()) &&
                pokemon1.getWeakness().equals(pokemon2.getWeakness())){
            retVal = 0;
        }
        return retVal;
    }


}
