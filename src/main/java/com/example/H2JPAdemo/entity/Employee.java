package com.example.H2JPAdemo.entity;

import lombok.Data;
import lombok.Generated;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Data
@Entity
@Table(name="employee")

@NamedQueries(
  @NamedQuery(name = "Employee.findByNamedQuery",
  query = "Select e FROM Employee e" +
    " Where " +
    " Lower(e.firstName) like Lower(:searchword)" +
    " OR " +
    " Lower(e.lastName) like Lower(:searchword)")
)
public class Employee {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;
  private String firstName;
  private String lastName;
  private String address;
  private String joiningDate;

}
