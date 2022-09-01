package com.hiwangzi.c17_jdbc;

import java.sql.*;

public class Main {

    public static void main(String[] args) throws SQLException {
        // JDBC连接的URL, 不同数据库有不同的格式:
        String JDBC_URL = "jdbc:mysql://localhost:3307/learnjdbc?useSSL=false&characterEncoding=utf8";
        String JDBC_USER = "op";
        String JDBC_PASSWORD = "r8IFoHKI6zWpE7LFof+h1e0hduY";
        // 获取连接:
        try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
            try (Statement stmt = conn.createStatement()) {
                try(ResultSet rs = stmt.executeQuery("SELECT id, grade, name, gender FROM students WHERE gender=1")) {
                    while (rs.next()){
                        long id = rs.getLong(1); // 注意：索引从1开始
                        long grade = rs.getLong(2);
                        String name = rs.getString(3);
                        int gender = rs.getInt(4);
                        System.out.println(id);
                    }
                }
            }
        }
    }
}
