package com.berzanozgenc.bil344.hw2.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "hw_users")
@Getter
@Setter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "First Name", nullable = false)
    private String firstName;
    @Column(name = "Last Name",nullable = false)
    private String lastName;
    @Column(name = "Date Of Birth", nullable = false)
    private Date dateOfBirth;
    @Column(name = "gender", nullable = false)
    private String gender;
    @Column(name = "weight", nullable = false)
    private float weight;
    @Column(name = "height", nullable = false)
    private float height;
    @Column(name = "Request Date",nullable = false)
    private LocalDateTime creationDate;
    @Column(name = "Index Result", nullable = false)
    private String indexResult;
    @Column(name = "Index Range", nullable = false)
    private float indexRange;

}
