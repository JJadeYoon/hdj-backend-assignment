package com.hdj.backend_assignment.global.enums

enum class SexCode(val code: String, val description: String) {
    MALE("M", "남"),
    FEMALE("F", "여"),
    UNKNOWN("U", "모름");

    companion object {
        fun from(code: String): SexCode {
            return valueOf(code.uppercase())
        }
    }
}

enum class TreatmentSubjectCode(val code: String, val description: String) {
    INTERNAL_MEDICINE("01", "내과"),
    OPHTHALMOLOGY("02", "안과"),
}

enum class TreatmentTypeCode(val code: String, val description: String) {
    MEDICINE("D", "약처방"),
    EXAMINATION("T", "검사");
}

enum class VisitStatusCode(val code: String, val description: String) {
    VISIT("1", "방문중"),
    ABSENCE("2", "종료"),
    LATE("3", "취소");
}