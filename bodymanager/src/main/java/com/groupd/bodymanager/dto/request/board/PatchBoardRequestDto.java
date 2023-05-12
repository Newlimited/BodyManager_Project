package com.groupd.bodymanager.dto.request.board;

import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchBoardRequestDto {
  
    @NotBlank
    private Integer boardNumber;
    @NotBlank
    private String boardTitle;
    @NotBlank
    private String boardContent;
    private String boardImageurl;
}
