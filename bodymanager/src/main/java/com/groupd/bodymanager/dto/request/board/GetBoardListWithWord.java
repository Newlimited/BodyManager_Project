package com.groupd.bodymanager.dto.request.board;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
public class GetBoardListWithWord {
    @NotNull
    private String words;
}
