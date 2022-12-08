package com.example.patient_backend.controller;

import com.example.patient_backend.dao.PatientDao;
import com.example.patient_backend.model.PatientModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class PatientController {
    @Autowired
    private PatientDao dao;
    @CrossOrigin(origins = "*")
    @GetMapping("/")
    public String homePage(){
        return "welcome to patient home page";
    }
    @CrossOrigin(origins="*")
    @PostMapping(path="/addpatient",consumes = "application/json",produces = "application/json")
    public String patientAdd(@RequestBody PatientModel p){
        dao.save(p);
        return "patient added successfully";
    }
    @CrossOrigin(origins="*")
    @GetMapping("/viewpatient")
    public List<PatientModel> viewPatient(){
        return (List<PatientModel>) dao.findAll();
    }
    @CrossOrigin(origins = "*")
    @PostMapping(path = "/delete",consumes = "application/json",produces = "application/json")
    public HashMap<String,String> DeletePatient(@RequestBody PatientModel p) {
        String id=String.valueOf(p.getId());
        System.out.println(id);
        dao.deletePatient(p.getName());
        HashMap<String,String> map = new HashMap<>();
        map.put("status","success");
        return map;

    }

    @CrossOrigin(origins = "*")
    @PostMapping(path = "/search",consumes ="application/json",produces = "application/json")
    public List<PatientModel> searchPatient(@RequestBody  PatientModel p) {
        String name = p.getName().toString();
        System.out.println(name);
        return (List<PatientModel>) dao.searchPatient(p.getName());
    }

}
