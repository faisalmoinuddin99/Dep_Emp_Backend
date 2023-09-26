package com.kakashi.departmentservice.controller;

import com.kakashi.departmentservice.model.Department;
import com.kakashi.departmentservice.repository.DepartmentRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/v1/api/department")
public class DepartmentController {

    private DepartmentRepository departmentRepository ;

    @Autowired
    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }
    private static final Logger LOGGER =
            LoggerFactory.getLogger(DepartmentController.class);

    @PostMapping
    public Department add(@RequestBody Department department) {
        LOGGER.info("Department added: " + department);
        return departmentRepository.addDepartment(department) ;
    }

    @GetMapping
    public List<Department> findAll() {
        LOGGER.info("Department find");
        return departmentRepository.findAllDepartments();
    }

    @GetMapping("/{id}")
    public Department findDepartmentById(@PathVariable Long id){
        LOGGER.info("Department find: id={}", id);
        return departmentRepository.findDepartmentById(id) ;
    }
}
