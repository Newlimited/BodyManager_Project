package com.groupd.bodymanager.dto.request.bodyInfo;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostBodyInfoRequestDto {
    @NotNull
    private int userCode;
    @NotNull
    private double height;
    @NotNull
    private double weight;
    @NotNull
    private double muscleMass;
    @NotNull
    private double fatRate;
    
}
