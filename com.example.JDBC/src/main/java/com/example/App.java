package com.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.*;

public class App
{
//    Connection conn = null; //responsible for making connection with database
//    Statement stm = null; //used to execute sql queries in mysql server
//    PreparedStatement ps = null;


    public static void main( String[] args ) throws SQLException {
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        MyJoinpoint joinpoint = context.getBean(MyJoinpoint.class);
        //joinpoint.insertData("Ravi4",50000,"ravi4@gmail.com","asd","14611484148");
        joinpoint.fetchAllData();
    }
}
