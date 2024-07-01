package com.example;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import java.sql.Connection;
import java.sql.DriverManager;

@Aspect
public class MyAspect {

    @Before("execution (* com.example.MyJoinpoint.*())")
    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //using driver to connect with database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","4281");
            System.out.println("Connected");
            return conn;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}
