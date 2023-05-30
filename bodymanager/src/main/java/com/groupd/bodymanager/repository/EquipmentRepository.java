package com.groupd.bodymanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.groupd.bodymanager.entity.EquipmentEntity;
import com.groupd.bodymanager.entity.resultSet.EquipmentListResultSet;

@Repository
public interface EquipmentRepository extends JpaRepository<EquipmentEntity, String>{
    public EquipmentEntity findByEquipmentNumber(int equipmentNumber);

    @Query(
        value = 
        "SELECT "
        +"E.equipment_number AS EquipmentNumber, "
        +"E.equipment_name AS EquipmentName, "
        +"E.equipment_usage AS EquipmentUsage, "
        +"E.equipment_image_url AS EquipmentImageUrl "
        +"FROM equipment E; ",
        nativeQuery = true  
    )
    public List<EquipmentListResultSet> getEquipmentList();

}
