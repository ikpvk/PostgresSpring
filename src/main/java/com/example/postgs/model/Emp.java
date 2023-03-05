package com.example.postgs.model;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name="employee")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Emp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID emp_id;

    @Column(name="emp_name")
    private String empName;

    @Column(name="dept_ids")
    @ElementCollection(targetClass = UUID.class)
    private UUID[] deptIds;
}
