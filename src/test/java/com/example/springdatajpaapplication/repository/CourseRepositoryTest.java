package com.example.springdatajpaapplication.repository;


import com.example.springdatajpaapplication.entity.Course;
import com.example.springdatajpaapplication.entity.Student;
import com.example.springdatajpaapplication.entity.Teacher;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class CourseRepositoryTest {

    @Autowired
    private CourseRepository courseRepository;

    @Test
    public void saveCourseWithTeacher(){

        Teacher teacher = Teacher.builder()
                .firstName("Shirish")
                .lastName("kumar")
                .build();

        Course course = Course.builder()
                .title("Algorithms")
                .credit(8)
                .teacher(teacher)
                .build();

        courseRepository.save(course);
    }

    @Test
    public void findPaging(){

        Pageable page = PageRequest.of(0,2);
        Pageable page1 = PageRequest.of(0,3);

        List<Course> courses = courseRepository.findAll(page1).getContent();

        long elements = courseRepository.findAll(page1).getTotalElements();
        long totalPages = courseRepository.findAll(page1).getTotalPages();

        System.out.println("elements = " + elements);
        System.out.println("totalPages = " + totalPages);

        System.out.println("Courses : "+courses);
    }


    @Test
    public void findSorting(){

        Pageable sortByTitle = PageRequest.of(0,2, Sort.by("title"));

        Pageable sortByCredit = PageRequest.of(0,2,Sort.by("credit"));

        Pageable sortByTitleAndCreditDesc = PageRequest.of(0,2,
                        Sort.by("title")
                                .and(Sort.by("credit").descending()));


        List<Course> courses1 = courseRepository.findAll(sortByTitle).getContent();
        System.out.println("Sort By Title - courses = " + courses1);

        List<Course> courses2 = courseRepository.findAll(sortByCredit).getContent();
        System.out.println("Sort By Credit - courses = " + courses2);
    }


    @Test
    public void addCourseWithTeacherAndStudent(){


        Teacher teacher = Teacher.builder()
                .firstName("Rama")
                .lastName("Raju")
                .build();

        Student s1 = Student.builder()
                .firstName("Rajesh")
                .lastName("Gujjala")
                .emailId("rajesh@gmail.com")
                .build();

        Student s2 = Student.builder()
                .firstName("chandra")
                .lastName("satya")
                .emailId("chandra@gmail.com")
                .build();


        Course course = Course.builder()
                .title("Machine Learning")
                .credit(10)
                .teacher(teacher)
                .build();
        course.addStudents(s1);
        course.addStudents(s2);

        courseRepository.save(course);
    }
}
