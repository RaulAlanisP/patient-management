package com.example.patientservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record PatientRequestDto(
        @NotBlank(message = "Name cannot be blank")
        @Size(max = 100, message = "Name cannot exceed 100 characters")
        String name,

        @NotBlank(message = "Email cannot be blank")
        @Email(message = "Email should be valid")
        String email,

        @NotBlank(message = "Address cannot be blank")
        String address,

        @NotBlank(message = "Date of birth cannot be blank")
        String dateOfBirth,

        @NotBlank(message = "Registered date cannot be blank")
        String registeredDate
) {
}
