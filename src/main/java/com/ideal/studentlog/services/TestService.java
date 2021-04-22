package com.ideal.studentlog.services;

import com.ideal.studentlog.database.models.Student;
import com.ideal.studentlog.database.models.Test;
import com.ideal.studentlog.database.repositories.StudentRepository;
import com.ideal.studentlog.database.repositories.TestRepository;
import com.ideal.studentlog.helpers.dtos.TestDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TestService {

    private final TestRepository repository;

    public List<Test> getAll() {
        return repository.findAll();
    }

    public void create(TestDTO dto) {
        Test test = new Test();
        test.setSubject(dto.getSubject());
        test.setExaminer(dto.getExaminer());
        test.setTest_date(dto.getTest_date());
        repository.save(test);
    }

    public TestDTO getById(Integer id) {
        Test test = repository.findById(id).orElseThrow();

        return new TestDTO(
                test.getSubject(),
                test.getExaminer(),
                test.getTest_date()
        );
    }

    public void update(Integer id, TestDTO dto) {
        Test test = repository.findById(id).orElseThrow();
        test.setSubject(dto.getSubject());
        test.setExaminer(dto.getExaminer());
        test.setTest_date(dto.getTest_date());
        repository.save(test);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

    public List<Test> getBySubject(String subject) {
        List<Test> test = repository.findTestBySubject(subject);
        return test;
    }
}
