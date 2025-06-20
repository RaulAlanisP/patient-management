package com.example.patientservice.service;

import com.example.patientservice.dto.PatientRequestDto;
import com.example.patientservice.dto.PatientResponseDto;
import com.example.patientservice.model.Patient;

import java.util.List;

public interface IPatientService {

    List<PatientResponseDto> getPatients();

    PatientResponseDto createPatient(PatientRequestDto patientRequestDto);
}
