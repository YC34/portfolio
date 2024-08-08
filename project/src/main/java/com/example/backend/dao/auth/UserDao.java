package com.example.backend.dao.auth;


import com.example.backend.dto.auth.User;
import com.example.backend.dto.auth.UserRole;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import java.sql.*;

@Repository
public class UserDao {

    @Value("${mariadb.driver}")
    private String JDBC_DRIVER ;
    @Value("${mariadb.url}")
    private String JDBC_URL;
    @Value("${mariadb.user}")
    private String user;
    @Value("${mariadb.password}")
    private String password;

    public Connection open(){
        Connection conn = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(JDBC_URL,user,password);
        }catch (Exception e){
            System.out.println("ERROR : "+e.getMessage());
            throw new RuntimeException(e);
        }
        return conn;
    }
    // 회원가입
    public void addUser(User user) throws Exception{
        Connection conn = open();
        String sql = "insert into user(username,password,auth) values(?,?,?)";
        PreparedStatement ps = conn.prepareStatement(sql);
        try(conn; ps){
            ps.setString(1,user.getUsername());
            ps.setString(2,user.getPassword());
            ps.setString(3,user.getAuth().toString());
            ps.executeUpdate();
        }
    }

    // 유저 정보 조회.
    public User getUser(String username) throws Exception{
        Connection conn = open();
        User user = new User();
        String sql = "select * from user where username=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,username);
        ResultSet rs = ps.executeQuery();
        if(!rs.next()){
            throw new SQLException("username을 확인하세요");
        }else{
            try(conn;ps){
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setAuth(UserRole.valueOf(rs.getString("auth")));
                user.setCreateAt(rs.getDate("create_at"));
            }
        }
        return user;
    }

    // 가입시 중복확인(username만 참조)
    public boolean checkUser(String username) throws SQLException{
        Connection conn = open();
        String sql = "select COUNT(*) from user where username=?";
        PreparedStatement ps = conn.prepareStatement(sql);
        ps.setString(1,username);
        ResultSet rs = ps.executeQuery();

        boolean check = false;
        try(conn;ps;rs){
            if(rs.next()){
                check = rs.getInt(1) > 0;
            }
        }
        return check;
    }

    // login : 회원체크
    public boolean checkUser(String username, String password) throws SQLException{
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        try {
            conn = open();
            String sql = "select COUNT(*) from user where username=? and password=?";
            pstmt = conn.prepareStatement(sql);

            System.out.println(password);
            pstmt.setString(1,username);
            pstmt.setString(2,password);

            rs = pstmt.executeQuery();

            if(rs.next()){
                int count = rs.getInt(1);
                return count > 0;
            }
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }finally {
            rs.close();
            pstmt.close();
            conn.close();
        }
        return false;
    }

}
