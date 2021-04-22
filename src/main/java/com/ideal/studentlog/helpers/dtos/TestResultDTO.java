package com.ideal.studentlog.helpers.dtos;

import com.ideal.studentlog.database.models.Student;
import com.ideal.studentlog.database.models.Test;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.OneToOne;
import java.util.Date;

@Data
@AllArgsConstructor
public class TestResultDTO {
    @NonNull
    @OneToOne
    Test test;

    @NonNull
    @OneToOne
    Student student;

    @NonNull
    String grade;
}
