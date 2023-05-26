package com.groupd.bodymanager.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.entity.BoardEntity;
import com.groupd.bodymanager.entity.resultSet.BoardListResultSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetBoardListResponseDto extends ResponseDto{
    private List<BoardSummary> boardList;
// 게시물 목록 조회
    public GetBoardListResponseDto(List<? extends Object> resultSet){
        super("SU","Success");

        List<BoardSummary> boardList = new ArrayList<>();
        
        for(Object result : resultSet) {
            BoardSummary boardSummary = new BoardSummary();
            if (result instanceof BoardEntity)
                boardSummary = new BoardSummary((BoardEntity) result);
            if (result instanceof BoardListResultSet)
                boardSummary = new BoardSummary((BoardListResultSet) result);
            boardList.add(boardSummary);
        }
        this.boardList = boardList;
    }
}

@Data
@AllArgsConstructor
@NoArgsConstructor
class BoardSummary {
   
    private Integer boardNumber;
    private String boardTitle;
    private String boardContent;
    private String boardImageUrl;
    private String boardWriteDatetime;
    private int viewCount;
    private String boardWriterEmail;
  
    public BoardSummary(BoardListResultSet resultSet){
        this.boardNumber = resultSet.getBoardNumber();
        this.boardTitle =resultSet.getTitle();
        this.boardContent=resultSet.getBoardContent();
        this.boardImageUrl=resultSet.getBoardimageUrl();
        this.boardWriteDatetime = resultSet.getBoardWriteDatetime();
        this.viewCount = resultSet.getViewCount();
        this.boardWriterEmail = resultSet.getBoardWriterEmail();
    }

    public BoardSummary(BoardEntity boardEntity){
        this.boardNumber = boardEntity.getBoardNumber();
        this.boardTitle =boardEntity.getBoardTitle();
        this.boardContent=boardEntity.getBoardContent();
        this.boardImageUrl=boardEntity.getBoardImageUrl();
        this.boardWriteDatetime = boardEntity.getBoardWriteDatetime();
        this.viewCount = boardEntity.getViewCount();
        this.boardWriterEmail = boardEntity.getBoardWriterEmail();
    }

}