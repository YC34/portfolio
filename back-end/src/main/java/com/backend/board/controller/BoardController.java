package com.backend.board.controller;

import com.backend.board.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BoardController {
    @Autowired
    private BoardService boardService;


//    public BoardController(BoardService boardService) {
//        this.boardService = boardService;
//    }



    @GetMapping("/board")
    public String getboards() {return "/board/board";}

    @PostMapping("/add")
    public String addBoard(){return "redirect:/board";}

    @DeleteMapping("/delete/{fNum}")
    public String deleteBoard(@PathVariable int fnum){return "redirect:/board";}

    @PutMapping("/update")
    public String updateBoard(){return "redirect:/board";}

    @GetMapping("/{fNum}")
    public String getBoard(@PathVariable int fnum){return "/board/view";}

}
