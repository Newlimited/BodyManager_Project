package com.groupd.bodymanager.service;
import com.groupd.bodymanager.dto.response.board.GetBoardResponseDto;
import com.groupd.bodymanager.dto.response.board.GetBoardListResponseDto;
import org.springframework.http.ResponseEntity;

import com.groupd.bodymanager.dto.request.board.GetBoardListWithWord;
import com.groupd.bodymanager.dto.request.board.PatchBoardRequestDto;
import com.groupd.bodymanager.dto.request.board.PostBoardRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;

public interface BoardService {
    public ResponseEntity<ResponseDto> postBoard(String email, PostBoardRequestDto dto);
    public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber);
    public ResponseEntity<? super GetBoardListResponseDto> getBoardList();
    public ResponseEntity<? super GetBoardListResponseDto> getBoardWithWords(GetBoardListWithWord words);
    
    public ResponseEntity<ResponseDto> patchBoard(String userEmail, PatchBoardRequestDto dto);
    public ResponseEntity<ResponseDto> deleteBoard(String email, Integer boardNumber);
}
