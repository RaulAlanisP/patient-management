package com.example.patientservice.service;

import com.example.patientservice.dto.PatientRequestDto;
import com.example.patientservice.dto.PatientResponseDto;

import java.util.List;
import java.util.UUID;

public interface IPatientService {

    List<PatientResponseDto> getPatients();

    PatientResponseDto createPatient(PatientRequestDto patientRequestDto);

    PatientResponseDto updatePatient(UUID id, PatientRequestDto patientRequestDto);
}
