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
public class GetBoardResponseDto extends ResponseDto{
    private List<BoardSummary> boardList;

    public GetBoardResponseDto(List<BoardListResultSet> resultSet){
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
    private String boardWriterNickname;

    public BoardSummary(BoardListResultSet resultSet){
    this.boardNumber = resultSet.getBoardNumber();
    this.boardTitle =resultSet.getBoardTitle();
    this.boardContent=resultSet.getBoardContent();
    this.boardImageUrl=resultSet.getBoardimageUrl();
    this.boardWriteDatetime = resultSet.getBoardWrtieDatetime();
    this.viewCount = resultSet.getViewCount();
    this.boardWriterEmail = resultSet.getBoardWriterEmail();
    this.boardWriterNickname = resultSet.getBoardWriterNickname();

    }

}