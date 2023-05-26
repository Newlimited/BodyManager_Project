package com.groupd.bodymanager.service.implement;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.groupd.bodymanager.common.CustomResponse;
import com.groupd.bodymanager.dto.request.board.GetBoardListWithWord;
import com.groupd.bodymanager.dto.request.board.PatchBoardRequestDto;
import com.groupd.bodymanager.dto.request.board.PostBoardRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.board.GetBoardListResponseDto;
import com.groupd.bodymanager.dto.response.board.GetBoardResponseDto;
import com.groupd.bodymanager.entity.BoardEntity;
import com.groupd.bodymanager.entity.UserEntity;
import com.groupd.bodymanager.entity.resultSet.BoardListResultSet;
import com.groupd.bodymanager.repository.BoardRepository;
import com.groupd.bodymanager.repository.ManagerRepository;
import com.groupd.bodymanager.repository.UserRepository;
import com.groupd.bodymanager.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final ManagerRepository managerRepository;
    public ResponseEntity<ResponseDto> postBoard(String email, PostBoardRequestDto dto) {

        // 게시물 작성
        String boardWriterEmail = email;
        UserEntity userEntity;
       
        try {
            // TODO 관리자 확인 
            boolean isManager = managerRepository.existsByManagerEmail(boardWriterEmail);
            if(!isManager){
                return CustomResponse.noPermission();
            }
            userEntity = userRepository.findByUserEmail(boardWriterEmail);
            String userNickname = userEntity.getUserNickname();

            BoardEntity boardEntity = new BoardEntity(email, dto);
            boardEntity.setBoardWriterNickname(userNickname);
            boardRepository.save(boardEntity);

        } catch (Exception exception) {
            // TODO : 데이터 베이스 오류반환
            exception.printStackTrace();

            return CustomResponse.databaseError();
        }
        // TODO: 성공반환
        return CustomResponse.successs();
    }

    @Override// 특정게시물 보기
    public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber) { 
        GetBoardResponseDto body = null;
        try {
            if (boardNumber == null) {
                return CustomResponse.validationFaild();
            }
            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) {
                return CustomResponse.notExistBoardNumber();
            }
            int viewCount = boardEntity.getViewCount();
            boardEntity.setViewCount(++viewCount);
            boardRepository.save(boardEntity);
            body = new GetBoardResponseDto(boardEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @Override// 게시물 목록 보기
    public ResponseEntity<? super GetBoardListResponseDto> getBoardList() { 
        GetBoardListResponseDto body = null;
        try {
             
            List<BoardListResultSet> resultSet = boardRepository.getList();
            body = new GetBoardListResponseDto(resultSet);

        } catch (Exception exception) {
            exception.printStackTrace();

            return CustomResponse.databaseError();

        }
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @Override // 특정 단어 포함된 게시물 목록보기
    public ResponseEntity<? super GetBoardListResponseDto> getBoardWithWords(GetBoardListWithWord dto){
        GetBoardListResponseDto body = null;
        String words = dto.getWords();
        words = '%'+words+'%';
        System.out.println(words);
        try {

            List<BoardEntity> resultSet = boardRepository.getSearchWord(words);
            if(resultSet == null){
                return CustomResponse.hasNoBoardWithWord();
            }
            body = new GetBoardListResponseDto(resultSet);
            

        } catch (Exception exception) {
            exception.printStackTrace();

            return CustomResponse.databaseError();

        }
        return ResponseEntity.status(HttpStatus.OK).body(body);
        
    }


    @Override //게시물 수정
    public ResponseEntity<ResponseDto> patchBoard(String managerEmail, PatchBoardRequestDto dto) {
        int boardNumber = dto.getBoardNumber();
        String boardTitle = dto.getBoardTitle();
        String boardContent = dto.getBoardContent();
        String boardImageUrl = dto.getBoardImageurl();
        String boardModifyEmail = managerEmail;
        UserEntity userEntity = userRepository.findByUserEmail(boardModifyEmail);
        String boardWriterNickname = userEntity.getUserNickname();
        try{
            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            // TODO : 존재하지 않는 게시물 번호 반환 boardNumber가 필요함
            if(boardEntity == null){
                return CustomResponse.notExistBoardNumber();
            }
            // TODO : 관리자 목록에 존재하지 않는 이메일 (존재하는 매니저의 이메일 이필요함)
            Boolean isExistManageEmail = managerRepository.existsByManagerEmail(managerEmail);
            if (!isExistManageEmail){
                return CustomResponse.noPermission();
            }
            if(boardImageUrl != null){
                boardEntity.setBoardImageUrl(boardImageUrl);
            }
            boardEntity.setBoardWriterNickname(boardWriterNickname);
            boardEntity.setBoardWriterEmail(boardModifyEmail);
            boardEntity.setBoardTitle(boardTitle);
            boardEntity.setBoardContent(boardContent);
            

            boardRepository.save(boardEntity);
        } catch(Exception exception){
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.successs();
    }

    @Override //게시물 삭제
    public ResponseEntity<ResponseDto> deleteBoard(String email, Integer boardNumber) {
            
        // TODO : 존재하지 않는 게시물 번호 반환 boardNumber가 필요함
        BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
        if(boardEntity == null){
            return CustomResponse.notExistBoardNumber();
        }
        // TODO : 관리자 목록에 존재하지 이메일 (존재하는 매니저의 이메일 이필요함)
        Boolean isExistManageEmail = managerRepository.existsByManagerEmail(email);
        if (!isExistManageEmail){
            return CustomResponse.noPermission();
        }
        boardRepository.delete(boardEntity);
        return CustomResponse.successs();
    }
}
