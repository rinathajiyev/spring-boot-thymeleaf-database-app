package com.company.entity;

import lombok.*;

import javax.persistence.*;
import java.sql.*;

@Entity
@Table(name="students", schema = "school")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Students {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Basic(optional = true)
    @Column(name="name")
    private String name;

    @Basic(optional = true)
    @Column(name="surname")
    private String surname;

    @Basic(optional = true)
    @Column(name="age")
    private int age;

    @Basic(optional = true)
    @Column(name="email")
    private String email;

    @Basic(optional = true)
    @Column(name="phone")
    private String phone;

    @Basic(optional = true)
    @Column(name="birthdate")
    private Date birthdate;

    @Basic(optional = true)
    @Column(name="password")
    private String password;




}
