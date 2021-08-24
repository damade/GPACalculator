package com.ou.gpa_calculator.Util

import com.ou.gpa_calculator.LocalData.Model.CourseInfo
import com.ou.gpa_calculator.LocalData.Model.RawCourseData
import com.ou.gpa_calculator.LocalData.Model.SemesterInfo
import com.ou.gpa_calculator.LocalData.Model.SessionInfo
import java.math.BigDecimal
import java.math.RoundingMode
import java.util.ArrayList
import kotlin.math.pow
import kotlin.math.roundToInt

    fun RawCourseData.toCourseInfo(): ArrayList<CourseInfo>{
        var initData = ArrayList<CourseInfo>()
        for (datum in data){
            val courseInfo = CourseInfo(formDetails.year,formDetails.semester,datum.courseCode,
                                        datum.courseTitle,datum.courseNoOfUnit,0)
            initData.add(courseInfo)
        }
        return initData
    }

    fun SessionInfo.getCgpa(): Double{
        var unitCount = 0.0
        var gradePoint = 0.0

        for (semester in semesters){
            unitCount += semester.totalUnits()
            gradePoint += semester.getGP()
        }

        return (gradePoint/unitCount)
    }

    fun SessionInfo.getSummary(): Array<Int>{
        var unitCount = 0
        var gradePoint = 0

        for (semester in semesters){
            unitCount += semester.totalUnits()
            gradePoint += semester.getGP()
        }

        return arrayOf(gradePoint,unitCount)
    }

    fun SessionInfo.getSemesterCount(): Int{

        return semesters.size
    }



    fun SemesterInfo.getCourseCount(): Int{
        return courses.size
    }

    fun SemesterInfo.totalUnits(): Int{
        var count = 0
        for (course in courses){
            count += course.courseNoOfUnit
        }
        return count
    }

    fun SemesterInfo.getGP(): Int{
        var gp = 0
        for (course in courses){
            gp += (course.courseNoOfUnit * course.grade)
        }
        return gp
    }

    fun CourseInfo.isNotEmptyNorNull(): Boolean{
        if(year.isNullOrEmpty() || semester.isNullOrEmpty() || courseCode.isNullOrEmpty()
            || courseTitle.isNullOrEmpty() || courseNoOfUnit == -1 || grade == -1){
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
