package com.korit.servlet_study.ch11.Dto;

import com.korit.servlet_study.ch11.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {
    private String name;
    private String phone;
    private String email;
    private int department;
    private int grade;
    private String major;
    private int admissionYear;

    public Student toEntity() {
        return Student.builder()
                .sutdentName(name)
                .phone(phone)
                .email(email)
                .departmentID(department)
                .grade(grade)
                .majorType(major)
                .admissionYear(Integer.toString(admissionYear))
                .build();
    }

}
