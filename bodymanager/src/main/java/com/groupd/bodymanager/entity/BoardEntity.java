package com.groupd.bodymanager.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.groupd.bodymanager.dto.request.board.PostBoardRequestDto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Board")
@Table(name = "Board")
public class BoardEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer boardNumber;
    private String boardWriterEmail;
    private String boardWriterNickname;
    private String boardTitle;
    private String boardContent;
    private String boardImageUrl;
    private String boardWriteDatetime;
    private int viewCount;
    
    public BoardEntity(String email, PostBoardRequestDto dto){
        Date now = new Date();
        SimpleDateFormat simpleDateFormat =
        new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String writeDateTime = simpleDateFormat.format(now);
        this.boardWriterEmail = email;
        this.boardTitle = dto.getBoardTitle();
        this.boardContent = dto.getBoardContent();
        this.boardImageUrl = dto.getBoardImageUrl();
        this.boardWriteDatetime = writeDateTime;
        this.viewCount = 0;

    }
}
