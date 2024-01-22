package ExercissesSetsAndMaps;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class PhoneBook_05 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> phonebook = new HashMap<>();

        while (true) {
            String line = scanner.nextLine();
            if ("search".equals(line)) {
                break;
            }
            String[] token = line.split("-");
            String name = token[0];
            String numberPhone = token[1];
            phonebook.putIfAbsent(name, numberPhone);
        }
        while (true) {
            String input = scanner.nextLine();
            if ("stop".equals(input)) {
                break;
            }
            if (phonebook.containsKey(input)) {
                System.out.printf("%s -> %s%n", input, phonebook.get(input));
            } else {
                System.out.printf("Contact %s does not exist.%n", input);
            }
        }
    }
}
