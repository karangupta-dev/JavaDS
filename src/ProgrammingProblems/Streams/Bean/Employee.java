package ProgrammingProblems.Streams.Bean;


import ProgrammingProblems.Streams.Enums.EmployeeDepartment;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    Long id;
    String name;
    int salary;
    EmployeeDepartment department;
}
