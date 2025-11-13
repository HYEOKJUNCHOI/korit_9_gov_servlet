//package com.korit.servlet_study.연습;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import java.sql.Array;
//import java.util.ArrayList;
//import java.util.List;
//
//    @WebServlet("/bank/costomers")
//    public class BankCustomerServlet extends HttpServlet {
//
//        private List<BankCustomer> customers;
//
//        @Override
//        public void init() throws ServletException {
//            customers = new ArrayList<>();
//
//            customers.add(BankCustomer.builder()
//                    .customerId("C001")
//                    .name("최혁준")
//                    .password("1234")
//                    .phone("010-3673-1230")
//                    .email("gurwns369@naver.com")
//                    .address("부산진구")
//                    .build());
//
//            System.out.println("은행 시스템 초기화 완료! 테스트 고객 1명 등록완료");
//
//        }
//
//
//
//}
