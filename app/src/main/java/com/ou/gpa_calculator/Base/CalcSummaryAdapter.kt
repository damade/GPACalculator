package com.ou.gpa_calculator.Base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ou.gpa_calculator.LocalData.*
import com.ou.gpa_calculator.LocalData.Model.SemesterInfo
import com.ou.gpa_calculator.R
import com.ou.gpa_calculator.Util.*
import kotlinx.android.synthetic.main.calc_summary_layout.view.*
import kotlinx.android.synthetic.main.result_item_layout.view.*

class CalcSummaryAdapter(
    private val semesterInfo: ArrayList<SemesterInfo>
) : RecyclerView.Adapter<CalcSummaryAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(semester: SemesterInfo) {
            val j = adapterPosition + 1 % 10
            val k = adapterPosition + 1 % 100
            if (j == 1 && k != 11) {
                itemView.semesterCount.text = "${adapterPosition + 1}st Semester "
            } else if (j == 2 && k != 12) {
                itemView.semesterCount.text = "${adapterPosition + 1}nd Semester "
            } else if (j == 3 && k != 13) {
                itemView.semesterCount.text = "${adapterPosition + 1}rd Semester "
            } else {
                itemView.semesterCount.text = "${adapterPosition + 1}th Semester "
            }
            itemView.course_summary_count.text = "${semester.getCourseCount()} Course(s)"
            itemView.unit_summary_count.text = "${semester.totalUnits()} Units(s)"
        }
    }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
            DataViewHolder(
                LayoutInflater.from(parent.context).inflate(
                    R.layout.calc_summary_layout, parent,
                    false
                )
            )

        override fun getItemCount(): Int = semesterInfo.size

        override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
            holder.bind(semesterInfo[position])

        fun addData(list: List<SemesterInfo>) {
            semesterInfo.addAll(list)
        }

        fun currentData(): List<SemesterInfo> {
            return semesterInfo
        }

    }