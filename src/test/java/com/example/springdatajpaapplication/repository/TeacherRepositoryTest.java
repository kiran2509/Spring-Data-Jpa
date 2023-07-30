package com.example.springdatajpaapplication.repository;


import com.example.springdatajpaapplication.entity.Course;
import com.example.springdatajpaapplication.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class TeacherRepositoryTest {

    @Autowired
    private  TeacherRepository teacherRepository;

    @Test
    public void saveTeacher(){

        Course courseJava = Course.builder()
                .title("Java")
                .credit(7)
                .build();

        Course courseNet = Course.builder()
                .title(".Net")
                .credit(6)
                .build();

        Teacher teacher = Teacher.builder()
                .firstName("Suresh")
                .lastName("Kumar")
                //.courses(List.of(courseJava, courseNet))
                .build();

        teacherRepository.save(teacher);
    }
}
