package com.crud.tasks.trello.config;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloConfigTestSuite {

    @Autowired
    private TrelloConfig trelloConfig;

    @Test
    public void testOfTrelloApiEndPoint() {
        //Given
        //When
        //Then
        assertFalse("It isn't empty!", trelloConfig.getTrelloApiEndPoint().isEmpty());
    }

}