package com.example.homework25;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/employee")

public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addition(@RequestParam(value = "lastName", required = false) String lastName, @RequestParam(value = "firstName", required = false) String firstName) {
        return employeeService.addNewEmployee(lastName,firstName);

    }

    @GetMapping("/remove")
    public String remove(@RequestParam(value = "lastName", required = false) String lastName, @RequestParam(value = "firstName", required = false) String firstName) {
        return employeeService.removeEmployee(lastName,firstName);

    }

    @GetMapping("/find")
    public String find(@RequestParam(value = "lastName", required = false) String lastName, @RequestParam(value = "firstName", required = false) String firstName) {
        return employeeService.findEmployee(lastName,firstName);
    }

    @GetMapping("/list")
    public String list() {
        return employeeService.list();
    }
}
