package com.korit.servlet_study.연습.Board;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder

public class Board1 {
    private String title;
    private String content;
    private String writer;

}
