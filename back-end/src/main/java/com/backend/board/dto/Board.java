package com.backend.board.dto;

import java.time.LocalDateTime;

public class Board {
    private int fnum;
    private String title;
    private int uid;     // user 테이블에서 외래키로 참조
    private LocalDateTime cdate;
    private String content;


}
