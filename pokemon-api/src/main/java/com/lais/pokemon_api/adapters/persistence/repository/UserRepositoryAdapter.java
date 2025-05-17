package com.lais.pokemon_api.adapters.persistence.repository;

import com.lais.pokemon_api.adapters.persistence.entity.UserEntity;
import com.lais.pokemon_api.application.dto.UserFavoritePokemonDto;
import com.lais.pokemon_api.application.mappers.UserMapper;
import com.lais.pokemon_api.domain.gatway.ReposotoryGatway;
import com.lais.pokemon_api.domain.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class UserRepositoryAdapter implements ReposotoryGatway {
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
        System.out.println("REPOSITORY ADAPTER");
        System.out.println(userEntity.getEmail());
        UserEntity usuarioSalvo = userRepository.save(userEntity);
        System.out.println(usuarioSalvo.getId());
    }

    @Override
    public List<String> getFavorites(String email){
        UserEntity user = userRepository.findByEmail(email);
        return  user.getFavoritePokemonsName();
    }

    @Override
    public void addFavorites(String email, List<String> pokemon){
        System.out.println("ADAPTER: "+ email);
        userRepositoryCustom.addFavorites(email, pokemon);
    }

    @Override
    public void delete(String email, List<String> pokemon){
        System.out.println("ADAPTER: "+ email);
        userRepositoryCustom.deleteByEmail(email, pokemon);
    }

}
