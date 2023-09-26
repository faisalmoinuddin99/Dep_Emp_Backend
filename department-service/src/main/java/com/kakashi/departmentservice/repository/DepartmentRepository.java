package com.kakashi.departmentservice.repository;

import com.kakashi.departmentservice.model.Department;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;


@Repository
public class DepartmentRepository {
    private List<Department> departmentDemoDB = new ArrayList<>() ;

    public Department addDepartment(Department department) {
        departmentDemoDB.add(department) ;
        return department ;
    }

    public Department findDepartmentById(Long id){
       return departmentDemoDB.stream()
               .filter(department -> department.getId().equals(id))
               .findFirst()
               .orElseThrow() ;
    }

    public List<Department> findAllDepartments() {
        return departmentDemoDB;
    }
}
