package com.example;

import org.springframework.beans.factory.annotation.Autowired;

import java.sql.*;

public class MyJoinpoint {

    private Connection conn;

    @Autowired
    public MyJoinpoint(Connection conn) {
        this.conn = conn;
    }

    void fetchAllData() throws SQLException {
        String query = "select * from records";
        Statement stm = conn.createStatement();
        ResultSet rs = stm.executeQuery(query); //execute select query and return result set
        while(rs.next()) {
            System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4) + " " + rs.getString(5) + " " + rs.getString(6));
        }
    }

    void insertData(String name, int purchase, String email, String password, String phone) throws SQLException {
        String query = "insert into records(name,purchase,email,password,phone) values(?,?,?,?,?)";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1,name);
        ps.setInt(2,purchase);
        ps.setString(3,email);
        ps.setString(4, password);
        ps.setString(5, phone);
        ps.executeUpdate(); //executeUpdate() when making changes to table
    }

    void fetchSingleDataAndPrint(String email) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from records where email = ?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        rs.next();
        System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +rs.getString(3));
    }

    Record fetchSingleData(String email) throws SQLException {
        PreparedStatement ps = conn.prepareStatement("select * from records where email = ?");
        ps.setString(1, email);
        ResultSet rs = ps.executeQuery();
        rs.next();
        //System.out.println(rs.getInt(1) + " " + rs.getString(2) + " " +rs.getString(3));
        return new Record(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5));
    }

    void updatePhone(String email, String phone) throws SQLException {
        Record record = fetchSingleData(email);
        record.setPhone(phone);
        String query = "update records set phone = ? where email = ?";
        PreparedStatement ps = conn.prepareStatement(query);
        ps.setString(1, record.getPhone());
        ps.setString(2, record.getEmail());
        ps.executeUpdate();
    }
}
