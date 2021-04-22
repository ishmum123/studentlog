package com.ideal.studentlog.database.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class TestResult {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NonNull
    @OneToOne
    Test test;

    @NonNull
    @OneToOne
    Student student;

    @NonNull
    String grade;
}
