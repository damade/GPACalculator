package com.ou.gpa_calculator.BaseView.Result

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.ou.gpa_calculator.LocalData.Model.*
import com.ou.gpa_calculator.R
import com.ou.gpa_calculator.Util.*
import kotlinx.android.synthetic.main.fragment_calculate.*
import kotlinx.android.synthetic.main.fragment_result.*
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ResultFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ResultFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        setupObserver()

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ResultFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            ResultFragment()
    }

    private fun setupObserver() {
        sharedViewModel.sessionInfoToObserve.observe(viewLifecycleOwner) { sessionInfo ->
            renderInfo(sessionInfo)
        }
    }

    private fun renderInfo(sessionInfo: SessionInfo) {
        val summary = sessionInfo.getSummary()
        result_total_units.text = summary[1].toString()
        result_points_earned.text = summary[0].toString()
        result_total_semester.text = sessionInfo.getSemesterCount().toString()
        check_gp.text = (if (sessionInfo.getSemesterCount() > 1) {
            "Your CGPA is"
        } else {
            "Your GPA is"
        }).toString()
        results_gpa_text.text = sessionInfo.getCgpa().roundTo(2).toString()
        when (sessionInfo.getCgpa()) {
            in 4.5..5.0 -> result_new_grade.text = "First Class Honours"
            in 3.50..4.49 -> result_new_grade.text = "Second Class Honours (Upper Division)"
            in 2.40..3.49 -> result_new_grade.text = "Second Class Honours (Lower Division)"
            in 1.50..2.39 -> result_new_grade.text = "Third Class Honours"
            in 1.00..1.49 -> result_new_grade.text = "Pass"
            else -> result_new_grade.text = "Wrong Information"
        }

    }

    private fun setupUI() {

        //Navigation To Home Screen
        okay_button.setOnClickListener { v ->
            sharedViewModel.clearSemesterInfo()
            sharedViewModel.clearSessionInfo()
            Navigation.findNavController(v).navigate(R.id.action_viewReportFragment_to_homeFragment)
        }

    }
}