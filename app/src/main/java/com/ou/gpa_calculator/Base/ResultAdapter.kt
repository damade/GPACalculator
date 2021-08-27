package com.ou.gpa_calculator.Base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ou.gpa_calculator.LocalData.entity.Result
import com.ou.gpa_calculator.R
import com.ou.gpa_calculator.Util.roundTo
import kotlinx.android.synthetic.main.result_item_layout.view.*

class ResultAdapter (
    private val results: ArrayList<Result>
) : RecyclerView.Adapter<ResultAdapter.DataViewHolder>() {

    class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(result: Result) {
            itemView.item_cgpa.text = result.cgpa.roundTo(2).toString()
            itemView.item_semester.text = result.semester.toString()
            itemView.item_show.text = (if (result.semester!! > 1) {
                "Your CGPA is"
            } else {
                "Your GPA is"
            }).toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.result_item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = results.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(results[position])

    fun addData(list: List<Result>) {
        results.addAll(list)
    }

    fun clearData() {
        results.clear()
    }

}