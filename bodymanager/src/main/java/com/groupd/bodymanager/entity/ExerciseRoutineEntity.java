package com.groupd.bodymanager.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Exersicse")
@Table(name = "Exersicse")
public class ExerciseRoutineEntity {
    
    @Id
    private int routineNumber;
    private String routineImageUrl;
    
}
