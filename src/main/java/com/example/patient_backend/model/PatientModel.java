package com.example.patient_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="patientDetails")
public class PatientModel {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private String phoneno;
    private String date;
    private String doctorName;

    public PatientModel() {
    }

    public PatientModel(int id, String name, String phoneno, String date, String doctorName) {
        this.id = id;
        this.name = name;
        this.phoneno = phoneno;
        this.date = date;
        this.doctorName = doctorName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneno() {
        return phoneno;
    }

    public void setPhoneno(String phoneno) {
        this.phoneno = phoneno;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
