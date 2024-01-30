package ExercissesFunctionalPrograming;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ThePartyReservationFilterModule_11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> guests = Arrays.stream(scanner.nextLine().split("\\s+"))
                .collect(Collectors.toList());

        Set<String> filters = new HashSet<>();
        while (true) {
            String command = scanner.nextLine();
            if (("Print").equals(command)) {
                break;
            }
            String[] commandParts = command.split(";");
            String addAndRemove = commandParts[0];
            String type = commandParts[1];
            String parameter = commandParts[2];
            if (addAndRemove.equals("Add filter")) {
                filters.add(type + ";" + parameter);
            } else {
                filters.remove(type + ";" + parameter);
            }
        }

        filters.forEach(filter -> {
            Predicate<String> filterToApply = getPredicate(filter);
            guests.removeIf(filterToApply);
        });

        guests.forEach(name -> System.out.print(name + " "));
    }

    private static Predicate<String> getPredicate(String filter) {

        String filterType = filter.split(";")[0];
        String parameter = filter.split(";")[1];

        switch (filterType) {
            case "Starts with":
                return s -> s.startsWith(parameter);
            case "Ends with":
                return s -> s.endsWith(parameter);
            case "Length":
                return s -> s.length() == Integer.parseInt(parameter);
            case "Contains":
                return s -> s.contains(parameter);
        }

        return null;
    }
}
