package ProgrammingProblems.Streams;

import ProgrammingProblems.Streams.Bean.Employee;
import ProgrammingProblems.Streams.Enums.EmployeeDepartment;

import java.util.*;
import java.util.stream.Collectors;

public class GroupEmployees {

    static List<Employee> employees = new ArrayList<Employee>();

    private static void createMockEmployeeData() {
        employees.add(new Employee(1L, "Sujal", 25000, EmployeeDepartment.SALES));
        employees.add(new Employee(2L, "John", 22000, EmployeeDepartment.SALES));
        employees.add(new Employee(3L, "Mac", 23000, EmployeeDepartment.SALES));

        employees.add(new Employee(11L, "Ajay", 25000, EmployeeDepartment.FINANCE));
        employees.add(new Employee(22L, "Vijay", 22000, EmployeeDepartment.FINANCE));
        employees.add(new Employee(33L, "Bimal", 23000, EmployeeDepartment.FINANCE));

        employees.add(new Employee(21L, "Nipun", 27000, EmployeeDepartment.MARKETING));
        employees.add(new Employee(22L, "Naveen", 29000, EmployeeDepartment.MARKETING));
        employees.add(new Employee(23L, "Maverick", 30000, EmployeeDepartment.MARKETING));
    }

    public static void groupEmployeesByDepartment() {
        createMockEmployeeData();

        Map<EmployeeDepartment, List<Employee>> map = groupByDepartment();

        printEachEmployeeNamePerDepartment(map);

        printUniqueNoOfDepartments(map);

        printAverageSalaryPerDepartment(map);

        topN_SalariesPerDepartment(2, map);
    }

    private static void printEachEmployeeNamePerDepartment(Map<EmployeeDepartment, List<Employee>> map) {
        //         DONE BY KARAN
//        map.entrySet().stream()
//                .forEach(entry ->
//                        System.out.println("Employee in Department" + entry.getKey() + " " + entry.getValue())
//                );


//       DONE BY GPT
        System.out.println("Employees in department:");

        map.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()
                        .map(employee -> employee.getName() + " - " + entry.getKey()))
                .forEach(System.out::println);
    }

    private static  Map<EmployeeDepartment, List<Employee>> groupByDepartment() {
        //        DID BY KARAN
//        HashMap<EmployeeDepartment, List<Employee>> map = new HashMap<EmployeeDepartment, List<Employee>>();

//        List<Employee> list;
//        for (Employee employee : employees) {
//            if (map.containsKey(employee.getDepartment())) {
//                list = map.get(employee.getDepartment());
//            } else {
//                list = new ArrayList<>();
//            }
//            list.add(employee);
//            map.put(employee.getDepartment(), list);
//        }

//        DID GROUPING USING STREAMS
        Map<EmployeeDepartment, List<Employee>> map = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));
        return map;
    }

    private static void topN_SalariesPerDepartment(int n, Map<EmployeeDepartment, List<Employee>> map) {
        System.out.println(String.format("\nTop %d salaries in each department:", n));

        map.entrySet().stream()
                .forEach(entry -> {
                    System.out.println("\n\t Department: " + entry.getKey());

                    entry.getValue().stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                            .limit(n)
                            .forEach(emp -> {
                                System.out.println(emp.getName() + "-" + emp.getSalary());
                            });
                });

    }

    private static void printAverageSalaryPerDepartment(Map<EmployeeDepartment, List<Employee>> map) {
        System.out.println("\nAverage salary in each dept");

        map.entrySet().stream()
                .forEach(entry -> {
                    double avgSalary = entry.getValue().stream()
                            .mapToDouble(Employee::getSalary)
                            .average()
                            .orElse(0.0);

                    System.out.println("Department: " + entry.getKey() + ", Average Salary: " + String.format("%.2f", avgSalary));
                });
    }

    private static void printUniqueNoOfDepartments(Map<EmployeeDepartment, List<Employee>> map) {
        System.out.println("\nNo of unique departments: " + map.keySet().stream().count());
    }

    public static void main(String[] args) {
        groupEmployeesByDepartment();

    }

}
