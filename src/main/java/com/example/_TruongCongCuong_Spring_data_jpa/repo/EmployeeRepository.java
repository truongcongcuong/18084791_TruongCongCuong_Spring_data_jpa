package com.example._TruongCongCuong_Spring_data_jpa.repo;

import com.example._TruongCongCuong_Spring_data_jpa.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;



public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    @Query(value = "select * from employee", nativeQuery = true)
    List<Employee> getAll();

    @Query(value = "select * from employee where first_name = ?1",nativeQuery = true)
    List<Employee> getListByFirstName(String firstName);

    @Transactional
    @Modifying
    @Query(value = "insert into employee(first_name,last_name,email) values(?1,?2,?3)")
    void addNewEmployee(String firstName, String lastName, String email);


    @Transactional
    @Modifying
    @Query(value = "update employee set email =?1 where id =?2", nativeQuery = true)
    void updateEmail(String email, int id);


    @Transactional
    @Modifying
    @Query(value = "delete from  employee where id =?1")
    void deleteEmployee(int id);

}
