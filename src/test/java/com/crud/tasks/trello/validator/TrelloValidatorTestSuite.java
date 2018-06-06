package com.crud.tasks.trello.validator;

import com.crud.tasks.domain.TrelloBoard;
import com.crud.tasks.domain.TrelloCard;
import com.crud.tasks.domain.TrelloList;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrelloValidatorTestSuite {

    @Autowired
    private TrelloValidator trelloValidator;

    @Test
    public void testValidateTrelloBoards() {
        //Given
        String listId = "List12345";
        String listName = "listName";
        boolean isClosedList = false;
        String boardId = "Test";
        String boardName = "Board12345";

        List<TrelloList> trelloList = new ArrayList<>();
        trelloList.add(new TrelloList(listId, listName, isClosedList));
        List<TrelloBoard> trelloBoard = new ArrayList<>();
        trelloBoard.add(new TrelloBoard(boardId, boardName, trelloList));
        //When
        List<TrelloBoard> validateTrelloBoardList = trelloValidator.validateTrelloBoards(trelloBoard);
        //Then
        assertEquals(0, validateTrelloBoardList.size());
    }

    @Test
    public void testValidateCardTrue() {
        //Given
        String cardName = "Card name";
        String cardDescription = "Card description";
        String cardPos = "Card Pos";
        String cardListId = "ListId123456";

        TrelloCard trelloCard = new TrelloCard(cardName, cardDescription, cardPos, cardListId);
        //When
        boolean validateTrelloCard = trelloValidator.validateCard(trelloCard);
        //Then
        assertTrue(validateTrelloCard);
    }

    @Test
    public void testValidateCardFalse() {
        //Given
        String cardName = "Card test";
        String cardDescription = "Card desc";
        String cardPos = "Card pos";
        String cardListId = "ListId99999";

        TrelloCard trelloCard = new TrelloCard(cardName, cardDescription, cardPos, cardListId);
        //When
        boolean validateTrelloCard = trelloValidator.validateCard(trelloCard);
        //Then
        assertFalse(validateTrelloCard);
    }

}