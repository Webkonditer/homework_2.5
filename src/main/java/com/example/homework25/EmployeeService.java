package com.example.homework25;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class EmployeeService {
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
    private int employeeNum = 10;

    public String addNewEmployee(String lastName, String firstName) {
        if(checkParametrs(lastName,firstName) != null){
            return checkParametrs(lastName,firstName);
        }
        if (employees.size() >= employeeNum){
            throw new EmployeeStorageIsFullException("Все вакансии заняты");
        }
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            if (employee.getLastName().equals(lastName) && employee.getFirstName().equals(firstName)) {
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже существует");
            }
        }
        employees.add(new Employee(lastName, firstName));
        return employees.get(employees.size() - 1).toString();
    }

    public String findEmployee(String lastName, String firstName) {
        if(checkParametrs(lastName,firstName) != null){
            return checkParametrs(lastName,firstName);
        }
        for (int i = 0; i < employees.size(); i++){
            Employee employee = employees.get(i);
            if(employee.getLastName().equals(lastName) && employee.getFirstName().equals(firstName)){
                return employee.toString();
            }
        }
        throw new EmployeeNotFoundException("Сотрудник с такими данными не найден");
    }

    public String removeEmployee(String lastName, String firstName) {
        if(checkParametrs(lastName,firstName) != null){
            return checkParametrs(lastName,firstName);
        }
        for (int i = 0; i < employees.size(); i++){
            Employee employee = employees.get(i);
            if(employee.getLastName().equals(lastName) && employee.getFirstName().equals(firstName)){
                String dismissed = employees.get(i).toString();
                employees.remove(i);
                return dismissed;
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден. Удаление невозможно.");
    }
    public String list() {
        String list = "";
        for (int i = 0; i < employees.size(); i++){
            list = list + i + employees.get(i).toString() + "<br>";
        }
        return list;
    }
    private String checkParametrs(String lastName, String firstName){
        if(lastName == null && firstName == null){
            return "Отсутствуют необходимые параметры";
        }else if(lastName == null){
            return "Отсутствует параметр lastName";
        }else if(firstName == null){
            return "Отсутствует параметр firstName";
        }
        return null;
    }
}
