package com.ou.gpa_calculator.Base

import android.graphics.Color
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ou.gpa_calculator.LocalData.Model.*
import com.ou.gpa_calculator.LocalData.StaticData.MainDataClass
import com.ou.gpa_calculator.R
import com.ou.gpa_calculator.Util.isNotEmptyNorNull
import com.ou.gpa_calculator.Util.prepend
import kotlinx.android.synthetic.main.course_form.view.*
import kotlinx.android.synthetic.main.each_course_form.view.*
import kotlinx.android.synthetic.main.each_course_form.view.delete_form


class CourseSelectorAdapter(
    private val courseInfo: ArrayList<CourseInfo>
) : RecyclerView.Adapter<CourseSelectorAdapter.DataViewHolder>(), OnItemClickListener {

    lateinit var listener: OnItemClickListener

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private lateinit var listener: OnItemClickListener

        fun bind(course: CourseInfo, listener: OnItemClickListener) {
            this.listener = listener

            itemView.cf_code_text_view.text = course.courseCode
            itemView.cf_unit_text_view.text = course.courseNoOfUnit.toString()

            when (course.grade) {
                0 -> itemView.cf_grade_spinner.prompt = "F"
                1 -> itemView.cf_grade_spinner.prompt = "E"
                2 -> itemView.cf_grade_spinner.prompt = "D"
                3 -> itemView.cf_grade_spinner.prompt = "C"
                4 -> itemView.cf_grade_spinner.prompt = "B"
                5 -> itemView.cf_grade_spinner.prompt = "A"

            }

            setUpUI()
            onClicks()
        }


        fun setUpUI() {
            itemView.context?.let {
                ArrayAdapter(
                    it,
                    android.R.layout.simple_dropdown_item_1line,
                    arrayListOf("Choose Grade","A", "B", "C", "D", "E", "F")
                ).also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
                    itemView.cf_grade_spinner.adapter = adapter
                }
            }
        }


        fun onClicks() {

            itemView.cf_grade_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                    (view as TextView).setTextColor(Color.BLACK)
                    view.gravity = Gravity.CENTER
                        val text: String = parent.getItemAtPosition(pos).toString()
                        listener.onGradeChange(text, adapterPosition)
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.course_form, parent,
                false
            )
        )

    override fun getItemCount(): Int = courseInfo.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        listener = this
        holder.bind(courseInfo[position], listener)
    }

    fun currentData(): List<CourseInfo> {
        courseInfo.removeAll(emptyList())
        return courseInfo
    }

    override fun onItemChange(course: CourseInfo, position: Int, view: View) {
        TODO("Not yet implemented")
    }

    override fun onYearChange(year: String, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onSemesterChange(semester: String, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onCourseCodeChange(courseData: CourseData, position: Int) {
        TODO("Not yet implemented")
    }

    override fun onGradeChange(grade: String, position: Int) {
        val course = courseInfo[position]
        when (grade) {
            "A" -> course.grade = 5
            "B" -> course.grade = 4
            "C" -> course.grade = 3
            "D" -> course.grade = 2
            "E" -> course.grade = 1
            "F" -> course.grade = 0
            else -> course.grade = 0
        }
        courseInfo[position] = course
        //notifyItemChanged(position)
    }

    override fun onItemRemove(position: Int, view: View) {
        courseInfo.removeAt(position)
        notifyItemRemoved(position)
        notifyItemRangeChanged(position, courseInfo.size)
    }


}
