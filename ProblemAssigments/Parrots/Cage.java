package parrots;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Cage {

    private String name;
    private int capacity;
    private List<Parrot> data;

    public Cage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.data = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void add(Parrot parrot) {
        if (this.data.size() < this.capacity) {
            this.data.add(parrot);
        }
    }

    public boolean remove(String parrotName) {
        return this.data.removeIf(parrot -> parrot.getName().equals(parrotName));
    }

    public Parrot sellParrot(String name) {
        Parrot parrot = this.data.stream().filter(p -> p.getName().equals(name))
                .findFirst().orElse(null);
           if (null != parrot) {
               parrot.setAvailable(false);
           }
        return parrot;
    }

    public List<Parrot> sellParrotBySpecies(String species) {
        List<Parrot> parrotBySpecies = this.data.stream().filter(parrot -> parrot.getSpecies().equals(species))
                .collect(Collectors.toList());
        parrotBySpecies.forEach(p -> p.setAvailable(false));

        return parrotBySpecies;
    }

    public int count() {
        return this.data.size();
    }

    public String report() {
        List<Parrot> notSoldParrot = this.data.stream().filter(Parrot::isAvailable)
                .collect(Collectors.toList());

        StringBuilder sb = new StringBuilder();

        sb.append(String.format("Parrots available at %s:", this.name));

        notSoldParrot.forEach(parrot -> {
            sb.append(System.lineSeparator());
            sb.append(parrot);
        });
        return sb.toString();
    }
}
