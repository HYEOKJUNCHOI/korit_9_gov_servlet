package com.korit.servlet_study.ch09;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
// 3개 합친거 @Data 하면됨

public class Student {
    private int id;
    private String name;
    private int age;
    private String address;
    private String school;
}
