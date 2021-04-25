package com.ideal.studentlog.services;

import com.ideal.studentlog.database.models.SchoolClass;
import com.ideal.studentlog.database.repositories.SchoolClassRepository;
import com.ideal.studentlog.helpers.dtos.SchoolClassDTO;
import com.ideal.studentlog.helpers.exceptions.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolClassService {
    private final SchoolClassRepository repository;

    //Todo: introduce model mapper
    public SchoolClassDTO map(SchoolClass schoolClass){
        return new SchoolClassDTO(
                schoolClass.getName(),
                schoolClass.getGrade()
        );
    }

    public void map(SchoolClass schoolClass, SchoolClassDTO schoolClassDTO){
        schoolClass.setName(schoolClassDTO.getName());
        schoolClass.setGrade(schoolClassDTO.getGrade());
    }

    public SchoolClass createModelWithDTO(SchoolClassDTO schoolClassDTO){
        SchoolClass schoolClass = new SchoolClass();
        map(schoolClass, schoolClassDTO);
        return schoolClass;
    }

    public List<SchoolClass> getAll(){
        return repository.findAll();
    }

    public SchoolClassDTO getById(Integer id) throws ServiceException {
        SchoolClass schoolClass = repository.findById(id).orElseThrow(() -> new ServiceException(
                "School Class not found with ID: " + id,
                HttpStatus.NOT_FOUND
        ));
        return map(schoolClass);
    }

    public void create(SchoolClassDTO schoolClassDTO){
        repository.save(createModelWithDTO(schoolClassDTO));
    }

    public void update(Integer id, SchoolClassDTO schoolClassDTO) throws ServiceException {
        SchoolClass schoolClass = repository.findById(id).orElseThrow(() -> new ServiceException(
                "School Class not found with ID: " + id,
                HttpStatus.NOT_FOUND
        ));
        map(schoolClass, schoolClassDTO);
        repository.save(schoolClass);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
