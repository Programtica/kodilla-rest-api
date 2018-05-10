package com.crud.tasks.mapper;

import com.crud.tasks.domain.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloMapperTestSuite {
    @Autowired
    private TrelloMapper trelloMapper;

    @Test
    public void testMapToBoards() {
        //Given
        String listName = "ListName";
        String listId = "82282734";
        boolean listIsClosed = false;

        String boardName = "BoardName";
        String boardId = "22982823";

        List<TrelloListDto> lists = new ArrayList<>();
        lists.add(new TrelloListDto(listName, listId, listIsClosed));

        List<TrelloBoardDto> trelloBoardDto = new ArrayList<>();
        trelloBoardDto.add(new TrelloBoardDto(boardName, boardId, lists));

        //When
        List<TrelloBoard> boardListDto = trelloMapper.mapToBoards(trelloBoardDto);

        //Then
        assertEquals(1, boardListDto.get(0).getList().size());
        assertEquals(boardId, boardListDto.get(0).getId());
        assertEquals(boardName, boardListDto.get(0).getName());
    }


    @Test
    public void testMapToBoardsDto() {
        //Given
        String listName = "ListName";
        String listId = "82282734";
        boolean listIsClosed = false;

        String boardName = "BoardName";
        String boardId = "22982823";

        List<TrelloList> lists = new ArrayList<>();
        lists.add(new TrelloList(listName, listId, listIsClosed));

        List<TrelloBoard> trelloBoard = new ArrayList<>();
        trelloBoard.add(new TrelloBoard(boardName, boardId, lists));

        //When
        List<TrelloBoardDto> boardListDto = trelloMapper.mapToBoardsDto(trelloBoard);

        //Then
        assertEquals(1, boardListDto.get(0).getLists().size());
        assertEquals(boardId, boardListDto.get(0).getId());
        assertEquals(boardName, boardListDto.get(0).getName());
    }

    @Test
    public void testMapToList() {
        //Given
        String listName = "ListName";
        String listId = "82282734";
        boolean listIsClosed = false;

        List<TrelloListDto> lists = new ArrayList<>();
        lists.add(new TrelloListDto(listId, listName, listIsClosed));

        //When
        List<TrelloList> trelloLists = trelloMapper.mapToList(lists);

        //Then
        assertEquals(listId, trelloLists.get(0).getId());
        assertEquals(listName, trelloLists.get(0).getName());
        assertEquals(listIsClosed, trelloLists.get(0).isClosed());
    }

    @Test
    public void testMapToListDto() {
        //Given
        String listName = "ListName";
        String listId = "82282734";
        boolean listIsClosed = false;

        List<TrelloList> lists = new ArrayList<>();
        lists.add(new TrelloList(listId, listName, listIsClosed));

        //When
        List<TrelloListDto> trelloLists = trelloMapper.mapToListDto(lists);

        //Then
        assertEquals(listId, trelloLists.get(0).getId());
        assertEquals(listName, trelloLists.get(0).getName());
        assertEquals(listIsClosed, trelloLists.get(0).isClosed());
    }

    @Test
    public void testMapToCard() {
        //Given
        String cardName = "CardName";
        String cardDesc = "CardDesc";
        String cardPos = "CardPos";
        String cardListId = "IdOfList9212284";
        TrelloCardDto trelloCardDto = new TrelloCardDto(cardName, cardDesc, cardPos, cardListId);

        //When
        TrelloCard trelloCard = trelloMapper.mapToCard(trelloCardDto);

        //Then
        assertEquals(cardName, trelloCard.getName());
        assertEquals(cardDesc, trelloCard.getDescription());
        assertEquals(cardPos, trelloCard.getPos());
        assertEquals(cardListId, trelloCard.getListId());
    }

    @Test
    public void testMapToCardDto() {
        //Given
        String cardName = "CardName";
        String cardDesc = "CardDesc";
        String cardPos = "CardPos";
        String cardListId = "IdOfList9212284";
        TrelloCard trelloCard = new TrelloCard(cardName, cardDesc, cardPos, cardListId);

        //When
        TrelloCardDto trelloCardDto = trelloMapper.mapToCardDto(trelloCard);

        //Then
        assertEquals(cardName, trelloCardDto.getName());
        assertEquals(cardDesc, trelloCardDto.getDescription());
        assertEquals(cardPos, trelloCardDto.getPos());
        assertEquals(cardListId, trelloCardDto.getListId());
    }
}
