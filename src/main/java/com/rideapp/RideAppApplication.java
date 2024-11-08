package com.rideapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.sql.DataSource;

@SpringBootApplication
public class RideAppApplication {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/rideapp");
        dataSource.setUsername("root");
        dataSource.setPassword("root");
        return dataSource;
    }

    public static void main(String[] args) {
        SpringApplication.run(RideAppApplication.class, args);
    }
}
