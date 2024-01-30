package PokemonTrainer_06;

import java.util.List;

public class Trainer {
    private String name;
    private int numberOfBadges;
    private List<Pokemon> collectionOfPokemon;

    public Trainer(String name, List<Pokemon> collectionOfPokemon) {
        this.name = name;
        this.numberOfBadges = 0;
        this.collectionOfPokemon = collectionOfPokemon;
    }

    public int getNumberOfBadgrs() {
        return numberOfBadges;
    }

    private boolean isExist(String command) {
        for (Pokemon pokemon : collectionOfPokemon) {
            if (pokemon.getElement().equals(command)) {   // proverka dali pokemona ima tozi element
                return true;
            }
        }
        return false;
    }
    public void commandExecuting (String command) {
        if (isExist(command)) {
            numberOfBadges++;
        } else {
            for (int i = 0; i < collectionOfPokemon.size(); i++) {
                collectionOfPokemon.get(i).setHealth(collectionOfPokemon.get(i).getHealth() - 10);
                //ot kolekciqta na poziciq (i) mi sloji na su6tata poziciq zdraveto - 10
                if (collectionOfPokemon.get(i).getHealth() <= 0) {
                    collectionOfPokemon.remove(i);
                    i--;
                }
            }
        }
    }

    @Override
    public String toString() {
        return name + " " + numberOfBadges + " " + collectionOfPokemon.size();
    }
}
