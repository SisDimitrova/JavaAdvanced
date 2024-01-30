package CompanyRoster_02;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        Map<String, List<Employee>> departments = new HashMap<>();

        for (int i = 0; i < n; i++) {
            String[] employeeInfo = scanner.nextLine().split("\\s+");
            String name = employeeInfo[0];
            double salary = Double.parseDouble(employeeInfo[1]);
            String position = employeeInfo[2];
            String department = employeeInfo[3];
            Employee employee = null;
            if (employeeInfo.length == 6) {
                String email = employeeInfo[4];
                int age = Integer.parseInt(employeeInfo[5]);
                employee = new Employee(name, salary, position, department, email, age);
            } else if (employeeInfo.length == 4) {
               employee = new Employee(name, salary, position, department);
            } else if (employeeInfo.length == 5) {
                String forthParameter = employeeInfo[4];
                if (forthParameter.contains("@")) {
                    String email = forthParameter;
                    employee = new Employee(name, salary, position, department, email);
                } else {
                    int age = Integer.parseInt(forthParameter);
                    employee = new Employee(name, salary, position, department, age);
                }
            }
            if (!departments.containsKey(department)) {
                departments.put(department, new ArrayList<>());
                departments.get(department).add(employee);
            } else {
                departments.get(department).add(employee);
            }
        }
        String maxAverageSalaryDepartment = departments.entrySet()
                .stream()
                .max(Comparator.comparingDouble(entry -> getAverageSalary(entry.getValue())))
                        .get().getKey();

        System.out.printf("Highest Average Salary: %s%n", maxAverageSalaryDepartment);
          List<Employee> employeeList = departments.get(maxAverageSalaryDepartment);
          employeeList.sort(Comparator.comparingDouble(emp -> emp.getSalary()));
          Collections.reverse(employeeList);

        for (Employee employee: employeeList) {
            System.out.println(employee);
        }
    }
    public static double getAverageSalary(List<Employee> employees) {
        double sum = 0;
        for (Employee employee : employees) {
            sum += employee.getSalary();
        }
        return sum / employees.size();
    }
}
