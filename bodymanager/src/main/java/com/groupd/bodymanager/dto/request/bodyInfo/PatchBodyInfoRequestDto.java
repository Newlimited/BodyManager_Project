package com.groupd.bodymanager.dto.request.bodyInfo;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatchBodyInfoRequestDto {
    @NotNull
    private Integer userCode;
    @NotNull
    private Double height;
    @NotNull
    private Double weight;
    @NotNull
    private Double muscleMass;
    @NotNull
    private Double fatRate;

}
