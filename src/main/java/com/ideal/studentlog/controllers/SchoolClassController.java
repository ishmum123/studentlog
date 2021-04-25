package com.ideal.studentlog.controllers;


import com.ideal.studentlog.database.models.SchoolClass;
import com.ideal.studentlog.helpers.dtos.SchoolClassDTO;
import com.ideal.studentlog.services.SchoolClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/school-classes")
@RequiredArgsConstructor
public class SchoolClassController {

    private final SchoolClassService service;

    @GetMapping
    public List<SchoolClass> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public SchoolClassDTO getById(@PathVariable("id") Integer id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody SchoolClassDTO dto) {
        service.create(dto);
    }

    @PatchMapping(path = "/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody SchoolClassDTO dto) {
        service.update(id, dto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
