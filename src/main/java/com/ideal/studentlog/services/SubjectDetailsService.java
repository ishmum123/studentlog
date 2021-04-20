package com.ideal.studentlog.services;

import com.ideal.studentlog.database.models.SubjectDetails;
import com.ideal.studentlog.database.repositories.SubjectDetailsRepository;
import com.ideal.studentlog.helpers.dtos.SubjectDetailsDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectDetailsService {
    private final SubjectDetailsRepository repository;

    public List<SubjectDetails> getAll() {
        return repository.findAll();
    }

    public void create(SubjectDetailsDTO dto) {
        SubjectDetails subjectDetails = new SubjectDetails();
        subjectDetails.setSubjectId(dto.getSubjectId());
        subjectDetails.setTeacherId(dto.getTeacherId());
        subjectDetails.setClassDetailsId(dto.getClassDetailsId());

        repository.save(subjectDetails);
    }

    public SubjectDetailsDTO getById(Integer id) {
        SubjectDetails subjectDetails = repository.findById(id).orElseThrow();

        return new SubjectDetailsDTO(
            subjectDetails.getSubjectId(),
            subjectDetails.getTeacherId(),
            subjectDetails.getClassDetailsId()
        );
    }

    public void update(Integer id, SubjectDetailsDTO dto) {
        SubjectDetails subjectDetails = repository.findById(id).orElseThrow();
        subjectDetails.setSubjectId(dto.getSubjectId());
        subjectDetails.setTeacherId(dto.getTeacherId());
        subjectDetails.setClassDetailsId(dto.getClassDetailsId());

        repository.save(subjectDetails);
    }

    public void delete(Integer id) {
        repository.deleteById(id);
    }
}
