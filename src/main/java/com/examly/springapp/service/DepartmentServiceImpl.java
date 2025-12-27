package com.examly.springapp.service;

import java.util.List;

import org.springframework.stereotype.Service;
import com.examly.springapp.model.Department;
import com.examly.springapp.repository.DepartmentRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@Service
public class DepartmentServiceImpl implements DepartmentService {
  private final DepartmentRepository departmentRepository;

  public DepartmentServiceImpl(DepartmentRepository departmentRepository){
    this.departmentRepository= departmentRepository;
  }
 public Department createDepartment(Department department){
    return departmentRepository.save(department);
}
  public List<Department>getAllDepartments(){
    return departmentRepository.findAll();
  }
  public Department getDepartmentById(Long id){
    return departmentRepository.findById(id).orElse(null);
  }
  public Department updateDepartment(Long id, Department department){
    Department existing = departmentRepository.findById(id).orElse(null);
    if(existing==null){
      return null;
    }

    existing.setDepartmentName(department.getDepartmentName());
    existing.setContactEmail(department.getContactEmail());
    existing.setContactPhone(department.getContactPhone());

    return departmentRepository.save(existing);
  }
  public void deleteDepartment(Long id){
    departmentRepository.deleteById(id);
  }
  public Page<Department>getDepartmentsWithPagination(Pageable pageable){
    return departmentRepository.findAll(pageable);
  }
}

