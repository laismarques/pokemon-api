package com.lais.pokemon_api.application.dto;

import java.util.List;

public class PokemonSummaryDto {
    private Integer total;
    private  List<String> pokemonsName;

    public PokemonSummaryDto(Integer total, List<String> pokemonsName) {
        this.total = total;
        this.pokemonsName = pokemonsName;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<String> getPokemonsName() {
        return pokemonsName;
    }

    public void setPokemonsName(List<String> pokemonsName) {
        this.pokemonsName = pokemonsName;
    }
}
