package com.korit.servlet_study.ch08;


import com.korit.servlet_study.ch03.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor

public class Board {
    private String title;
    private String content;
    private String writer;

}
