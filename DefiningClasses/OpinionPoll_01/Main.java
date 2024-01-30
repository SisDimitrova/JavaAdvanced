package OpinionPoll_01;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        List<Person> peopleList = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String[] infoPersonal = scanner.nextLine().split("\\s+");
            String name = infoPersonal[0];
            int age = Integer.parseInt(infoPersonal[1]);
            Person person = new Person(name, age);
            if (age > 30) {
                peopleList.add(person);
            }
        }
        peopleList.sort(Comparator.comparing(person -> person.getName()));
        for (Person person : peopleList) {
            System.out.println(person);
        }
    }
}
