package com.example.postgs.repository;

import com.example.postgs.model.Emp;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface EmpRepo extends JpaRepository<Emp, UUID> {

    @Query("Select e.empName,e.deptIds from Emp e where :deptId member of e.deptIds")
    List<Object[]> findRecordsByDeptId(Pageable p, @Param("deptId") UUID deptId);
}
