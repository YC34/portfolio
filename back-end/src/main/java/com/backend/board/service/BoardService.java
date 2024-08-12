package com.backend.board.service;

import com.backend.board.dto.Board;

import com.backend.board.repository.BoardMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BoardService {

    @Autowired
    private BoardMapper boardMapper;

    public Board addBoard(Board board) {return boardMapper.addBoard(board);}

    public Board updateBoard(Board board) {return boardMapper.updateBoard(board);}


    public Board deleteBoard(int fnum){return boardMapper.delBoard(fnum);}

    public Board getBoard(int fnum) {return boardMapper.getBoard(fnum);}


    public Board getBoards(){return boardMapper.getBoards();}

};