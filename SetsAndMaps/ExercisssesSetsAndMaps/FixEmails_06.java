package ExercissesSetsAndMaps;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class FixEmails_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, String> validEmail = new LinkedHashMap<>();

        while (true) {
            String name = scanner.nextLine();
            if ("stop".equals(name)) {
                break;
            }
            String email = scanner.nextLine();
            if (!email.endsWith(".us") && !email.endsWith(".uk") && !email.endsWith(".com")) {
                validEmail.put(name, email);
            }
        }
        validEmail.entrySet().forEach(entry -> {
            System.out.printf("%s -> %s%n", entry.getKey(), entry.getValue());
        });
    }
}
