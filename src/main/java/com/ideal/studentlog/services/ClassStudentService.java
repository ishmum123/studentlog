package com.ideal.studentlog.services;

import com.ideal.studentlog.database.models.ClassStudent;
import com.ideal.studentlog.database.repositories.ClassDetailsRepository;
import com.ideal.studentlog.database.repositories.ClassStudentRepository;
import com.ideal.studentlog.database.repositories.StudentRepository;
import com.ideal.studentlog.helpers.dtos.ClassStudentDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassStudentService {
    private final ClassStudentRepository repository;
    private final ClassDetailsRepository classDetailsRepository;
    private final StudentRepository studentRepository;

    //Todo: introduce model mapper
    public ClassStudentDTO model2dto(ClassStudent classStudent){
        return new ClassStudentDTO(
                classStudent.getClassDetails().getId(),
                classStudent.getStudent().getId()
        );
    }

    public ClassStudent dto2model(ClassStudent classStudent, ClassStudentDTO classStudentDTO){
        classStudent.setClassDetails(classDetailsRepository.findById(classStudentDTO.getClassDetailsId()).orElseThrow());
        classStudent.setStudent(studentRepository.findById(classStudentDTO.getStudentId()).orElseThrow());
        return classStudent;
    }

    public ClassStudent createModelWithDTO(ClassStudentDTO classStudentDTO){
        return dto2model(new ClassStudent(), classStudentDTO);
    }

    public List<ClassStudent> getAll(){
        return repository.findAll();
    }

    public ClassStudentDTO getById(Integer id){
        ClassStudent classStudent = repository.findById(id).orElseThrow();
        return model2dto(classStudent);
    }

    public void create(ClassStudentDTO classStudentDTO){
        repository.save(createModelWithDTO(classStudentDTO));
    }

    public void update(Integer id, ClassStudentDTO classStudentDTO){
        ClassStudent classStudent = repository.findById(id).orElseThrow();
        classStudent = dto2model(classStudent, classStudentDTO);
        repository.save(classStudent);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
