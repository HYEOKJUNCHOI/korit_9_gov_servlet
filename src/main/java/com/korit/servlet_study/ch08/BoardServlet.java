package com.korit.servlet_study.ch08;

import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/gurwns123") // URL 생성시 이름앞 "/" 필수!
public class BoardServlet extends HttpServlet {

   private List<Board> arr = new ArrayList<>();


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
        // req 요청 // resp 응답 // application/json

        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
        resp.setContentType("application/json");
//        BufferedReader br = req.getReader();
//
//       StringBuilder json = new StringBuilder();
//
//        while (true) {
//            String str = br.readLine();
//            if (str == null) break;
//            json.append(str);
//        }
//        System.out.println("요청 JSON : " + json);

        // ObjectMapper = JSON으로 변환 툴
        // InputStream = 데이터 통로 // 다리
        // InputStreamReader = str을 한명씩만 데리고 감 // 가이드
        // BufferedReader = 여럿을 데리고 이동가능(한줄씩) // 버스(버퍼) + 가이드(리더) = 버퍼드리더 / 생성필요 / 전송속도 느림
        // readLine = BufferedReader에 실린 데이터들을 한줄 내려놓음 // 정류장에 한줄 내림
        // StringBuilder = 미리 크게 생성해둔 메모리에 , 값을 append()로 추가 //
        // setCharacterEncoding(StandardCharsets.UTF_8.name()); // 통역사
        // resp.setContentType("application/json"); // 번역할 언어
        //    private List<Board> arr = new ArrayList<>();
        //

        ObjectMapper om = new ObjectMapper();

       Board boards = om.readValue(req.getReader(), Board.class);

        arr.add(boards);
        System.out.println("List : " + arr);

        Response response = new Response();
        response.setMessage("게시글 작성 완료");
        om.writeValue(resp.getWriter(), response);


//        req.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());
//        resp.setContentType("application/json");



    }
}
