package com.example.todolistwebjavarest;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
@Table(name = "todo")
public class Todo {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name = "txt")
    String txt;

    @Column(name = "startdate")
    Date startdate;

    @Column(name = "deadline")
    Date deadline;





}
