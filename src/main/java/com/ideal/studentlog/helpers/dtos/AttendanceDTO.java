package com.ideal.studentlog.helpers.dtos;

import com.ideal.studentlog.helpers.validators.annotations.ValidStudentId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;
@Data
@AllArgsConstructor
public class AttendanceDTO {

    @NonNull
    Date date;

    @NonNull
    @ValidStudentId
    Integer studentId;

    @NonNull
    Integer teacherId;

    @NonNull
    Boolean isPresent;
}
