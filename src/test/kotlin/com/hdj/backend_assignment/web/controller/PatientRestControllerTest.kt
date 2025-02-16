package com.hdj.backend_assignment.web.controller

import com.hdj.backend_assignment.domain.Hospital
import com.hdj.backend_assignment.domain.Patient
import com.hdj.backend_assignment.global.enums.SexCode
import com.hdj.backend_assignment.repository.HospitalRepository
import com.hdj.backend_assignment.repository.PatientRepository
import jakarta.transaction.Transactional
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.restdocs.AutoConfigureRestDocs
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.restdocs.mockmvc.MockMvcRestDocumentation.document
import org.springframework.test.web.servlet.MockMvc
import org.springframework.restdocs.mockmvc.RestDocumentationRequestBuilders.get
import org.springframework.restdocs.payload.PayloadDocumentation.fieldWithPath
import org.springframework.restdocs.payload.PayloadDocumentation.responseFields
import org.springframework.restdocs.request.RequestDocumentation.parameterWithName
import org.springframework.restdocs.request.RequestDocumentation.pathParameters
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@AutoConfigureRestDocs
@Transactional
class PatientRestControllerTest {

    @Autowired
    private lateinit var mockMvc: MockMvc

    @Autowired
    private lateinit var hospitalRepository: HospitalRepository

    @Autowired
    private lateinit var patientRepository: PatientRepository

    private lateinit var savedHospital: Hospital
    private lateinit var savedPatient: Patient

    @BeforeEach
    fun setUp() {
        savedHospital = hospitalRepository.save(
            Hospital(
                hospitalName = "병원",
                medicalInstitutionNumber = "1234567890",
                hospitalDirectorName = "김병원장"
            )
        )
        println(savedHospital)

        savedPatient = patientRepository.save(
            Patient(
                hospital = savedHospital,
                patientName = "김환자",
                registrationNumber = "123456-1234567",
                sexCode = SexCode.MALE,
                birthDate = "1990-01-01",
                phoneNumber = "010-1234-5678"
            )
        )
    }

    @Test
    fun `환자 조회`() {
        // given
        val patientId = 1L

        // when
        mockMvc.perform(
            get("/patients/{patientId}", patientId)
                .contentType("application/json")
        )
            .andExpect(status().isOk)
            .andDo(
                document(
                    "patient/patient-get", // 문서 조각 디렉토리 명
                    pathParameters( // path 파라미터 정보 입력
                        parameterWithName("patientId").description("환자 ID")
                    ),
                    responseFields( // response 필드 정보 입력
                        fieldWithPath("isSuccess").description("성공 여부"),
                        fieldWithPath("code").description("응답 코드"),
                        fieldWithPath("message").description("응답 메시지"),
                        fieldWithPath("result.patientId").description("환자 ID"),
                        fieldWithPath("result.hospitalId").description("병원 ID"),
                        fieldWithPath("result.patientName").description("환자 이름"),
                        fieldWithPath("result.registrationNumber").description("환자 등록 번호"),
                        fieldWithPath("result.sexCode").description("환자 성별"),
                        fieldWithPath("result.birthDate").description("환자 생년월일"),
                        fieldWithPath("result.phoneNumber").description("환자 전화번호")
                    )
                )
            )

        // then
    }
}