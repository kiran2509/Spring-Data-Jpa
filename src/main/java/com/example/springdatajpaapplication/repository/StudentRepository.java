package com.example.springdatajpaapplication.repository;

import com.example.springdatajpaapplication.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    List<Student> findStudentByFirstName(String name);

    List<Student> findByGuardianName(String name);

    Student findStudentByFirstNameAndLastName(String firstname, String lastname);

    //JPQL
    @Query("select s from Student s where s.emailId = ?1")
    Student findStudentsByEmailAddress(String email);

    //Native
    @Query(
            value = "select * from student_table where emailid = ?1",
            nativeQuery = true
    )
    Student findStudentByEmailAddressNative(String email);


    //Native Named Param
    @Query(
            value = "select * from student_table where emailid = :emailId",
            nativeQuery = true
    )
    Student findStudentByEmailAddressNativeNamedQuery(@Param("emailId") String email);


    @Modifying
    @Transactional
    @Query(
            value = "update student_table set firstname = ?1 where emailid = ?2",
            nativeQuery = true
    )
    void updateStudentNameByEmailId(String name, String emailId);
}
