package com.groupd.bodymanager.service;

import org.springframework.http.ResponseEntity;

import com.groupd.bodymanager.dto.response.equipment.GetEquipmentListResponseDto;
import com.groupd.bodymanager.dto.response.equipment.GetEquipmentResponseDto;

public interface EquipmentService {
    public ResponseEntity<? super GetEquipmentResponseDto> getEquipment(Integer equipmentNumber);
    public ResponseEntity<? super GetEquipmentListResponseDto> getEquipmentList();
}
