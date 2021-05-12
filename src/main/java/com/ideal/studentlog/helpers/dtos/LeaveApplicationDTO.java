package com.ideal.studentlog.helpers.dtos;

import com.ideal.studentlog.helpers.validators.annotations.ValidTeacherId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;

import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
public class LeaveApplicationDTO {

    Integer id;

    @NonNull
    Date dateFrom;

    @NonNull
    Date dateTo;

    @NonNull
    Integer studentId;

    @NonNull
    @Size(max = 1000)
    String applicationBody;

    @Size(max = 30)
    String supportedDocumentName;

    @Size(max = 30)
    String supportedDocumentType;

    @Size(max = 20)
    String supportedDocumentSize;

    String supportedDocumentBase64;

    @NonNull
    String status;

    @ValidTeacherId
    Integer decisionById;
}
