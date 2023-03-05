package com.example.postgs.controller;

import com.example.postgs.model.Emp;
import com.example.postgs.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class EmpController {

    @Autowired
    EmpRepo empRepo;

    @PostMapping("/createEmp")
    private String createEmp(@RequestBody Emp emp) {
        empRepo.save(emp);
        return "Emp created";
    }

    @GetMapping("/getEmpByDeptId")
    private List<Object[]> getEmployeesByDeptId(@RequestParam UUID deptId) {
        Pageable p = PageRequest.of(0, 10);
        return empRepo.findRecordsByDeptId(p,deptId);
    }
}
