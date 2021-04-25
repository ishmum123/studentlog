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
    public ClassStudentDTO map(ClassStudent classStudent){
        return new ClassStudentDTO(
                classStudent.getClassDetails().getId(),
                classStudent.getStudent().getId()
        );
    }

    public void map(ClassStudent classStudent, ClassStudentDTO classStudentDTO){
        classStudent.setClassDetails(classDetailsRepository.findById(classStudentDTO.getClassDetailsId()).orElseThrow());
        classStudent.setStudent(studentRepository.findById(classStudentDTO.getStudentId()).orElseThrow());
    }

    public ClassStudent createModelWithDTO(ClassStudentDTO classStudentDTO){
        ClassStudent classStudent = new ClassStudent();
        map(classStudent, classStudentDTO);
        return classStudent;
    }

    public List<ClassStudent> getAll(){
        return repository.findAll();
    }

    public ClassStudentDTO getById(Integer id){
        ClassStudent classStudent = repository.findById(id).orElseThrow();
        return map(classStudent);
    }

    public void create(ClassStudentDTO classStudentDTO){
        repository.save(createModelWithDTO(classStudentDTO));
    }

    public void update(Integer id, ClassStudentDTO classStudentDTO){
        ClassStudent classStudent = repository.findById(id).orElseThrow();
        map(classStudent, classStudentDTO);
        repository.save(classStudent);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
