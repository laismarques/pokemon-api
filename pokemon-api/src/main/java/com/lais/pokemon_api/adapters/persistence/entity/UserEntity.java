package com.lais.pokemon_api.adapters.persistence.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;

@Document(collection  = "favorite_pokemon")
public class UserEntity {
    @Id
    private String id;
    private String name;
    @Indexed(unique = true)
    private String email;
    private List<String> favoritePokemonsName;


    public UserEntity(String name, String email, List<String> favoritePokemonsName) {
        this.name = name;
        this.email = email;
        this.favoritePokemonsName = favoritePokemonsName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<String> getFavoritePokemonsName() {
        return favoritePokemonsName;
    }

    public void setFavoritePokemonsName(List<String> favoritePokemonsName) {
        this.favoritePokemonsName = favoritePokemonsName;
    }
}
