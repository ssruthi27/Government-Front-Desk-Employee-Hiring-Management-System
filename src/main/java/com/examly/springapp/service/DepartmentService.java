package com.examly.springapp.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.examly.springapp.model.Department;
public interface DepartmentService {
  
  Department createDepartment(Department Department);
  List<Department> getAllDepartments();
  Department getDepartmentById(Long id);
  Department updateDepartment(Long id, Department department);
  void deleteDepartment(Long id);
  Page<Department>getDepartmentsWithPagination(Pageable pageable);
}

