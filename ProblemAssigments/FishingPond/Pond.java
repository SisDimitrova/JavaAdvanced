package fishingPond;

import java.util.ArrayList;
import java.util.List;

public class Pond {
    private int capacity;
    private List<Fish> 	fishes;

    public Pond(int capacity) {
        this.capacity = capacity;
        this.fishes = new ArrayList<>();
    }

    public void addFish(Fish fish) {
        if (capacity > fishes.size()) {
            fishes.add(fish);
        }
    }

    public boolean removeFish(String species) {
        for (Fish fish : this.fishes) {
           if (fish.getSpecies().equals(species)) {
               return this.fishes.remove(fish);
           }
        }
        return false;
    }

    public Fish getOldestFish() {
        Fish oldesFish = null;
        for (Fish fish : this.fishes) {
            if (oldesFish == null) {
                oldesFish = fish;
            }
            if (fish.getAge() > oldesFish.getAge()) {
                oldesFish = fish;
            }
        }
        return oldesFish;
    }
    public Fish getFish(String species) {
        Fish getFish = null;
        for (Fish fish : this.fishes) {
            if (fish.getSpecies().equals(species)) {
                getFish = fish;
            }
        }
        return getFish;
    }
    public int getCount() {
        return this.fishes.size();
    }

    public int getVacancies() {
        return this.capacity - this.fishes.size();
    }

    public String report() {
       StringBuilder sb = new StringBuilder();
       sb.append("Fishes in the pond:").append(System.lineSeparator());
        for (Fish fish : this.fishes) {
          sb.append("This " + fish.getSpecies() + " is " + fish.getAge() + " years old and reproduces through "
          + fish.getMatingSeason() + ".");
          sb.append(System.lineSeparator());
        }
        return sb.toString();
    }
}
