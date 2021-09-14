package com.ou.gpa_calculator.Util

import com.ou.gpa_calculator.LocalData.Model.CourseInfo
import com.ou.gpa_calculator.LocalData.Model.RawCourseData
import com.ou.gpa_calculator.LocalData.Model.SemesterInfo
import com.ou.gpa_calculator.LocalData.Model.SessionInfo
import kotlinx.android.synthetic.main.fragment_advice.*
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.ArrayList
import kotlin.math.pow
import kotlin.math.roundToInt

fun RawCourseData.toCourseInfo(): ArrayList<CourseInfo> {
    var initData = ArrayList<CourseInfo>()
    for (datum in data) {
        val courseInfo = CourseInfo(
            formDetails.year, formDetails.semester, datum.courseCode,
            datum.courseTitle, datum.courseNoOfUnit, 0
        )
        initData.add(courseInfo)
    }
    return initData
}

fun SessionInfo.getCgpa(): Double {
    var unitCount = 0.0
    var gradePoint = 0.0

    for (semester in semesters) {
        unitCount += semester.totalUnits()
        gradePoint += semester.getGP()
    }

    return (gradePoint / unitCount)
}

fun SessionInfo.getSummary(): Array<Int> {
    var unitCount = 0
    var gradePoint = 0

    for (semester in semesters) {
        unitCount += semester.totalUnits()
        gradePoint += semester.getGP()
    }

    return arrayOf(gradePoint, unitCount)
}

fun SessionInfo.getAdvice(): String {
    var advice = ""
    var unitCount = 0
    var gradePoint = 0

    for (semester in semesters) {
        unitCount += semester.totalUnits()
        gradePoint += semester.getGP()
    }

    when (this.getCgpa()) {
        in 4.5..5.0 -> advice = "You are right on track"
        in 3.50..4.49 -> {
            val rec = ((4.5 * ( this.getSemesterCount() + 1)) - (this.getCgpa() * this.getSemesterCount()))
            advice = if(rec <= 5.0){
                "You need ${rec.roundTo(2)} in your next semester to get to First Class \n " +
                        "To achieve this you need to get more A's especially in your 3 unit courses"
            } else{
                "You will need to make sure you are in between 4.0 to 5.0 GPAs to be able to maintain your First Class \n" +
                        "Make sure you strive to get more A's in your 3 unit courses"
            }
        }
        in 2.40..3.49 ->{
            val rec = ((3.50 * ( this.getSemesterCount() + 1)) - (this.getCgpa() * this.getSemesterCount()))
            advice = if(rec <= 5.0){
                "You need ${rec.roundTo(2)} in your next semester to get to Second Class Upper\n " +
                        "To achieve this you need to get more A's especially in your 3 unit courses"
            } else{
                "You will need to make sure you are in between 3.5 to 4.0 GPAs to be able to maintain your Second Class Upper \n " +
                        "To move up to a First Class, you need to be in between 4.0 to 5.0 \n " +
                        "To achieve this you need to get more A's especially in your 3 unit courses and at least c in your 3 units courses"
            }
        }
        in 1.50..2.39 -> {
            val rec = ((2.40 * ( this.getSemesterCount() + 1)) - (this.getCgpa() * this.getSemesterCount()))
            advice = if(rec <= 5.0){
                "You need ${rec.roundTo(2)} in your next semester to get to Second Class Lower \n " +
                        "To achieve this you need to get more A's especially in your 3 unit courses and at least B or C in your 2 unit courses"
            } else{
                "To move up to Second Class Upper will need to make sure you are in between 3.5 to 4.0 GPAs to be achieve this \\n \" +\n" +
                        "                        \"To achieve this you need to get more A's especially in your 3 unit courses \n " +
                        "\"To move up to a First Class, you need to be in between 4.0 to 5.0 \\n \\"
            }
        }
        in 1.00..1.49 -> {
            val rec = ((1.50 * ( this.getSemesterCount() + 1)) - (this.getCgpa() * this.getSemesterCount()))
            advice = if(rec <= 5.0){
                "You need ${rec.roundTo(2)} in your next semester to get to Third Class \n " +
                        "To achieve this you need to get more A's especially in your 3 unit courses and at least B in your 2 unit courses"
            } else{
                "You will need steady 5.0 GPAs to be able to get to Third Class"
            }
        }
        else -> advice = "You are very far from any good grade, you really need to consider your options"
    }

    return advice
}

fun SessionInfo.getSemesterCount(): Int {

    return semesters.size
}


fun SemesterInfo.getCourseCount(): Int {
    return courses.size
}

fun SemesterInfo.totalUnits(): Int {
    var count = 0
    for (course in courses) {
        count += course.courseNoOfUnit
    }
    return count
}

fun SemesterInfo.getGP(): Int {
    var gp = 0
    for (course in courses) {
        gp += (course.courseNoOfUnit * course.grade)
    }
    return gp
}

fun CourseInfo.isNotEmptyNorNull(): Boolean {
    if (year.isNullOrEmpty() || semester.isNullOrEmpty() || courseCode.isNullOrEmpty()
        || courseTitle.isNullOrEmpty() || courseNoOfUnit == -1 || grade == -1
    ) {
        return false
    }

    return true
}

fun Double.roundTo(numFractionDigits: Int): Double {
    val factor = 10.0.pow(numFractionDigits.toDouble())
    return (this * factor).roundToInt() / factor
}

fun <T> MutableList<T>.prepend(element: T) {
    add(0, element)
}
