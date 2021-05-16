package com.ideal.studentlog.database.models;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.lang.NonNull;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor
@Entity
public class LeaveApplication {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;

    @NonNull
    Date dateFrom;

    @NonNull
    Date dateTo;

    @NonNull
    @ManyToOne
    Student student;

    @NonNull
    String applicationBody;

    String supportedDocumentName;

    String supportedDocumentType;

    String supportedDocumentSize;

    String supportedDocumentBase64;

    @NonNull
    String status;

    @ManyToOne
    Teacher decisionBy;
}
