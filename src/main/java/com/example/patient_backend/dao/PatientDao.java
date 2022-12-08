package com.example.patient_backend.dao;

import com.example.patient_backend.model.PatientModel;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientDao extends CrudRepository<PatientModel,Integer> {
   @Modifying
   @Transactional
    @Query(value="DELETE FROM `patient_details` WHERE `name`= :name",nativeQuery = true)
    void deletePatient(@Param("name") String name);


   @Query(value = "SELECT `id`, `date`, `doctor_name`, `name`, `phoneno` FROM `patient_details` WHERE `name`= :name",nativeQuery = true)
   List<PatientModel> searchPatient(@Param("name")  String name);
}
