package com.korit.servlet_study.ch10;

import java.sql.*;

/**
 *  JDBC JavaDataBaseConnection
 *
 */

public class JDBCMain {
    public static void main(String[] args) {
        // http://naver.com -> http 프로토콜
        // jdbc:mysql://ip:port ~~~~ -> jdbc:mysql 프로토콜
        // mysql의 port: 기본(3306), 우리가 설정한(3309)

        //  프로토콜://IP주소:PORT번호/데이터베이스이름

        final String URL = "jdbc:mysql://localhost:3309/student_db";
        final String USERNAME = "root";
        final String PASSWORD = "1q2w3e4r";

        try {
//            Class.forName("com.mysql.cj.jdbc.Driver"); // JDBC 4버전 이상부터는 생략가능
            Connection connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            String sql = """
                    select * from student_tb where student_name = '윤지아'
                    """;
            PreparedStatement ps = connection.prepareStatement(sql); /// 비유 : ps -> 코드입력창 / sql 입력
            ResultSet rs = ps.executeQuery(); /// 순서없고 중복없고 = set특징  // select 만 결과값을 가져온다.
            rs.next(); /// rs.hasNext <- 넥스트가 있니? 와일문 써서 반복가능

           int studentId = rs.getInt("student_id");
           String studentName = rs.getString("student_name");
            System.out.println("id: " + studentId);
            System.out.println("name: " + studentName);

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("데이터 베이스 연결 실패했어요.");
//        } catch (ClassNotFoundException e) {
//            throw new RuntimeException(e);
        }
    }
}