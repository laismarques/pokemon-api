package com.lais.pokemon_api.adapters.pokeapi.dto;

import java.util.List;

public class PokeDetailDto {
    String name;
    private List<PokeDetailDto.TypeSlot> types;
    private List<PokeDetailDto.AbilitySlot> abilities;
    private int height;
    private int weight;
    private PokeDetailDto.Sprites sprites;
    private List<PokeDetailDto.StatSlot> stats;

    // Getters e Setters
    public List<PokeDetailDto.TypeSlot> getTypes() {
        return types;
    }

    public void setTypes(List<PokeDetailDto.TypeSlot> types) {
        this.types = types;
    }

    public List<PokeDetailDto.AbilitySlot> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<PokeDetailDto.AbilitySlot> abilities) {
        this.abilities = abilities;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public PokeDetailDto.Sprites getSprites() {
        return sprites;
    }

    public void setSprites(PokeDetailDto.Sprites sprites) {
        this.sprites = sprites;
    }

    public List<PokeDetailDto.StatSlot> getStats() {
        return stats;
    }

    public void setStats(List<PokeDetailDto.StatSlot> stats) {
        this.stats = stats;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static class TypeSlot {
        private PokeDetailDto.Type type;

        public PokeDetailDto.Type getType() {
            return type;
        }

        public void setType(PokeDetailDto.Type type) {
            this.type = type;
        }
    }

    public static class Type {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class AbilitySlot {
        private PokeDetailDto.Ability ability;

        public PokeDetailDto.Ability getAbility() {
            return ability;
        }

        public void setAbility(PokeDetailDto.Ability ability) {
            this.ability = ability;
        }
    }

    public static class Ability {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static class Sprites {
        private String front_default;

        public String getFront_default() {
            return front_default;
        }

        public void setFront_default(String front_default) {
            this.front_default = front_default;
        }
    }

    public static class StatSlot {
        private int base_stat;
        private PokeDetailDto.Stat stat;

        public int getBase_stat() {
            return base_stat;
        }

        public void setBase_stat(int base_stat) {
            this.base_stat = base_stat;
        }

        public PokeDetailDto.Stat getStat() {
            return stat;
        }

        public void setStat(PokeDetailDto.Stat stat) {
            this.stat = stat;
        }
    }

    public static class Stat {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
