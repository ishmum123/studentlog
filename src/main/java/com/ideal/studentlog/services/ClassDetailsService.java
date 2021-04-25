package com.ideal.studentlog.services;

import com.ideal.studentlog.database.models.ClassDetails;
import com.ideal.studentlog.database.repositories.ClassDetailsRepository;
import com.ideal.studentlog.database.repositories.TeacherRepository;
import com.ideal.studentlog.helpers.dtos.ClassDetailsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassDetailsService {
    private final ClassDetailsRepository repository;
    private final TeacherRepository teacherRepository;

    //Todo: introduce model mapper
    public ClassDetailsDTO model2dto(ClassDetails classDetails){
        return new ClassDetailsDTO(
                classDetails.getSchoolClass(),
                classDetails.getYear(),
                classDetails.getTeacher().getId()
        );
    }

    public ClassDetails dto2model(ClassDetails classDetails, ClassDetailsDTO classDetailsDTO){
        classDetails.setSchoolClass(classDetailsDTO.getSchoolClass());
        classDetails.setYear(classDetailsDTO.getYear());
        classDetails.setTeacher(teacherRepository.findById(classDetailsDTO.getTeacherId()).orElseThrow());
        return classDetails;
    }

    public ClassDetails createModelWithDTO(ClassDetailsDTO classDetailsDTO){
        return dto2model(new ClassDetails(), classDetailsDTO);
    }

    public List<ClassDetails> getAll(){
        return repository.findAll();
    }

    public ClassDetailsDTO getById(Integer id){
        ClassDetails classDetails = repository.findById(id).orElseThrow();
        return model2dto(classDetails);
    }

    public void create(ClassDetailsDTO classDetailsDTO){
        repository.save(createModelWithDTO(classDetailsDTO));
    }

    public void update(Integer id, ClassDetailsDTO classDetailsDTO){
        ClassDetails classDetails = repository.findById(id).orElseThrow();
        classDetails = dto2model(classDetails, classDetailsDTO);
        repository.save(classDetails);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
