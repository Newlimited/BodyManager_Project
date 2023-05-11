package com.groupd.bodymanager.service.implement;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.StreamingHttpOutputMessage.Body;
import org.springframework.stereotype.Service;

import com.groupd.bodymanager.common.CustomResponse;
import com.groupd.bodymanager.dto.request.board.PatchBoardRequestDto;
import com.groupd.bodymanager.dto.request.board.PostBoardRequestDto;
import com.groupd.bodymanager.dto.response.ResponseDto;
import com.groupd.bodymanager.dto.response.board.GetBoardListResponseDto;
import com.groupd.bodymanager.dto.response.board.GetBoardResponseDto;
import com.groupd.bodymanager.entity.BoardEntity;
import com.groupd.bodymanager.entity.UserEntity;
import com.groupd.bodymanager.entity.resultSet.BoardListResultSet;
import com.groupd.bodymanager.repository.BoardRepository;
import com.groupd.bodymanager.repository.UserRepository;
import com.groupd.bodymanager.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImplement implements BoardService {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;

    public ResponseEntity<ResponseDto> postBoard(PostBoardRequestDto dto) {

        // 게시물 작성
        String boardWriterEmail = dto.getBoardWriterEmail();
        // 의논 해야 할 것
        try {
            // TODO 존재하지 않는 유저 오류 반환
            boolean existedUserEmail = userRepository.existsByEmail(boardWriterEmail);
            if (!existedUserEmail) {
                ResponseDto errorbody = new ResponseDto("NU", "Non-Existent User Email");
                return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorbody);
            }
            BoardEntity boardEntity = new BoardEntity(dto);
            boardRepository.save(boardEntity);

        } catch (Exception exception) {
            // TODO : 데이터 베이스 오류반환
            exception.printStackTrace();

            return CustomResponse.databaseError();
        }
        // TODO: 성공반환
        return CustomResponse.successs();
    }

    @Override
    public ResponseEntity<? super GetBoardResponseDto> getBoard(Integer boardNumber) { // 특정게시물 보기
        GetBoardResponseDto body = null;
        try {
            if (boardNumber == null) {
                return CustomResponse.vaildationFaild();
            }
            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            if (boardEntity == null) {
                return CustomResponse.notExistBoardNumber();
            }
            int viewCount = boardEntity.getViewCount();
            boardEntity.setViewCount(++viewCount);
            boardRepository.save(boardEntity);
            String boardWriterEmail = boardEntity.getBoardWriterEmail();
            UserEntity userEntity = userRepository.findByEmail(boardWriterEmail);
            body = new GetBoardResponseDto(boardEntity, userEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return CustomResponse.successs();
    }

    @Override
    public ResponseEntity<? super GetBoardListResponseDto> getBoardList() { // 게시물 목록 보기
        GetBoardListResponseDto body = null;

        try {
            List<BoardListResultSet> resultSet = boardRepository.getList();
            System.out.println(resultSet.size());
            body = new GetBoardListResponseDto(resultSet);

        } catch (Exception exception) {
            exception.printStackTrace();

            return CustomResponse.databaseError();

        }
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @Override
    public ResponseEntity<ResponseDto> patchBoard(String userEmail, PatchBoardRequestDto dto) {
        int boardNumber = dto.getBoardNumber();
        String boardWriterEmail = dto.getBoardWriterEmail();
        String boardTitle = dto.getBoardTitle();
        String boardContetn = dto.getBoardContent();
        String boardImageUrl = dto.getBoardImageurl();

        try{
            BoardEntity boardEntity = boardRepository.findByBoardNumber(boardNumber);
            // TODO : 존재하지 않는 게시물 번호 반환 boardNumber가 필요함
            if(boardEntity == null){
                return CustomResponse.notExistBoardNumber();
            }
            // TODO : 존재하지 않는 매니저 이메일 (존재하는 매니저의 이메일 이필요함)
            Boolean existedUserEmail = userRepository.existsByEmail(userEmail);
            if (!existedUserEmail){
                return CustomResponse.notExistUserEmail();
            }
          


            
        }
    }

    @Override
    public ResponseEntity<ResponseDto> deleteBoard(String userEmail, Integer boardNumber) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteBoard'");
    }

}
