package com.ideal.studentlog.helpers.dtos;

import lombok.Data;
import lombok.AllArgsConstructor;
import lombok.NonNull;

import java.util.Date;

@Data
@AllArgsConstructor
public class TestDTO {
    @NonNull
    String subject;

    @NonNull
    String examiner;

    @NonNull
    Date test_date;
}
