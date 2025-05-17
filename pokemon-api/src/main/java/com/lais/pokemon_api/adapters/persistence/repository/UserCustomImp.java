package com.lais.pokemon_api.adapters.persistence.repository;

import com.lais.pokemon_api.adapters.persistence.entity.UserEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UserCustomImp implements UserRepositoryCustom{


    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public void addFavorites(String email, List<String> pokemon){
        System.out.println("MONGO DB");
        System.out.println(pokemon);
        Query query = new Query(Criteria.where("email").is(email));
        Update update = new Update().addToSet("favoritePokemonsName ").each(pokemon);
        mongoTemplate.updateFirst(query, update, UserEntity.class);
    }

    @Override
    public void deleteByEmail(String email, List<String> pokemon){
        System.out.println("USER CUSTOM: "+ email + pokemon);
        Query query = new Query(Criteria.where("email").is(email));
        Update update = new Update().pullAll("favoritePokemonsName", pokemon.toArray());
        System.out.println(update);
        mongoTemplate.updateFirst(query, update, UserEntity.class);

    }
}
