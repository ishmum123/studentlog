package com.ideal.studentlog.controllers;

import com.ideal.studentlog.database.models.SubjectDetails;
import com.ideal.studentlog.helpers.dtos.SubjectDetailsDTO;
import com.ideal.studentlog.services.SubjectDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/subjectDetails")
@RequiredArgsConstructor
public class SubjectDetailsController {
    private final SubjectDetailsService service;

    @GetMapping
    public List<SubjectDetails> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public SubjectDetailsDTO getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }
    
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody SubjectDetailsDTO dto) {
        service.create(dto);
    }
    
    @PatchMapping(path = "/{id}")
    public void update(@PathVariable("id") Integer id,  @RequestBody SubjectDetailsDTO dto) {
        service.update(id, dto);
    }
    
    @DeleteMapping(path="/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
          service.delete(id);
    }
}
