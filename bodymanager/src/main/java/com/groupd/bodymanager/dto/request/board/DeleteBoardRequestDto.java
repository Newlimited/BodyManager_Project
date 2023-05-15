package com.groupd.bodymanager.dto.request.board;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class DeleteBoardRequestDto {
    @Id
    @NotBlank
    int boardNumber;
  

}
