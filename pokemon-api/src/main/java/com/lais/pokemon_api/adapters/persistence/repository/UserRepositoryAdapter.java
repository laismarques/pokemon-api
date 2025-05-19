package com.lais.pokemon_api.adapters.persistence.repository;

import com.lais.pokemon_api.adapters.persistence.entity.UserEntity;
import com.lais.pokemon_api.application.mappers.UserMapper;
import com.lais.pokemon_api.domain.gatway.RepostoryGatway;
import com.lais.pokemon_api.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserRepositoryAdapter implements RepostoryGatway {
    @Autowired
    private UserRepository userRepository;
    private UserMapper userMapper;
    private  UserRepositoryCustom userRepositoryCustom;

    public UserRepositoryAdapter(UserRepository userRepository, UserMapper userMapper, UserRepositoryCustom userRepositoryCustom) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userRepositoryCustom = userRepositoryCustom;
    }

    @Override
    public void save(User user){
        UserEntity userEntity = userMapper.convertToUserEntity(user);
        UserEntity usuarioSalvo = userRepository.save(userEntity);

    }

    @Override
    public List<String> getFavorites(String email){
        UserEntity user = userRepository.findByEmail(email);
        return  user.getFavoritePokemonsName();
    }

    @Override
    public void addFavorites(String email, List<String> pokemon){
        userRepositoryCustom.addFavorites(email, pokemon);
    }

    @Override
    public void delete(String email, List<String> pokemon){
        userRepositoryCustom.deleteByEmail(email, pokemon);
    }

    @Override
    public boolean userExists(String email){
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean validateFavorite(String email, String pokemonName){
        return userRepositoryCustom.validateFavorite(email, pokemonName);
    }

}
