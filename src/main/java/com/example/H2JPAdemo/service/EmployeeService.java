package com.example.H2JPAdemo.service;

import com.example.H2JPAdemo.entity.Employee;
import com.example.H2JPAdemo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeService {

  @Autowired
  EmployeeRepository employeeRepository;

  public List<Employee> getAllEmployee(){
    return (List<Employee>) employeeRepository.findAll();
  }

  public Map<String,Object> getPagedEmployee(int pageNo, int pageSize) {
    Pageable pageable = PageRequest.of(pageNo, pageSize);
    Page<Employee> page = employeeRepository.findAll(pageable);

    Map<String,Object> resp = new HashMap<String,Object>();

    resp.put("data",page.getContent());
    resp.put("currentPage",page.getNumber());
    resp.put("totalPage",page.getTotalPages());
    resp.put("count",page.getTotalElements());

    return resp;
  }

  public String addUpdateEmployee(Employee emp) {
    if(employeeRepository.save(emp) != null){
      return "Successfully added employee";
    }
    return "Failed to add";
  }

  public String deleteEmployee(Employee emp) {
    try {
      employeeRepository.delete(emp);
      return "Successfully added employee";
    }catch (Exception e) {
      return "Failed to add";
    }
  }

  public List<Employee> findByNameUsingMethodQueries(String searchword){
    return employeeRepository.findByFirstNameStartingWithAndLastNameStartingWith(searchword,searchword);
  }

  public List<Employee> findByNameUsingQuery(String searchword){
    return employeeRepository.findByName(searchword);
  }

  public List<Employee> findByNameUsingNamedQuery(String searchword){
    return employeeRepository.findByNamedQuery(searchword);
  }
}
