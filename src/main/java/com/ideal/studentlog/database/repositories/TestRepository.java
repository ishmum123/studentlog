package com.ideal.studentlog.database.repositories;

import com.ideal.studentlog.database.models.Test;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TestRepository extends JpaRepository<Test, Integer> {
    List<Test> findAll();
    List<Test> findTestBySubject(String subject);
}
