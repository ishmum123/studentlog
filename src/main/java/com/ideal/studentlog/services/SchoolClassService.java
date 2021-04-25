package com.ideal.studentlog.services;

import com.ideal.studentlog.database.models.SchoolClass;
import com.ideal.studentlog.database.repositories.SchoolClassRepository;
import com.ideal.studentlog.helpers.dtos.SchoolClassDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SchoolClassService {
    private final SchoolClassRepository repository;

    //Todo: introduce model mapper
    public SchoolClassDTO model2dto(SchoolClass schoolClass){
        return new SchoolClassDTO(
                schoolClass.getName(),
                schoolClass.getGrade()
        );
    }

    public SchoolClass dto2model(SchoolClass schoolClass, SchoolClassDTO schoolClassDTO){
        schoolClass.setName(schoolClassDTO.getName());
        schoolClass.setGrade(schoolClassDTO.getGrade());
        return schoolClass;
    }

    public SchoolClass createModelWithDTO(SchoolClassDTO schoolClassDTO){
        return dto2model(new SchoolClass(), schoolClassDTO);
    }

    public List<SchoolClass> getAll(){
        return repository.findAll();
    }

    public SchoolClassDTO getById(Integer id){
        SchoolClass schoolClass = repository.findById(id).orElseThrow();
        return model2dto(schoolClass);
    }

    public void create(SchoolClassDTO schoolClassDTO){
        repository.save(createModelWithDTO(schoolClassDTO));
    }

    public void update(Integer id, SchoolClassDTO schoolClassDTO){
        SchoolClass schoolClass = repository.findById(id).orElseThrow();
        schoolClass = dto2model(schoolClass, schoolClassDTO);
        repository.save(schoolClass);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
