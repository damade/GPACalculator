package com.ou.gpa_calculator.BaseView.CoursePicker

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.ou.gpa_calculator.Base.CoursePickerAdapter
import com.ou.gpa_calculator.Base.CourseSelectorAdapter
import com.ou.gpa_calculator.LocalData.Model.CourseInfo
import com.ou.gpa_calculator.LocalData.Model.FormDetails
import com.ou.gpa_calculator.LocalData.Model.RawCourseData
import com.ou.gpa_calculator.LocalData.Model.SemesterInfo
import com.ou.gpa_calculator.LocalData.StaticData.MainDataClass
import com.ou.gpa_calculator.R
import com.ou.gpa_calculator.Util.SharedViewModel
import com.ou.gpa_calculator.Util.toCourseInfo
import kotlinx.android.synthetic.main.fragment_course_picker.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CoursePickerFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CoursePickerFragment : Fragment() {

    private lateinit var adapter: CourseSelectorAdapter
    private var dept = ""

    private val sharedViewModel: SharedViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dept = arguments?.getString("course").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

        return inflater.inflate(R.layout.fragment_course_picker, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        setupObserver()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            CoursePickerFragment()
    }

    private fun setupObserver() {
        sharedViewModel.formDetailsToObserve.observe(viewLifecycleOwner) { formDetails ->
            if (formDetails != null) {
                populateAdapter(formDetails)
            }
        }
    }

    private fun populateAdapter(formDetails: FormDetails) {

        val results = MainDataClass().getCourseList(formDetails.dept, formDetails.year, formDetails.semester)

        val endResult = RawCourseData(results, formDetails)


        //RecylcerView And Its Adapter
        coursePickerRecycler.layoutManager = LinearLayoutManager(requireContext())
        adapter =
            CourseSelectorAdapter(
                endResult.toCourseInfo()
            )
        coursePickerRecycler.addItemDecoration(
            DividerItemDecoration(
                coursePickerRecycler.context,
                (coursePickerRecycler.layoutManager as LinearLayoutManager).orientation
            )
        )
        coursePickerRecycler.adapter = adapter
    }

    private fun setupUI() {

        //OnClickForCalculation
        select_back_arrow.setOnClickListener { v ->
            Navigation.findNavController(v).popBackStack()
        }

        //FAB ADD FOR Adding New Semester
        done_course_picker_button.setOnClickListener { v ->
            if (adapter.currentData().isEmpty()) {
                Snackbar.make(v, "No Course Yet", Snackbar.LENGTH_LONG).show()
                Navigation.findNavController(v).popBackStack()
            } else {
                val semesterInfo = SemesterInfo(adapter.currentData())
                sharedViewModel.updateSemesterInfo(semesterInfo)
                Navigation.findNavController(v).popBackStack()
            }
        }

        /*add_course_picker_button.setOnClickListener {
            adapter.addData(CourseInfo(null,null,null,null,-1,-1))
        }*/

    }

    override fun onDestroyView() {
        super.onDestroyView()
        sharedViewModel.clearFormDetails()
    }
}