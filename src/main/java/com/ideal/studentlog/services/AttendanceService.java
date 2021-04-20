package com.ideal.studentlog.services;

import com.ideal.studentlog.database.models.Attendance;
import com.ideal.studentlog.database.repositories.AttendanceRepository;
import com.ideal.studentlog.helpers.dtos.AttendanceDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {
    private final AttendanceRepository repository;

    public List<Attendance> getAll() {
        return repository.findAll();
    }

    public void create(AttendanceDTO dto) {
        Attendance attendance = new Attendance();
        attendance.setDate(dto.getDate());
        attendance.setStudentId(dto.getStudentId());
        attendance.setTeacherId(dto.getTeacherId());
        attendance.setIsPresent(dto.getIsPresent());
     
        repository.save(attendance);
    }

    public AttendanceDTO getById(Integer id) {
        Attendance attendance = repository.findById(id).orElseThrow();

        return new AttendanceDTO(
                attendance.getDate(),
                attendance.getStudentId(),
                attendance.getTeacherId(),
                attendance.getIsPresent()
        );
    }

    public void update(Integer id, AttendanceDTO dto) {
        Attendance attendance = repository.findById(id).orElseThrow();
        attendance.setDate(dto.getDate());
        attendance.setStudentId(dto.getStudentId());
        attendance.setTeacherId(dto.getTeacherId());
        attendance.setIsPresent(dto.getIsPresent());
        
        repository.save(attendance);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }

}

