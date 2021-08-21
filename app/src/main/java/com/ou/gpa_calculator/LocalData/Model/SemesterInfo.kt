package com.ou.gpa_calculator.LocalData.Model

data class CourseInfo(
    var year: String?,
    var semester: String?,
    var courseCode: String?,
    var courseTitle: String?,
    var courseNoOfUnit: Int,
    var grade: Int)

data class CourseData(val courseCode: String,
                      val courseTitle: String,
                      val courseNoOfUnit: Int){
    override fun toString(): String = courseCode
}

data class SemesterInfo(val courses: List<CourseInfo>)


data class SessionInfo(val semesters: List<SemesterInfo>)



