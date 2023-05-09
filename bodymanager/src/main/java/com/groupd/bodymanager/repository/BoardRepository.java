package com.groupd.bodymanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.groupd.bodymanager.entity.BoardEntity;
import com.groupd.bodymanager.entity.resultSet.BoardListResultSet;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, String>{
    public BoardEntity findByBoardNumber(int boardNumber); 

    @Query(
        value = 
        "Select "
        + "B.board_number As boardNumber, "
        + "B.board_title As boardTitle, "
        + "B.board_content AS boardContent, "
        + "B.board_image_url As boardImageUrl, "
        + "B.board_write_datetime As boardWriteDatetime, "
        + "U.user_nickname As boardWriterNickname "
        + "U.user_email As boardWriterEmail "
        + "B.view_count As viewCount " 
        + "from board B, user U "
        + "where B.board_writer_nickname = U.user_nickname "
        + "GROUP BY B.board_number "
        + "ORDER BY B.board_write_datetime DESC; ",
         nativeQuery = true  
    )
    public List<BoardListResultSet> getList();
    @Query(
    value = 
    "Select "
    + "B.board_number As boardNumber, "
    + "B.board_title As boardTitle, "
    + "B.board_content AS boardContent, "
    + "B.board_image_url As boardImageUrl, "
    + "B.board_write_datetime As boardWriteDatetime, "
    + "U.user_email As boardWriterNickname "
    + "from board B, user U "
    + "where B.board_writer_nickname = U.user_nickname "
    + "GROUP BY B.board_number "
    + "ORDER BY B.board_write_datetime DESC; "
    + "LIMIT 5",
     nativeQuery = true  
)
public List<BoardListResultSet> getListTop5();
}