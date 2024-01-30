package Google_07;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String info = scanner.nextLine();

        Map<String, Person> peopleData = new HashMap<>();

        while (!"End".equals(info)) {
            String[] parameters = info.split("\\s+");
            String name = parameters[0];
            if (!peopleData.containsKey(name)) {
                peopleData.put(name, new Person());
            }
            String typeCommand = parameters[1];
            switch (typeCommand) {
                case "company":
                    String nameCompany = parameters[2];
                    String department = parameters[3];
                    double salary = Double.parseDouble(parameters[4]);
                   Company company = new Company(nameCompany, department, salary);
                   peopleData.get(name).setCompany(company);
                    break;
                case "pokemon":
                    String pokemonName = parameters[2];
                    String pokemonType = parameters[3];
                    Pokemon pokemon = new Pokemon(pokemonName, pokemonType);
                    peopleData.get(name).getPokemons().add(pokemon);
                    break;
                case "parents":
                    String parentName = parameters[2];
                    String parentBirthday = (parameters[3]);
                    Parent parent = new Parent(parentName, parentBirthday);
                    peopleData.get(name).getParents().add(parent);

                    break;
                case "children":
                    String childrenName = parameters[2];
                    String childrenBirthday = (parameters[3]);
                    Child child = new Child(childrenName, childrenBirthday);
                    peopleData.get(name).getChildren().add(child);
                    break;
                case "car":
                    String model = parameters[2];
                    int speed = Integer.parseInt(parameters[3]);
                    Car car = new Car(model, speed);
                    peopleData.get(name).setCar(car);
                    break;
            }

            info = scanner.nextLine();
        }
        String searchPerson = scanner.nextLine();
        System.out.println(searchPerson);

        Person personalData = peopleData.get(searchPerson);
        System.out.println(personalData);

    }
}
