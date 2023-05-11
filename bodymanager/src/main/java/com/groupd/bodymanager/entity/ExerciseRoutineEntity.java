package com.groupd.bodymanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Exercise")
@Table(name = "ExerciseRoutine")
public class ExerciseRoutineEntity {
    
    @Id
    private int routineNumber;
    @NotBlank
    private String routineImageUrl1;
    @NotBlank
    private String routineImageUrl2;
    @NotBlank
    private String routineImageUrl3;

    
}
