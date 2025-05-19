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
        Query query = new Query(Criteria.where("email").is(email));
        Update update = new Update().addToSet("favoritePokemonsName").each(pokemon);
        mongoTemplate.updateFirst(query, update, UserEntity.class);
    }

    @Override
    public void deleteByEmail(String email, List<String> pokemon){
        Query query = new Query(Criteria.where("email").is(email));
        Update update = new Update().pullAll("favoritePokemonsName", pokemon.toArray());
        mongoTemplate.updateFirst(query, update, UserEntity.class);

    }

    @Override
    public boolean validateFavorite(String email, String pokemonName){

        Query query = new Query();
        query.addCriteria(
                new Criteria().andOperator(
                        Criteria.where("email").is(email),
                        Criteria.where("favoritePokemonsName").in(pokemonName)));


        long existsFavorite = mongoTemplate.count(query, UserEntity.class);
        return existsFavorite > 0;
    }


}
