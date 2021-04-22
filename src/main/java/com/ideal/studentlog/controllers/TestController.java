package com.ideal.studentlog.controllers;

import com.ideal.studentlog.database.models.Student;
import com.ideal.studentlog.database.models.Test;
import com.ideal.studentlog.helpers.dtos.StudentDTO;
import com.ideal.studentlog.helpers.dtos.TestDTO;
import com.ideal.studentlog.services.StudentService;
import com.ideal.studentlog.services.TestService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/test")
@RequiredArgsConstructor
public class TestController {

    private final TestService service;

    @GetMapping
    public List<Test> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public TestDTO getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    @GetMapping(path = "/subject/{subject}")
    public List<Test> getBySubject(@PathVariable("subject") String subject) {
        return service.getBySubject(subject);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody TestDTO dto) {
        service.create(dto);
    }

    @PatchMapping(path = "/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody TestDTO dto) {
        service.update(id, dto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }

}
