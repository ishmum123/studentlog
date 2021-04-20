package com.ideal.studentlog.database.repositories;

import com.ideal.studentlog.database.models.StudentApplication;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.*;

import java.util.List;

@Repository
public interface StudentApplicationRepository extends JpaRepository<StudentApplication, Integer> {
    List<StudentApplication> findAll();

}
