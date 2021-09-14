package com.example._TruongCongCuong_Spring_data_jpa.repo;

import com.example._TruongCongCuong_Spring_data_jpa.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    @Query(value = "select e from Employee e", nativeQuery = true)
    List<Employee> getAll();

    @Query(value = "select e from Employee e where e.first_name = ?1",nativeQuery = true)
    List<Employee> getListByFirstName(String firstName);

    @Transactional
    @Modifying
    @Query(value = "delete from  Employee e where e.id =?1")
    void deleteEmployee(int id);
}
