package com.groupd.bodymanager.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.groupd.bodymanager.dto.response.board.GetBoardResponseDto;
import com.groupd.bodymanager.dto.response.board.GetBoardListResponseDto;
import com.groupd.bodymanager.dto.request.board.PatchBoardRequestDto;
import com.groupd.bodymanager.dto.request.board.PostBoardRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.service.BoardService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/board")
@RequiredArgsConstructor
public class BoardController {
    private final BoardService boardService;

    // 1. 게시물 등록
    @PostMapping("")
    public ResponseEntity<ResponseDto> postBoard(
            @AuthenticationPrincipal String userEmail,
            @Valid @RequestBody PostBoardRequestDto requestbody) {
        ResponseEntity<ResponseDto> response = boardService.postBoard(requestbody);
        return response;

    }

    // 2. 특정게시물 조회
    @GetMapping("/{boardNumber}")
    public ResponseEntity<? super GetBoardResponseDto> getBoard(
            @PathVariable("boardNumber") Integer boardNumber) {
        ResponseEntity<? super GetBoardResponseDto> response = boardService.getBoard(boardNumber);
        return response;
    }

    // 3. 게시물 목록 조회
    @GetMapping("/list")
    public ResponseEntity<? super GetBoardListResponseDto> getBoard() {
        ResponseEntity<? super GetBoardListResponseDto> response = boardService.getBoardList();
        return response;
    }
    // 4. 특정 게시물 수정
    @PatchMapping("")
    public ResponseEntity<ResponseDto> patchBoard(
            @AuthenticationPrincipal String userEmail,
    @Valid @RequestBody PatchBoardRequestDto requestBody) {
        ResponseEntity<ResponseDto> response = 
        boardService.patchBoard(userEmail, requestBody);
        return response;
    }
    // 5. 특정 게시물 삭제
    @DeleteMapping("/{boardNumber}")
    public ResponseEntity<ResponseDto> deleteBoard(
        @AuthenticationPrincipal String email,
        @PathVariable("boardNumber") Integer boardNumber
        ){
        ResponseEntity<ResponseDto> response = 
        boardService.deleteBoard(email, boardNumber);
        return response;
}
    
}
