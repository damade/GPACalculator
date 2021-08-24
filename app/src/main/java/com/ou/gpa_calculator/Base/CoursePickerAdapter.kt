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
import kotlinx.android.synthetic.main.each_course_form.view.*


class CoursePickerAdapter(
    private val course: String,
    private val courseInfo: ArrayList<CourseInfo>
) : RecyclerView.Adapter<CoursePickerAdapter.DataViewHolder>(), OnItemClickListener {

    lateinit var listener: OnItemClickListener

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        var year: String = "100"
        var semester: String = "First"
        private var courseEntered = "BCH"
        private lateinit var listener: OnItemClickListener
        var yearCheck = false
        var semCheck = false
        private val dataClass = MainDataClass()

        fun bind(course: CourseInfo, courseEntered: String, listener: OnItemClickListener) {
            this.listener = listener
            this.courseEntered = courseEntered

          if(course.isNotEmptyNorNull()){
            if (course.year != null) {
                itemView.year_spinner.prompt = course.year
            }
            if (course.semester != null) {
                itemView.sem_spinner.prompt = course.semester
            }
            if (course.courseCode != null) {
                itemView.course_spinner.prompt = course.courseCode
            }
            if (course.courseNoOfUnit != 0) {
                itemView.course_unit_text_view.text = course.courseNoOfUnit.toString()
            }
            if (course.year != null) {
                itemView.year_spinner.prompt = course.year
            }
            when (course.grade) {
                0 -> itemView.grade_spinner.prompt = "F"
                1 -> itemView.grade_spinner.prompt = "E"
                2 -> itemView.grade_spinner.prompt = "D"
                3 -> itemView.grade_spinner.prompt = "C"
                4 -> itemView.grade_spinner.prompt = "B"
                5 -> itemView.grade_spinner.prompt = "A"

            }
          }else{
              setUpUI()
              onClicks()
          }
        }

        fun clearUi() {
            itemView.course_title_text_view.text = "Course Course"
            itemView.course_unit_text_view.text = "Course Unit"
            itemView.course_spinner.adapter = null
            itemView.sem_spinner.adapter = null
            itemView.grade_spinner.adapter = null
        }

        fun setUpUI() {
            itemView.context?.let {
                ArrayAdapter(
                    it,
                    android.R.layout.simple_dropdown_item_1line,
                    arrayListOf("Pick Your Level","100", "200", "300", "400")
                ).also { adapter ->
                    adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
                    itemView.year_spinner.adapter = adapter
                    itemView.course_spinner.adapter = null
                    itemView.sem_spinner.adapter = null
                    itemView.grade_spinner.adapter = null
                }
            }


        }


        fun onClicks() {

            itemView.year_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                    (view as TextView).setTextColor(Color.BLACK)
                    view.gravity = Gravity.CENTER
                    if (yearCheck) {
                        val text: String = parent.getItemAtPosition(pos).toString()
                        year = text
                        listener.onYearChange(year, adapterPosition)
                        view.context?.let {
                            ArrayAdapter(
                                it,
                                android.R.layout.simple_dropdown_item_1line,
                                arrayListOf("Pick A Semester","First", "Second")
                            ).also { adapter ->
                                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
                                itemView.sem_spinner.adapter = adapter
                            }
                        }
                    }
                    yearCheck = true
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }

            itemView.sem_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                    (view as TextView).setTextColor(Color.BLACK)
                    view.gravity = Gravity.CENTER
                    if (semCheck) {
                        val text: String = parent.getItemAtPosition(pos).toString()
                        semester = text
                        listener.onSemesterChange(semester, adapterPosition)
                        view.context?.let {
                            ArrayAdapter(
                                it,
                                android.R.layout.simple_spinner_item,
                                fetchInfo()
                            ).also { adapter ->
                                adapter.setDropDownViewResource(android.R.layout.simple_spinner_item)
                                itemView.course_spinner.adapter = adapter
                            }
                        }
                    }
                    semCheck = true
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }

            itemView.course_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                    (view as TextView).setTextColor(Color.BLACK)
                    view.gravity = Gravity.CENTER
                        val data: CourseData = fetchInfo()[pos]
                        listener.onCourseCodeChange(data, adapterPosition)
                        itemView.course_unit_text_view.text = data.courseNoOfUnit.toString()
                        itemView.course_title_text_view.text = data.courseTitle
                        view.context?.let {
                            ArrayAdapter(
                                it,
                                android.R.layout.simple_dropdown_item_1line,
                                arrayListOf("A", "B", "C", "D", "E", "F")
                            ).also { adapter ->
                                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
                                itemView.grade_spinner.adapter = adapter
                            }
                        }
                }

                override fun onNothingSelected(parent: AdapterView<*>?) {
                    TODO("Not yet implemented")
                }

            }

            itemView.grade_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
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

            itemView.delete_form.setOnClickListener {
                if (adapterPosition == 0) {
                    clearUi()
                } else {
                    listener.onItemRemove(adapterPosition, itemView)
                }
            }
        }

        fun fetchInfo(): Array<CourseData> {

            if (year.equals("Pick Your Level") || semester.equals("Pick A Semester")){
                year = "100"
                semester = "First"
            }

            val results = dataClass.getCourseList(courseEntered, year, semester);

            return results.mapNotNull { it }.toTypedArray();
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.each_course_form, parent,
                false
            )
        )

    override fun getItemCount(): Int = courseInfo.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) {
        listener = this
        holder.bind(courseInfo[position], course, listener)
    }

    fun addData(list: CourseInfo) {
        courseInfo.add(list)
        notifyDataSetChanged()
    }

    fun currentData(): List<CourseInfo> {
        courseInfo.removeAll(emptyList())
        return courseInfo
    }

    fun clearData() {
        courseInfo.clear()
        notifyDataSetChanged()
    }


    override fun onItemChange(course: CourseInfo, position: Int, view: View) {
        TODO("Not yet implemented")
    }

    override fun onYearChange(year: String, position: Int) {
        val course = courseInfo[position]
        course.year = year
        courseInfo[position] = course
        //notifyItemChanged(position)

    }

    override fun onSemesterChange(semester: String, position: Int) {
        val course = courseInfo[position]
        course.semester = semester
        courseInfo[position] = course
        //notifyItemChanged(position)
    }

    override fun onCourseCodeChange(courseData: CourseData, position: Int) {
        val course = courseInfo[position]
        course.courseCode = courseData.courseCode
        course.courseNoOfUnit = courseData.courseNoOfUnit
        course.courseTitle = courseData.courseTitle
        courseInfo[position] = course
        //notifyItemChanged(position)
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

interface OnItemClickListener {
    fun onItemChange(course: CourseInfo, position: Int, view: View)
    fun onYearChange(year: String, position: Int)
    fun onSemesterChange(semester: String, position: Int)
    fun onCourseCodeChange(courseData: CourseData, position: Int)
    fun onGradeChange(grade: String, position: Int)
    fun onItemRemove(position: Int, view: View)

}