package com.example.patientservice.mapper;

import com.example.patientservice.dto.PatientRequestDto;
import com.example.patientservice.dto.PatientResponseDto;
import com.example.patientservice.model.Patient;

import java.time.LocalDate;

public class PatientMapper {

    public static PatientResponseDto toDto(Patient patient) {

        return new PatientResponseDto(
            patient.getId().toString(),
            patient.getName(),
            patient.getEmail(),
            patient.getAddress(),
            patient.getDateOfBirth().toString()
        );
    }

    public static Patient toEntity(PatientRequestDto patientRequestDto) {
        Patient patient = new Patient();

        patient.setName(patientRequestDto.name());
        patient.setEmail(patientRequestDto.email());
        patient.setAddress(patientRequestDto.address());
        patient.setDateOfBirth(LocalDate.parse(patientRequestDto.dateOfBirth()));
        patient.setRegisteredDate(LocalDate.parse(patientRequestDto.registeredDate()));

        return patient;
    }
}
