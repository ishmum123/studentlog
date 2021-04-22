package com.ideal.studentlog.database.repositories;

import com.ideal.studentlog.database.models.Test;
import com.ideal.studentlog.database.models.TestResult;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestResultRepository extends JpaRepository<TestResult, Integer>, JpaSpecificationExecutor<TestResult> {
    List<TestResult> findAll();
//    List<Test> findTestBySubject(String subject);

}
