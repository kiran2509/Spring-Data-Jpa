package com.example.springdatajpaapplication.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@AttributeOverrides({
        @AttributeOverride(name = "name", column = @Column(name ="guardianName")),
        @AttributeOverride(name="email", column = @Column(name ="guardianEmail")),
        @AttributeOverride(name = "phoneNo", column = @Column(name="guardianPhone"))
})
public class Guardian {

    private String name;
    private String email;
    private String phoneNo;
}
