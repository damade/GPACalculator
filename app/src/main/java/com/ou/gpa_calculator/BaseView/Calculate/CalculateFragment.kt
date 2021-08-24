package com.ou.gpa_calculator.BaseView.Calculate

import android.graphics.Color
import android.os.Bundle
import android.view.Gravity
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import com.ou.gpa_calculator.Base.CalcSummaryAdapter
import com.ou.gpa_calculator.LocalData.DatabaseBuilder
import com.ou.gpa_calculator.LocalData.DatabaseHelperImpl
import com.ou.gpa_calculator.LocalData.Model.FormDetails
import com.ou.gpa_calculator.LocalData.Model.SemesterInfo
import com.ou.gpa_calculator.LocalData.Model.SessionInfo
import com.ou.gpa_calculator.LocalData.entity.Result
import com.ou.gpa_calculator.R
import com.ou.gpa_calculator.Util.SharedViewModel
import com.ou.gpa_calculator.Util.ViewModelFactory
import com.ou.gpa_calculator.Util.getCgpa
import com.ou.gpa_calculator.Util.getSemesterCount
import kotlinx.android.synthetic.main.bottom_home_layout.*
import kotlinx.android.synthetic.main.course_filller.*
import kotlinx.android.synthetic.main.each_course_form.view.*
import kotlinx.android.synthetic.main.fragment_calculate.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [CalculateFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class CalculateFragment : Fragment() {

    private lateinit var adapter: CalcSummaryAdapter
    private var dept = ""
    private val sharedViewModel: SharedViewModel by activityViewModels()

    private val calculateViewModel: CalculateViewModel by lazy {
        val activity = requireActivity()
        ViewModelProvider(
            activity,
            ViewModelFactory(DatabaseHelperImpl(DatabaseBuilder.getInstance(requireContext())))
        ).get(CalculateViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //dept = arguments?.getString("course").toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_calculate, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupUI()
        setupObserver()
    }

    companion object {

        @JvmStatic
        fun newInstance() =
            CalculateFragment()
    }

    private fun setupObserver() {
        sharedViewModel.semesterInfoToObserve.observe(viewLifecycleOwner) { semesterInfo ->
            if (semesterInfo != null){
                renderList(semesterInfo)
            }
        }
    }

    private fun renderList(list: List<SemesterInfo>) {
        if (list.isEmpty()) {
            calculateHideConstraintNoResult.visibility = View.VISIBLE
            Toast.makeText(requireContext(), "Something Went Wrong!!!", Toast.LENGTH_SHORT).show()
        } else {
            calculateHideConstraintNoResult.visibility = View.GONE
            summaryCgpaRecycler.visibility = View.VISIBLE
            adapter.addData(list)
            adapter.notifyDataSetChanged()
        }


    }

    private fun setupUI() {

        //RecylcerView And Its Adapter
        summaryCgpaRecycler.layoutManager = LinearLayoutManager(requireContext())
        adapter =
            CalcSummaryAdapter(
                arrayListOf()
            )
        summaryCgpaRecycler.addItemDecoration(
            DividerItemDecoration(
                summaryCgpaRecycler.context,
                (summaryCgpaRecycler.layoutManager as LinearLayoutManager).orientation
            )
        )
        summaryCgpaRecycler.adapter = adapter

        //OnClickForCalculation
        done_cgpa_button.setOnClickListener { v ->
            if (adapter.currentData().isEmpty()) {
                Snackbar.make(
                    v, "The List Is Empty, Add A Semester Course.",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                val sessionInfo = SessionInfo(adapter.currentData())
                calculateViewModel.saveResults(Result(sessionInfo.getCgpa(), sessionInfo.getSemesterCount(), Date()))
                sharedViewModel.updateSessionInfo(sessionInfo)
                Navigation.findNavController(v).navigate(R.id.action_calculateFragment_to_resultFragment)
            }
        }

        //FAB ADD FOR Adding New Semester
        add_semester_button.setOnClickListener { v ->
            showBottomSheetDialog()
        }

        //Button To Add A New Semester
        buttonNoResult.setOnClickListener { v ->
            showBottomSheetDialog()
        }
    }

    /*private fun showBottomSheetDialog() {
        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(R.layout.bottom_home_layout)

        bottomSheetDialog.cardViewCalcBch.setOnClickListener {
            val bundle = bundleOf("course" to "BCH")
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_homeFragment_to_addCalculationFragment, bundle) }
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.cardViewCalcComp.setOnClickListener {
            val bundle = bundleOf("course" to "COMP")
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_homeFragment_to_addCalculationFragment, bundle) }
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.cardViewCalcIc.setOnClickListener {
            val bundle = bundleOf("course" to "IC")
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_homeFragment_to_addCalculationFragment, bundle) }
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.cardViewCalcMic.setOnClickListener {
            val bundle = bundleOf("course" to "MIC")
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_homeFragment_to_addCalculationFragment, bundle) }
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.cardViewCalcPe.setOnClickListener {
            val bundle = bundleOf("course" to "PE")
            view?.let { it1 -> Navigation.findNavController(it1).navigate(R.id.action_homeFragment_to_addCalculationFragment, bundle) }
            bottomSheetDialog.dismiss()
        }
        bottomSheetDialog.show()
    }*/

    private fun showBottomSheetDialog() {
        var dept = "BCH"
        var year = "100"
        var semester = "First"

        val bottomSheetDialog = BottomSheetDialog(requireContext())
        bottomSheetDialog.setContentView(R.layout.course_filller)

        bottomSheetDialog.context.let {
            ArrayAdapter(
                it,
                android.R.layout.simple_dropdown_item_1line,
                arrayListOf(
                    "Biochemistry",
                    "Physics With Electronics",
                    "Microbiology",
                    "Computer Science",
                    "Industrial Chemistry"
                )
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
                bottomSheetDialog.pc_dept_spinner.adapter = adapter
            }

            ArrayAdapter(
                it,
                android.R.layout.simple_dropdown_item_1line,
                arrayListOf("100", "200", "300", "400")
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
                bottomSheetDialog.pc_year_spinner.adapter = adapter
            }

            ArrayAdapter(
                it,
                android.R.layout.simple_dropdown_item_1line,
                arrayListOf("First", "Second")
            ).also { adapter ->
                adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
                bottomSheetDialog.pc_sem_spinner.adapter = adapter
            }
        }


        bottomSheetDialog.pc_dept_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                (view as TextView).setTextColor(Color.BLACK)
                view.gravity = Gravity.CENTER
                val text: String = parent.getItemAtPosition(pos).toString()
                when (text) {
                    "Biochemistry" -> dept = "BCH"
                    "Physics With Electronics" -> dept = "PE"
                    "Microbiology" -> dept = "MIC"
                    "Computer Science" -> dept = "COMP"
                    "Industrial Chemistry" -> dept = "IC"
                }
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        bottomSheetDialog.pc_year_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                (view as TextView).setTextColor(Color.BLACK)
                view.gravity = Gravity.CENTER
                val text: String = parent.getItemAtPosition(pos).toString()
                year = text
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        bottomSheetDialog.pc_sem_spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>, view: View, pos: Int, id: Long) {
                (view as TextView).setTextColor(Color.BLACK)
                view.gravity = Gravity.CENTER
                val text: String = parent.getItemAtPosition(pos).toString()
                semester = text
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }
        }

        bottomSheetDialog.pc_done.setOnClickListener {
            sharedViewModel.updateFormDetails(FormDetails(dept, year, semester))
            view?.let { its -> Navigation.findNavController(its).navigate(R.id.action_calculateFragment_to_coursePickerFragment)  }
            bottomSheetDialog.dismiss()
        }


        bottomSheetDialog.show()
    }
}