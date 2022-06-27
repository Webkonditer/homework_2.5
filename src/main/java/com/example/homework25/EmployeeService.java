package com.example.homework25;

import java.util.List;

public interface EmployeeService {

    Employee addNewEmployee(String lastName, String firstName);
    Employee findEmployee(String lastName, String firstName);
    Employee removeEmployee(String lastName, String firstName);
    List<Employee> list();
}
