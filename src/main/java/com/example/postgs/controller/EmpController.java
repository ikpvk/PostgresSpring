package com.example.postgs.controller;

import com.example.postgs.model.Emp;
import com.example.postgs.repository.EmpRepo;
import org.springframework.beans.factory.annotation.Autowired;
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
    private List<Emp> getEmployeesByDeptId(@RequestParam UUID deptId) {
        return empRepo.findRecordsByDeptId(deptId);
    }
}
