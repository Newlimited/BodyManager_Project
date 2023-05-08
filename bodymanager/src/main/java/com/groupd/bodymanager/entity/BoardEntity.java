package com.groupd.bodymanager.entity;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.groupd.bodymanager.dto.request.board.PostBoardRequestDto;
import com.groupd.bodymanager.dto.request.user.SignUpRequestDto;

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
    private int boradNumber;
    private String boardWriternickname;
    private String boardTitle;
    private String boardContent;
    private String BoardImageUrl;
    private String boradWriteDatetime;
    private int viewCount;
    
    public BoardEntity(PostBoardRequestDto dto){
        Date now = new Date();
        SimpleDateFormat simpleDateFormat =
        new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String writeDateTime = simpleDateFormat.format(now);

        this.boardWriternickname = dto.getBoardWriterNickname();
        this.boardTitle = dto.getBoardTitle();
        this.boardContent = dto.getBoardContent();
        this.BoardImageUrl = dto.getBoardImageUrl();
        this.boradWriteDatetime = writeDateTime;
        this.viewCount = 0;

    }
}
