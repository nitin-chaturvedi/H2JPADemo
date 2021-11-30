package com.example.H2JPAdemo.controller;

import com.example.H2JPAdemo.entity.Employee;
import com.example.H2JPAdemo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

  @Autowired
  EmployeeService employeeService;

  @GetMapping("/employee")
  public List<Employee> getAll(){
    return employeeService.getAllEmployee();
  }

  @GetMapping("/page")
  public Map<String,Object> getPageEmployee(@RequestParam(value="pageNo", required = false, defaultValue = "0") int pageNo,
                                              @RequestParam(value="pageSize", required = false, defaultValue = "2") int pageSize){
    return employeeService.getPagedEmployee(pageNo,pageSize);
  }

  @GetMapping("/findByName")
  public List<Employee> findEmployeeByNAme(@RequestParam(value = "searchword") String searchword){
    return employeeService.findByNameUsingNamedQuery(searchword);
    //    return employeeService.findByNameUsingQuery(searchword);
    //    return employeeService.findByNameUsingMethodQueries(searchword);
  }
}
