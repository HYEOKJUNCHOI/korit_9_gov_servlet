package com.korit.servlet_study.연습.Board;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;


@WebServlet("/dustmq")
public class BoardServlet1 extends HttpServlet {

    List<Board1> arr = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("application/json");

        ObjectMapper om = new ObjectMapper();

        om.writeValue(resp.getWriter(), arr);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("application/json");

        ObjectMapper om = new ObjectMapper();
       Board1 board1 = om.readValue(req.getReader(),Board1.class);
       arr.add(board1);

        Response1 response1 = new Response1();
        response1.setMessage("등록이 완료 되었습니다.");
        om.writeValue(resp.getWriter(), response1);

    }
}
