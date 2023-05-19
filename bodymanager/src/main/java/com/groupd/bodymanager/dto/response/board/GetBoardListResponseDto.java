package com.groupd.bodymanager.dto.response.board;

import java.util.ArrayList;
import java.util.List;

import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.entity.resultSet.BoardListResultSet;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class GetBoardListResponseDto extends ResponseDto{
    private List<BoardSummary> boardList;
// 게시물 목록 조회
    public GetBoardListResponseDto(List<BoardListResultSet> resultSet){
        super("SU","Success");

        List<BoardSummary> boardList = new ArrayList<>();
        
        for(BoardListResultSet result : resultSet) {
            BoardSummary boardSummary = new BoardSummary(result);
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

}