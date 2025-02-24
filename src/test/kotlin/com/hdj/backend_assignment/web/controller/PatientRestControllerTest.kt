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
import org.springframework.restdocs.request.RequestDocumentation.*
import org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath
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
    private lateinit var savedPatients: List<Patient>

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

        savedPatients = patientRepository.saveAll(
            listOf(
                Patient(
                    hospital = savedHospital,
                    patientName = "김환자",
                    registrationNumber = "123456-1234567",
                    sexCode = SexCode.MALE,
                    birthDate = "1990-01-01",
                    phoneNumber = "010-1234-5678"
                ),
                Patient(
                    hospital = savedHospital,
                    patientName = "이환자",
                    registrationNumber = "123456-2345678",
                    sexCode = SexCode.FEMALE,
                    birthDate = "1992-02-02",
                    phoneNumber = "010-2345-6789"
                ),
                Patient(
                    hospital = savedHospital,
                    patientName = "박환자",
                    registrationNumber = "123456-3456789",
                    sexCode = SexCode.MALE,
                    birthDate = "1995-03-03",
                    phoneNumber = "010-3456-7890"
                ),
                Patient(
                    hospital = savedHospital,
                    patientName = "김환자",
                    registrationNumber = "123456-4567890",
                    sexCode = SexCode.FEMALE,
                    birthDate = "1998-04-04",
                    phoneNumber = "010-4567-8901"
                )
            )
        )
    }

    @Test
    fun `환자 조회`() {
        // given
        val patientId = savedPatients.first().id

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

    @Test
    fun `환자 검색`() {
        // when & then
        mockMvc.perform(
            get("/patients")
                .param("pageNo", "1")
                .param("pageSize", "10")
                .param("patientName", "김환자")
                .param("registrationNumber", "123456-1234567")
                .param("birthDate", "1990-01-01")
                .contentType("application/json")
        )
            .andExpect(status().isOk)
            .andDo(
                document(
                    "patient/patient-search",
                    queryParameters(
                        parameterWithName("pageNo").description("페이지 번호").optional(),
                        parameterWithName("pageSize").description("페이지 크기").optional(),
                        parameterWithName("patientName").description("환자 이름").optional(),
                        parameterWithName("registrationNumber").description("등록 번호").optional(),
                        parameterWithName("birthDate").description("생년월일").optional()
                    ),
                    responseFields(
                        fieldWithPath("isSuccess").description("성공 여부"),
                        fieldWithPath("code").description("응답 코드"),
                        fieldWithPath("message").description("응답 메시지"),
                        fieldWithPath("result.patientList[]").description("환자 목록"),
                        fieldWithPath("result.patientList[].patientId").description("환자 ID"),
                        fieldWithPath("result.patientList[].hospitalId").description("병원 ID"),
                        fieldWithPath("result.patientList[].patientName").description("환자 이름"),
                        fieldWithPath("result.patientList[].registrationNumber").description("환자 등록 번호"),
                        fieldWithPath("result.patientList[].sexCode").description("환자 성별"),
                        fieldWithPath("result.patientList[].birthDate").description("환자 생년월일"),
                        fieldWithPath("result.patientList[].phoneNumber").description("환자 전화번호"),
                        fieldWithPath("result.totalElements").description("전체 결과 수"),
                        fieldWithPath("result.totalPages").description("전체 페이지 수"),
                        fieldWithPath("result.currentPage").description("현재 페이지 번호"),
                        fieldWithPath("result.pageSize").description("페이지 크기")
                    )
                )
            )

        // 다양한 검색 조건 테스트
        mockMvc.perform(
            get("/patients")
                .param("patientName", "김환자")
                .contentType("application/json")
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.result.patientList[0].patientName").value("김환자"))

        // 페이징 테스트
        mockMvc.perform(
            get("/patients")
                .param("pageSize", "2")
                .contentType("application/json")
        )
            .andExpect(status().isOk)
            .andExpect(jsonPath("$.result.patientList.length()").value(2))
    }
}