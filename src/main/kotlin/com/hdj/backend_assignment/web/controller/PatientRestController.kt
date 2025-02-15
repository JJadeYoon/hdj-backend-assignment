package com.hdj.backend_assignment.web.controller

import com.hdj.backend_assignment.apiPayload.ApiResponse
import com.hdj.backend_assignment.converter.PatientConverter
import com.hdj.backend_assignment.service.PatientService
import com.hdj.backend_assignment.web.dto.PatientRequestDTO
import com.hdj.backend_assignment.web.dto.PatientResponseDTO
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/patients")
class PatientRestController(private val patientService: PatientService) {

    @PostMapping
    fun registerPatient(
        @RequestBody request: PatientRequestDTO.RegisterDTO
    ): ApiResponse<PatientResponseDTO.RegisterResultDTO> {

        return ApiResponse.ok(patientService.registerPatient(request))
    }

    @GetMapping("/{patientId}")
    fun getPatient(
        @PathVariable("patientId") patientId: Long
    ): ApiResponse<PatientResponseDTO.GetResultDTO> {

        return ApiResponse.ok(patientService.getPatient(patientId))
    }

    @PatchMapping("/{patientId}")
    fun updatePatient(
        @PathVariable patientId: Long,
        @RequestBody request: PatientRequestDTO.UpdateDTO
    ): ApiResponse<PatientResponseDTO.GetResultDTO> {

        return ApiResponse.ok(patientService.updatePatient(patientId, request))
    }
}
