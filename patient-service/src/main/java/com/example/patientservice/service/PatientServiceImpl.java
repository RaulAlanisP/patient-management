package com.example.patientservice.service;

import com.example.patientservice.dto.PatientRequestDto;
import com.example.patientservice.dto.PatientResponseDto;
import com.example.patientservice.exception.EmailAlreadyExistsException;
import com.example.patientservice.mapper.PatientMapper;
import com.example.patientservice.model.Patient;
import com.example.patientservice.repository.PatientRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements IPatientService {

    private final PatientRepository patientRepository;

    public PatientServiceImpl(PatientRepository patientRepository) {
        this.patientRepository = patientRepository;
    }


    @Override
    public List<PatientResponseDto> getPatients() {
        List<Patient> patients = patientRepository.findAll();

        return patients.stream()
                .map(PatientMapper::toDto).toList();
    }

    @Override
    public PatientResponseDto createPatient(PatientRequestDto patientRequestDto) {
        if (patientRepository.existsByEmail(patientRequestDto.email())) {
            throw new EmailAlreadyExistsException("Patient with this email already exists: "
                    + patientRequestDto.email());
        }
        Patient newPatient = patientRepository.save(PatientMapper.toEntity(patientRequestDto));

        return PatientMapper.toDto(newPatient);
    }


}
