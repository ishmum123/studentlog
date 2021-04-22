package com.ideal.studentlog.services;

import com.ideal.studentlog.database.models.Test;
import com.ideal.studentlog.database.models.TestResult;
import com.ideal.studentlog.database.repositories.TestRepository;
import com.ideal.studentlog.database.repositories.TestResultRepository;
import com.ideal.studentlog.helpers.dtos.TestDTO;
import com.ideal.studentlog.helpers.dtos.TestResultDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TestResultService {

    private final TestResultRepository repository;

    public List<TestResult> getAll() {
        return repository.findAll();
    }

    public void create(TestResultDTO dto) {
        TestResult testResult = new TestResult();
        testResult.setTest(dto.getTest());
        testResult.setStudent(dto.getStudent());
        testResult.setGrade(dto.getGrade());
        repository.save(testResult);
    }

    public TestResultDTO getById(Integer id) {
        TestResult testResult = repository.findById(id).orElseThrow();

        return new TestResultDTO(
                testResult.getTest(),
                testResult.getStudent(),
                testResult.getGrade()
        );
    }
    public String getDetailsByParameter(Optional<Integer> studentId, Optional<Integer> testId, Optional<String> grade){
        String  queryString = "";
        queryString += "SELECT * FROM testresult ";
        List<String> queryCondition = new ArrayList<>();;
        if(studentId.isPresent()) queryCondition.add(" student_id = " + studentId.get().toString());
        if(testId.isPresent()) queryCondition.add(" test_id = " + testId.get().toString());
        if(grade.isPresent()) queryCondition.add(" grade = \"" + grade.get() + "\"");

        if (queryCondition != null){
            queryString += " WHERE ";
            queryString += queryCondition.get(0);
            for (int i = 1; i < queryCondition.size(); i++) queryString += " and "+ queryCondition.get(i);
        }
//        @Query(value = ":sqlQuery")
//        List<TestResult> testResults =

        return queryString;
//        return repository.findAll();
    }
    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
