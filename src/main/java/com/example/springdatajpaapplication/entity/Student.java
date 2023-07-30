package com.example.springdatajpaapplication.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(
        name = "student_table",
        uniqueConstraints = { @UniqueConstraint(columnNames = {"emailId"})}
)
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private long id;
    @Column(name = "firstname")
    private String firstName;
    @Column(name = "lastname")
    private String lastName;
    @Column(name = "emailid", nullable = false)
    private String emailId;
    @Embedded
    private Guardian guardian;
}
