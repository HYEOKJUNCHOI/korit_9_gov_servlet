package com.korit.servlet_study.ch11.service;

import com.korit.servlet_study.ch11.Dto.StudentDto;
import com.korit.servlet_study.ch11.dao.StudantDao;
import com.korit.servlet_study.ch11.entity.Student;
import lombok.RequiredArgsConstructor;

///

@RequiredArgsConstructor
public class StudentService {
    private final StudantDao studentDao;

    public void save(StudentDto studentDto){
        Student student = studentDto.toEntity();
        studentDao.insert(student);
    }
}
