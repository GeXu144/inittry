package com.itheima.springbootuse.controller;

import com.itheima.springbootuse.dao.EmployeeDao;
import com.itheima.springbootuse.domain.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
     EmployeeDao dao ;
    @RequestMapping("/list")
    public String list(Model model){
        Collection<Employee> employees = dao.getAll();
        model.addAttribute(employees);
        return"emps/list";
    }

}
