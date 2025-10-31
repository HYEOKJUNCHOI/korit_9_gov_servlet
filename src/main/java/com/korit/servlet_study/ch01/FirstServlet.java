package com.korit.servlet_study.ch01;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

///추상클래스이긴한데 추상매서드가 하나도 없다
public class FirstServlet extends HttpServlet {

    //  객체 생성은 딱 한번만 일어남
    public FirstServlet() {

        System.out.println("FirstServlet 생성자 호출");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        System.out.println("초기화");
        config.getServletContext().setAttribute("age", 32);
    }

    @Override
    public void destroy() {
        System.out.println("소멸");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("서비스 메서드 요청 들어옴");
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("요청들어옴");



    }
}