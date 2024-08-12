package com.backend.board.repository;

import com.backend.board.dto.Board;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    Board getBoards();

    Board updateBoard(Board board);

    Board addBoard(Board board);

    Board delBoard(int fnum);

    Board getBoard(int fnum);
}
