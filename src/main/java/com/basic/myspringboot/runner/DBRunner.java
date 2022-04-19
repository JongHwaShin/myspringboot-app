package com.basic.myspringboot.runner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;

// 나중에 h2데이터베이스를 쓰는지 mariaDB중에 뭘쓰는지 모르니 나중에 뭘스는지 알기위해
@Component
public class DBRunner implements ApplicationRunner {
    @Autowired
    DataSource dataSource;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println("DataSource 구현 클래스 이름 "+dataSource.getClass().getName());
        Connection connection = dataSource.getConnection();
        DatabaseMetaData metaData = connection.getMetaData();
        System.out.println("DB URL =" + metaData.getURL());
        System.out.println("DB Vendor ="+ metaData.getDatabaseProductName());
        System.out.println("DB Username =" + metaData.getUserName());

    }


}
