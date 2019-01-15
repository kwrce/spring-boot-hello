package com.hand.springboothello.controller;

import com.fasterxml.jackson.databind.type.CollectionLikeType;
import com.hand.springboothello.dao.DepartmentDao;
import com.hand.springboothello.dao.EmployeeDao;
import com.hand.springboothello.entities.Department;
import com.hand.springboothello.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;
    //查询员工列表
    @GetMapping("/emps")
    public String list (Model model){
        Collection<Employee> employees= employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }
    @GetMapping("/emp")
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);
        return "emp/add";
    }
    //员工添加
    @PostMapping("/emp")
    public String addEmp(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }
    //来到修改页面，查出当前员工，然后回显
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id,Model model){

        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts",departments);

        Employee employee = employeeDao.get(id);
        model.addAttribute("emp",employee);
        return "emp/add";
    }
    @PutMapping("/emp")
    public String updateEmployee(Employee employee){
        System.out.println(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @DeleteMapping("/emp/{id}")
    public String deleteEmployee(@PathVariable("id") Integer id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
