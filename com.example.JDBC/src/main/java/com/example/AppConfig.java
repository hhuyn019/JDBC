package com.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
@EnableAspectJAutoProxy
public class AppConfig {
    @Bean
    public MyJoinpoint joinpoint() {
        return new MyJoinpoint(this.connect());
    }

    @Bean
    public Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); //using driver to connect with database
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/mydb","root","4281");
            return conn;
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Bean
    public MyAspect aspect() {
        return new MyAspect();
    }
}
