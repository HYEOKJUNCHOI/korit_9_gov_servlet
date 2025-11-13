package com.korit.servlet_study.ch11.dao;

import com.korit.servlet_study.ch11.entity.Department;
import com.korit.servlet_study.ch11.util.DBConnectionMgr;
import lombok.RequiredArgsConstructor;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
public class DepartmentDao {
    private final DBConnectionMgr mgr;

    public List<Department> findAll() {
        List<Department> departments = new ArrayList<>();

        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            con = mgr.getConnection();
            String sql = """
                    select 
                        department_id,
                        department_code,
                        department_name
                    from
                        department_tb
                    order by 
                        department_id
                    """;
            ps = con.prepareStatement(sql);
            rs =ps.executeQuery(); // 컨트롤 + 엔터

            while (rs.next()) {
                Department department = Department.builder()
                        .departmentId(rs.getInt("department_id"))
                        .departmentCode(rs.getString("department_code"))
                        .departmentName(rs.getString("department_name"))
                        .build();

                departments.add(department);

            }

        } catch (Exception e) {
//            throw new RuntimeException(e); ///프로그램안꺼지게 하기위해 지움
            e.printStackTrace();
        } finally {
            mgr.freeConnection(con, ps, rs);
        }

        return departments;

    }

}
