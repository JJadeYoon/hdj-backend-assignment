package com.hdj.backend_assignment.web.controller

import com.hdj.backend_assignment.apiPayload.ApiResponse
import com.hdj.backend_assignment.service.PatientService
import com.hdj.backend_assignment.web.dto.PatientRequestDTO.*
import com.hdj.backend_assignment.web.dto.PatientResponseDTO.*
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.ModelAttribute
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/patients")
class PatientRestController(private val patientService: PatientService) {

    @PostMapping
    fun registerPatient(
        @RequestBody request: RegisterDTO
    ): ApiResponse<RegisterResultDTO> {

        return ApiResponse.ok(patientService.registerPatient(request))
    }

    @GetMapping("/{patientId}")
    fun getPatient(
        @PathVariable("patientId") patientId: Long
    ): ApiResponse<GetResultDTO> {

        return ApiResponse.ok(patientService.getPatient(patientId))
    }

    @PatchMapping("/{patientId}")
    fun updatePatient(
        @PathVariable patientId: Long,
        @RequestBody request: UpdateDTO
    ): ApiResponse<GetResultDTO> {

        return ApiResponse.ok(patientService.updatePatient(patientId, request))
    }

    @DeleteMapping("/{patientId}")
    fun deletePatient(
        @PathVariable patientId: Long
    ): ApiResponse<Unit> {

        return ApiResponse.ok(patientService.deletePatient(patientId))
    }

    @GetMapping
    fun searchPatient(
        @ModelAttribute request: SearchDTO
    ): ApiResponse<PageResponse<GetResultDTO>> {

        return ApiResponse.ok(patientService.searchPatient(request))
    }
}
