package com.groupd.bodymanager.dto.request.bodyInfo;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PatchBodyInfoRequestDto {
    @NotBlank
    private String userCode;
    @NotBlank
    private double height;
    @NotBlank
    private double weight;
    @NotBlank
    private double muscleMass;
    @NotBlank
    private double fatRate;

}
