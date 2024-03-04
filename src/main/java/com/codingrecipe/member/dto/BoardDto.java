package com.codingrecipe.member.dto;

import lombok.Getter;
import lombok.ToString;

import java.sql.Timestamp;

@Getter
@ToString
public class BoardDto {
    private Long id;
    private String boardWriter;
    private String boardPass;
    private String boardTitle;
    private String boardContents;
    private int boardHits;
    private Timestamp boardCreateTime;

    public void setId(Long id) {
        this.id = id;
    }

    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }

    public void setBoardPass(String boardPass) {
        this.boardPass = boardPass;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public void setBoardContents(String boardContents) {
        this.boardContents = boardContents;
    }

    public void setBoardHits(int boardHits) {
        this.boardHits = boardHits;
    }

    public void setBoardCreateTime(Timestamp boardCreateTime) {
        this.boardCreateTime = boardCreateTime;
    }
}
