package com.example.springdatajpaapplication.repository;

import com.example.springdatajpaapplication.entity.Course;
import com.example.springdatajpaapplication.entity.CourseMaterial;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class CourseMaterialRepositoryTest {

    @Autowired
    private CourseMaterialRepository courseMaterialRepository;

    @Test
    public void saveCourseMaterial(){

        Course course = Course.builder()
                .title("DSA")
                . credit(8)
                .build();

        CourseMaterial courseMaterial = CourseMaterial.builder()
                .url("www.geeksforgeeks.com")
                .course(course)
                .build();

        courseMaterialRepository.save(courseMaterial);
    }

    @Test
    public void printCourseMaterial(){

        List<CourseMaterial> courseMaterials = courseMaterialRepository.findAll();
        System.out.println(courseMaterials);
    }
}
