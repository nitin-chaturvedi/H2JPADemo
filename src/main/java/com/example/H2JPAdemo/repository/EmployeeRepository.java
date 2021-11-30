package com.example.H2JPAdemo.repository;

import com.example.H2JPAdemo.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

  //JPARepository extends Crud PagingAndSorting QueryExampleBy Executor Repositories

  List<Employee> findByFirstNameEqualsIgnoreCaseAndLastNameEqualsIgnoreCase(String firstName, String lastName);

  List<Employee> findByFirstNameStartingWithAndLastNameStartingWith(String firstName, String lastName);

  //Spring DAO doc for more query keywords
  //https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
  //JPA Palette plugin in Intellij for query suggestion

  @Query("Select e FROM Employee e" +
    " Where " +
    " Lower(e.firstName) like Lower(:searchword)" +
    " OR " +
    " Lower(e.lastName) like Lower(:searchword)")
  List<Employee> findByName(@Param("searchword")String searchword);

  List<Employee> findByNamedQuery(@Param("searchword")String searchword);

}
