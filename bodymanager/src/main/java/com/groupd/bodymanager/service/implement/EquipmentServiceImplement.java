package com.groupd.bodymanager.service.implement;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.groupd.bodymanager.common.CustomResponse;
import com.groupd.bodymanager.dto.response.equipment.GetEquipmentListResponseDto;
import com.groupd.bodymanager.dto.response.equipment.GetEquipmentResponseDto;
import com.groupd.bodymanager.entity.EquipmentEntity;
import com.groupd.bodymanager.entity.resultSet.EquipmentListResultSet;
import com.groupd.bodymanager.repository.EquipmentRepository;
import com.groupd.bodymanager.service.EquipmentService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImplement implements EquipmentService{
    
    
    private final EquipmentRepository equipmentRepository;

    public ResponseEntity<? super GetEquipmentResponseDto> getEquipment(Integer equipmentNumber) {
        GetEquipmentResponseDto body = null;
        try {
            if (equipmentNumber == null) {
                return CustomResponse.validationFaild();
            }
            EquipmentEntity equipmentEntity = equipmentRepository.findByEquipmentNumber(equipmentNumber);
            if (equipmentEntity == null) {
                return CustomResponse.notExistEquipmnetNumber();
            }
            
            equipmentRepository.save(equipmentEntity);

            body = new GetEquipmentResponseDto(equipmentEntity);

        } catch (Exception exception) {
            exception.printStackTrace();
            return CustomResponse.databaseError();
        }
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }

    @Override
    public ResponseEntity<? super GetEquipmentListResponseDto> getEquipmentList() {
        GetEquipmentListResponseDto body = null;
        try {
        
            List<EquipmentListResultSet> resultSet = equipmentRepository.getEquipmentList();
            body = new GetEquipmentListResponseDto(resultSet);

        } catch (Exception exception) {
            exception.printStackTrace();

            return CustomResponse.databaseError();

        }
        return ResponseEntity.status(HttpStatus.OK).body(body);
    }
    
}
