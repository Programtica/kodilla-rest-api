package com.crud.tasks.trello.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminConfigTestSuite {
    @Autowired
    public AdminConfig adminConfig;

    @Test
    public void testAdminInfo() {
        //Given
        //When
        //Then
        assertTrue("It contains", adminConfig.getAdminName().contains("K"));
    }
}