package com.ideal.studentlog.services;

import com.ideal.studentlog.database.models.StudentApplication;
import com.ideal.studentlog.database.repositories.AdminRepository;
import com.ideal.studentlog.database.repositories.StudentApplicationRepository;
import com.ideal.studentlog.helpers.dtos.StudentApplicationDTO;
import com.ideal.studentlog.helpers.exceptions.ServiceException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentApplicationService {
    private final StudentApplicationRepository repository;
    private final AdminRepository adminRepository;

    //Todo: introduce model mapper
    public StudentApplicationDTO map(StudentApplication studentApplication){
        return new StudentApplicationDTO(
                studentApplication.getAppliedDate(),
                studentApplication.getApprovedBy().getId(),
                studentApplication.getName(),
                studentApplication.getDateOfBirth(),
                studentApplication.getBloodGroup(),
                studentApplication.getBirthRegistrationId(),
                studentApplication.getRegistrationId(),
                studentApplication.getPresentAddress(),
                studentApplication.getPermanentAddress(),
                studentApplication.getGuardianName(),
                studentApplication.getGuardianEmail(),
                studentApplication.getGuardianPhone(),
                studentApplication.getAppliedForGrade()
        );
    }

    public void map(StudentApplication studentApplication, StudentApplicationDTO dto){
        studentApplication.setAppliedDate(dto.getAppliedDate());
        studentApplication.setApprovedBy(adminRepository.findById(dto.getApprovedBy()).orElseThrow());
        studentApplication.setName(dto.getName());
        studentApplication.setDateOfBirth(dto.getDateOfBirth());
        studentApplication.setBloodGroup(dto.getBloodGroup());
        studentApplication.setBirthRegistrationId(dto.getBirthRegistrationId());
        studentApplication.setRegistrationId(dto.getRegistrationId());
        studentApplication.setPresentAddress(dto.getPresentAddress());
        studentApplication.setPermanentAddress(dto.getPermanentAddress());
        studentApplication.setGuardianName(dto.getGuardianName());
        studentApplication.setGuardianEmail(dto.getGuardianEmail());
        studentApplication.setGuardianPhone(dto.getGuardianPhone());
        studentApplication.setAppliedForGrade(dto.getAppliedForGrade());
    }

    public StudentApplication createModelWithDTO(StudentApplicationDTO dto){
        StudentApplication studentApplication = new StudentApplication();
        map(studentApplication, dto);
        return studentApplication;
    }

    public List<StudentApplication> getAll() {
        return repository.findAll();
    }

    public void create(StudentApplicationDTO dto) {
        StudentApplication studentApplication = createModelWithDTO(dto);
        repository.save(studentApplication);
    }

    public StudentApplicationDTO getById(Integer id) throws ServiceException {
        StudentApplication studentApplication = repository.findById(id).orElseThrow(() -> new ServiceException(
                "Student Application not found with ID: " + id,
                HttpStatus.NOT_FOUND
        ));
        return map(studentApplication);
    }

    public void update(Integer id, StudentApplicationDTO dto) throws ServiceException {
        StudentApplication studentApplication = repository.findById(id).orElseThrow(() -> new ServiceException(
                "Student Application not found with ID: " + id,
                HttpStatus.NOT_FOUND
        ));
        map(studentApplication, dto);
        repository.save(studentApplication);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }






}
