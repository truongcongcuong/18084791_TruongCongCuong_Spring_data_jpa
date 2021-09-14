package com.example._TruongCongCuong_Spring_data_jpa.repo;

import com.example._TruongCongCuong_Spring_data_jpa.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
