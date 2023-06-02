package com.blankfactor.ra.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Role {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;

    @Column(name = "type")
    private String type;
}