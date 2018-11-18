/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import model.Student;

/**
 *
 * @author Than
 */
public class ServerDAO {

    private Connection conn;
    
    public ServerDAO() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydatabase"
                    + "?useUnicode=true&characterEncoding=utf-8","root","");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public boolean addStudent(Student s){
        String sql = "INSERT INTO tblstudent(id, name, dob, year, address) VALUES(?,?,?,?,?)";
        try {
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, s.getId());
            ps.setString(2, s.getName());
            ps.setDate(3, new Date(s.getDob().getTime()));
            ps.setInt(4, s.getYear());
            ps.setString(5, s.getAddress());
            ps.executeUpdate();
            return true; // thanh cong!
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
    
}
