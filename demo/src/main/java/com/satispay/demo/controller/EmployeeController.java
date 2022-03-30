package com.awsSA.demo.controller;

import java.util.List;

import com.awsSA.demo.model.Employee;
import com.awsSA.demo.repository.EmployeeRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeRepository repo;

    @Value("${awsSA.host.ip}")
    private String ip;

    @GetMapping("/")
    public String listAll(Model model) {
        model.addAttribute("ip", ip);
        List<Employee> listEmployees = repo.findAll();
        model.addAttribute("listEmployees", listEmployees);
        System.out.println(listEmployees.toString());
        return "index";
    }

    @PostMapping("/save")
    public String addEmployee(@RequestParam long id, @RequestParam String name, @RequestParam int salary) {
        Employee employee = new Employee();
        employee.setId(id);
        employee.setName(name);
        employee.setSalary(salary);
        repo.save(employee);
        return "redirect:/";
    }

    @PostMapping("/del")
    public String delEmployee(long id) {
        Employee employee = repo.getById(id);
        repo.delete(employee);
        return "redirect:/";
    }
}