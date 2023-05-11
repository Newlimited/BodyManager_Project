package com.groupd.bodymanager.dto.request.board;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class PatchBoardRequestDto {
    @Email
    @NotNull
    private String boardWriterEmail;
    @NotNull
    private Integer boardNumber;
    @NotNull
    private String boardTitle;
    @NotBlank
    private String boardContent;
    private String boardImageurl;
}
