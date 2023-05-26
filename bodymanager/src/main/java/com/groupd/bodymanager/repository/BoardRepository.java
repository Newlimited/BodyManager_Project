package com.groupd.bodymanager.repository;

import java.util.List;

import org.hibernate.query.NativeQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.groupd.bodymanager.entity.BoardEntity;
import com.groupd.bodymanager.entity.resultSet.BoardListResultSet;

@Repository
public interface BoardRepository extends JpaRepository<BoardEntity, String>{
    public BoardEntity findByBoardNumber(int boardNumber); 

    @Query(
        value = 
        "SELECT " +
        "* FROM board_view; ",
        nativeQuery = true  
    )
    public List<BoardListResultSet> getList();

    public List<BoardEntity> findByBoardWriterEmail(String email);

    @Query(
    value = "SELECT * FROM board WHERE UPPER(board_title) "
    +"LIKE UPPER(:words) OR UPPER(board_content) LIKE UPPER(:words); ",
    nativeQuery = true
    )
    public List<BoardEntity> getSearchWord(@Param("words") String words);

}
