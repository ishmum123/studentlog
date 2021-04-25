package com.ideal.studentlog.controllers;


import com.ideal.studentlog.database.models.ClassDetails;
import com.ideal.studentlog.helpers.dtos.ClassDetailsDTO;
import com.ideal.studentlog.helpers.exceptions.ServiceException;
import com.ideal.studentlog.services.ClassDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/class-details")
@RequiredArgsConstructor
public class ClassDetailsController {

    private final ClassDetailsService service;

    @GetMapping
    public List<ClassDetails> getAll() {
        return service.getAll();
    }

    @GetMapping(path = "/{id}")
    public ClassDetailsDTO getById(@PathVariable("id") Integer id) throws ServiceException {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void create(@RequestBody ClassDetailsDTO dto) throws ServiceException {
        service.create(dto);
    }

    @PatchMapping(path = "/{id}")
    public void update(@PathVariable("id") Integer id, @RequestBody ClassDetailsDTO dto) throws ServiceException {
        service.update(id, dto);
    }

    @DeleteMapping(path = "/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") Integer id) {
        service.delete(id);
    }
}
