package com.hdj.backend_assignment.service;

import com.hdj.backend_assignment.web.dto.PatientRequestDTO;
import com.hdj.backend_assignment.web.dto.PatientResponseDTO;
import org.jetbrains.annotations.NotNull;
import org.springframework.stereotype.Service;

@Service
public class PatientService {
    @NotNull
    public PatientResponseDTO.RegisterResultDTO registerPatient(@NotNull PatientRequestDTO.RegisterDTO request) {
        return null;
    }
}
