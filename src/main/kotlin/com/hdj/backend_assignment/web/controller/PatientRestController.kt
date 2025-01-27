package com.hdj.backend_assignment.web.controller

import com.hdj.backend_assignment.apiPayload.ApiResponse
import com.hdj.backend_assignment.service.PatientService
import com.hdj.backend_assignment.web.dto.PatientRequestDTO
import com.hdj.backend_assignment.web.dto.PatientResponseDTO
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/patients")
class PatientRestController(private val patientService: PatientService) {

    @PostMapping("/register")
    fun registerPatient(@RequestBody request: PatientRequestDTO.RegisterDTO): ApiResponse<PatientResponseDTO.RegisterResultDTO> {
        return ApiResponse.ok(patientService.registerPatient(request))
    }
}
