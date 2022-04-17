package com.example.sanateroapi.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class DataHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "table_name")
    private String table_name;

    @Column(name = "date")
    private LocalDate date;

    @Column(name = "action")
    private String action;

    @Column(name = "old")
    private String oldValue;

    @Column(name = "new")
    private String newValue;
}
