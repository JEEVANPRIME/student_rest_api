package com.example.student.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.example.student.dto.Student;

@Component
public class UsnGenerator {

    private Map<String, Integer> branchIdMap = new HashMap<>(); 

    public String generatorUSN(Student student) {
        String yoa = student.getYoa();
        yoa = yoa.substring(2); //24

        String branch = student.getBranch(); 

        int id = branchIdMap.getOrDefault(branch.toLowerCase(), 0);
        id++; 

        branchIdMap.put(branch.toLowerCase(), id);
 
        return "2KE" + yoa + branch.toUpperCase() + id;
    }
}
