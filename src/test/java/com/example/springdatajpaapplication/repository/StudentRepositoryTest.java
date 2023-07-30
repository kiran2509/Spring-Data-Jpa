package com.example.springdatajpaapplication.repository;

import com.example.springdatajpaapplication.entity.Guardian;
import com.example.springdatajpaapplication.entity.Student;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

@SpringBootTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @Test
    public void saveStudentWithGuardian() {

        Guardian guardian = Guardian.builder()
                .email("nikhil@gmail.com")
                .name("Nikhil")
                .phoneNo("89706571456")
                .build();

        Student student = Student.builder()
                .firstName("Kiran")
                .emailId("kiran.chenna@gmail.com")
                .lastName("Kumar")
                .guardian(guardian)
                .build();

        studentRepository.save(student);
    }

    @Test
    public void printAllStudents(){
        List<Student> students = studentRepository.findAll();
        System.out.println("Student List:"+ students);
    }


    @Test
    public void getStudentByFirstName(){
        List<Student> students = studentRepository.findStudentByFirstName("Kiran");
        System.out.println(students);
    }

    @Test
    public void getStudentByGuardian(){
        List<Student> students = studentRepository.findByGuardianName("Nikhil");
        System.out.println(students);
    }

    @Test
    public void getStudentByFirstNameAndLastName(){
        Student student = studentRepository.findStudentByFirstNameAndLastName("Kiran", "Kumar");
        System.out.println(student);
    }

    @Test
    public void getStudentFindByEmailAddress(){

        Student student = studentRepository.findStudentsByEmailAddress("kiran.chenna@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailAddressNative(){
        Student student = studentRepository.findStudentByEmailAddressNative("kiran.chenna@gmail.com");
        System.out.println(student);
    }

    @Test
    public void getStudentByEmailAddressNativeNamedQuery(){
        Student student = studentRepository.findStudentByEmailAddressNativeNamedQuery("kiran.chenna@gmail.com");
        System.out.println(student);
    }


    @Test
    public void updateFirstNameByEmailId(){

        studentRepository.updateStudentNameByEmailId(
                "Shivam Mahtra",
                "shivam@gmail.com"
        );
    }

}
