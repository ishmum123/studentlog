package com.ideal.studentlog.helpers.dtos;

import com.ideal.studentlog.database.models.SchoolClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

@Data
@AllArgsConstructor
public class ClassDetailsDTO {
    @NonNull
    SchoolClass schoolClass;

    @NonNull
    String year;

    @NonNull
    Integer teacherId;
}
