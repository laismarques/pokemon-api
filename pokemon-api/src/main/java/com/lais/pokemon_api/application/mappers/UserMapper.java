package com.lais.pokemon_api.application.mappers;

import com.lais.pokemon_api.adapters.persistence.entity.UserEntity;
import com.lais.pokemon_api.domain.model.User;
import org.springframework.stereotype.Component;

@Component
public class UserMapper {
    public UserEntity convertToUserEntity(User user){
        return  new UserEntity(user.getName(), user.getEmail(), user.getFavoritePokemonNames());
    }
}
