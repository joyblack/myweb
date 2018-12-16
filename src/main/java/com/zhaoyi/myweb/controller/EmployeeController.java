package com.zhaoyi.myweb.controller;

import com.zhaoyi.myweb.dao.DepartmentDao;
import com.zhaoyi.myweb.dao.EmployeeDao;
import com.zhaoyi.myweb.entities.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
public class EmployeeController {

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private DepartmentDao departmentDao;

    @RequestMapping("/emps")
    @GetMapping
    public String emps(Model model){
        model.addAttribute("emps", employeeDao.getAll());
        return "emp/list";
    }

    /**
     * 接收前往员工添加页面的请求，并跳转到添加页面emp/add.html
     * @return
     */
    @RequestMapping("/emp")
    @GetMapping
    public String toAddPage(Model model){
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }
}
