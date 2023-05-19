package com.groupd.bodymanager.entity.resultSet;

public interface BoardListResultSet {
    
    public int getBoardNumber();
    public String getTitle();
    public String getBoardContent();
    public String getBoardimageUrl();
    public String getBoardWriteDatetime();
    public int getViewCount();
    public String getBoardWriterEmail();
    public String getBoardWriterNickname();
    
}
