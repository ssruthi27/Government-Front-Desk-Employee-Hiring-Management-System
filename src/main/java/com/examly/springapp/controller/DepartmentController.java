package com.examly.springapp.controller;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import com.examly.springapp.model.Department;
import com.examly.springapp.service.DepartmentService;

@RestController
@RequestMapping("/api/departments")
public class DepartmentController {

  private final DepartmentService departmentService;

  public DepartmentController(DepartmentService departmentService){
    this.departmentService= departmentService;
  }

 @PostMapping
  public ResponseEntity <Department> createDeparment(@RequestBody Department department){
    
    Department saved = departmentService.createDepartment(department);
    return ResponseEntity.status(HttpStatus.CREATED).body(saved);
  }
  @GetMapping
  public ResponseEntity<List<Department>>getAllDepartments(){
    return ResponseEntity.ok(departmentService.getAllDepartments());
  }

  @GetMapping("/{id}")
  public ResponseEntity<Department> getDepartmentById(@PathVariable Long id){
    Department department= departmentService.getDepartmentById(id);
    if(department==null){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(department);
  }

  @PutMapping("/{id}")
  public ResponseEntity<Department> updateDepartment(@PathVariable Long id, @RequestBody Department department){
    Department updated= departmentService.updateDepartment(id, department);
    if(updated==null){
      return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
    return ResponseEntity.ok(updated);
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<Void>deleteDepartment(@PathVariable Long id){
    departmentService.deleteDepartment(id);
    return ResponseEntity.noContent().build();
  }
  
  @GetMapping("/page/{page}/{size}")
  public ResponseEntity<Page<Department>> getDepartmentsWithPagination(
    @PathVariable int page,
    @PathVariable int size){
      Pageable pageable = PageRequest.of(page, size);
      Page<Department> result = departmentService.getDepartmentsWithPagination(pageable);
      return ResponseEntity.ok(result);
    }
    }




