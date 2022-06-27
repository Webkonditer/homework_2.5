package com.example.homework25;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    private List<Employee> employees = new ArrayList<>(Arrays.asList(
        new Employee("Егоров", "Егор"),
        new Employee("Степанов", "Степан"),
        new Employee("Александров", "Александр"),
        new Employee("Евгеньев", "Евгений"),
        new Employee("Антонов", "Антон"),
        new Employee("Семенов", "Семен"),
        new Employee("Аркадьев", "Аркадий"),
        new Employee("Владимиров", "Владимир"),
        new Employee("Васильев", "Василий"),
        new Employee("Николаев", "Николай")
    ));
    private final int employeeNum = 10;

    @Override
    public Employee addNewEmployee(String lastName, String firstName) {

        if (employees.size() >= employeeNum){
            throw new EmployeeStorageIsFullException("Все вакансии заняты");
        }
        for (Employee employee : employees) {
            if (employee.getLastName().equals(lastName) && employee.getFirstName().equals(firstName)) {
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
            }
        }
        employees.add(new Employee(lastName, firstName));
        return employees.get(employees.size() - 1);
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) {

        for (Employee employee : employees) {
            if (employee.getLastName().equals(lastName) && employee.getFirstName().equals(firstName)) {
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник с такими данными не найден");
    }

    @Override
    public Employee removeEmployee(String lastName, String firstName) {

        for (int i = 0; i < employees.size(); i++){
            Employee employee = employees.get(i);
            if(employee.getLastName().equals(lastName) && employee.getFirstName().equals(firstName)){
                employees.remove(i);
                return employee;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден. Удаление невозможно.");
    }

    @Override
    public List<Employee> list() {
        return Collections.unmodifiableList(employees);
    }
}
