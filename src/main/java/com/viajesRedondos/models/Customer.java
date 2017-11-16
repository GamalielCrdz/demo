package com.viajesRedondos.models;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    String hola;

    String name;

    String lastName;

    String nacionality;

    Date birthDate;

    String sex;
}