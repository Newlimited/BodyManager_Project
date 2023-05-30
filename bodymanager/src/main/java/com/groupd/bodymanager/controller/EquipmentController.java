package com.groupd.bodymanager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.groupd.bodymanager.dto.response.equipment.GetEquipmentListResponseDto;
import com.groupd.bodymanager.dto.response.equipment.GetEquipmentResponseDto;
import com.groupd.bodymanager.service.EquipmentService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/equipment")
@RequiredArgsConstructor
public class EquipmentController {
    
    private final EquipmentService equipmentService;

    @GetMapping("/{equipmentNumber}")
    public ResponseEntity<? super GetEquipmentResponseDto> getEquipment(
            @PathVariable("equipmentNumber") Integer equipmentNumber) {
        ResponseEntity<? super GetEquipmentResponseDto> response = equipmentService.getEquipment(equipmentNumber);
        return response;
    }

    @GetMapping("/list")
    public ResponseEntity<? super GetEquipmentListResponseDto> getEquipment() {
        ResponseEntity<? super GetEquipmentListResponseDto> response = equipmentService.getEquipmentList();
        return response;
    }
}
