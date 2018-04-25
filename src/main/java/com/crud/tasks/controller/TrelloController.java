package com.crud.tasks.controller;

import com.crud.tasks.domain.TrelloBoardDto;
import com.crud.tasks.trello.client.TrelloClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/trello")
public class TrelloController {
    @Autowired
    private TrelloClient trelloClient;

    @RequestMapping(method = RequestMethod.GET, value = "getTrelloBoards")
    public List<TrelloBoardDto> getTrelloBoards() {

        List<TrelloBoardDto> trelloBoards = trelloClient.getTrelloBoards();

        trelloBoards.stream()
            .filter(board -> board.getId() != null && board.getName() != null)
            .filter(board -> board.getName().contains("Kodilla"))
            .forEach(trelloBoardDto -> {
                System.out.println("Our board contains lists: ");
                System.out.println(trelloBoardDto.getId() + " " + trelloBoardDto.getName());
            });
        
        return trelloClient.getTrelloBoards();
    }
}
