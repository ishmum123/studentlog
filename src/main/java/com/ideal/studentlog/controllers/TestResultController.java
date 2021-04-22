package com.ideal.studentlog.controllers;

import com.ideal.studentlog.database.models.Test;
import com.ideal.studentlog.database.models.TestResult;
import com.ideal.studentlog.helpers.dtos.TestDTO;
import com.ideal.studentlog.helpers.dtos.TestResultDTO;
import com.ideal.studentlog.services.TestResultService;
import com.ideal.studentlog.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/testresult")
@RequiredArgsConstructor
public class TestResultController {

    private final TestResultService service;

    @GetMapping
    public List<TestResult> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public TestResultDTO getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    @GetMapping(path = "/details")
    @ResponseBody
    public String testResultDetails(@RequestParam( name = "testId") Optional<Integer> testId,
                                            @RequestParam(name = "studentId") Optional<Integer> studentId,
                                            @RequestParam(name = "grade") Optional<String> grade){
        return service.getDetailsByParameter(studentId, testId, grade);

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody TestResultDTO dto) {
        service.create(dto);
    }
//
//    @PatchMapping(path = "/{id}")
//    public void update(@PathVariable("id") Integer id, @RequestBody TestDTO dto) {
//        service.update(id, dto);
//    }
//
//    @DeleteMapping(path = "/{id}")
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public void delete(@PathVariable("id") Integer id) {
//        service.delete(id);
//    }

}
