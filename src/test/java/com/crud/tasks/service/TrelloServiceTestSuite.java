package com.crud.tasks.service;

import com.crud.tasks.domain.CreatedTrelloCardDto;
import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.domain.TrelloCardDto;
import com.crud.tasks.domain.TrelloListDto;
import com.crud.tasks.trello.client.TrelloClient;
import com.crud.tasks.trello.config.AdminConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class TrelloServiceTestSuite {
    @InjectMocks
    private TrelloService trelloService;

    @Mock
    private AdminConfig adminConfig;

    @Mock
    private TrelloClient trelloClient;

    @Mock
    private SimpleEmailService emailService;

    @Test
    public void shouldFetchTrelloBoards() {
        //Given
        List<TrelloListDto> lists = new ArrayList<>();
        lists.add(new TrelloListDto("2", "Test", false));
        List<TrelloBoardDto> boards = new ArrayList<>();
        boards.add(new TrelloBoardDto("123", "Test", lists));

        when(trelloClient.getTrelloBoards()).thenReturn(boards);
        //When
        List<TrelloBoardDto> fetchTrelloBoards = trelloService.fetchTrelloBoards();
        //Then
        assertEquals(1, fetchTrelloBoards.size());
        assertEquals("123", fetchTrelloBoards.get(0).getId());
        assertEquals("Test", fetchTrelloBoards.get(0).getName());
        assertEquals(1, fetchTrelloBoards.get(0).getLists().size());
        assertEquals("2", fetchTrelloBoards.get(0).getLists().get(0).getId());
        assertEquals("Test", fetchTrelloBoards.get(0).getLists().get(0).getName());
        assertEquals(false, fetchTrelloBoards.get(0).getLists().get(0).isClosed());
    }

    @Test
    public void shouldCreatedTrelloCard() {
        //Given
        TrelloCardDto trelloCardDto = new TrelloCardDto("First card", "Test card", "Top", "1");
        CreatedTrelloCardDto cardDto = new CreatedTrelloCardDto("Test id", "Testing", "Test URL");

        when(trelloClient.createNewCard(trelloCardDto)).thenReturn(cardDto);
        //When
        CreatedTrelloCardDto createdTrelloCardDto = trelloService.createdTrelloCard(trelloCardDto);
        //Then
        assertEquals("Test id", createdTrelloCardDto.getId());
        assertEquals("Testing", createdTrelloCardDto.getName());
        assertEquals("Test URL", createdTrelloCardDto.getShortUrl());

    }
}