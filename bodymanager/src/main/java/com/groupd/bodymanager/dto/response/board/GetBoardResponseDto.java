package com.groupd.bodymanager.dto.response.board;

import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.entity.BoardEntity;
import com.groupd.bodymanager.entity.UserEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
// 특정 게시물 조회
public class GetBoardResponseDto extends ResponseDto{
    private int boardNumber;
    private String boardTitle;
    private String boardImageUrl;
    private String boardWriteDatetime;
    private int viewCount;
    private String boardWriterEmail;
    private String boardWriterNickname;
   

    public GetBoardResponseDto(BoardEntity boardEntity, UserEntity userEntity
    ){
        super("SU","Success");
        this.boardNumber = boardEntity.getBoardNumber();
        this.boardTitle = boardEntity.getBoardTitle();
        this.boardImageUrl = boardEntity.getBoardImageUrl();
        this.boardWriteDatetime = boardEntity.getBoradWriteDatetime();
        this.viewCount = boardEntity.getViewCount();
        this.boardWriterEmail = userEntity.getUserEmail();
        this.boardWriterNickname = userEntity.getUserNickname();
        
    }
}