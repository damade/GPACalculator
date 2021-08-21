package com.ou.gpa_calculator.BaseView.Calculate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.snackbar.Snackbar
import com.ou.gpa_calculator.Base.CalcSummaryAdapter
import com.ou.gpa_calculator.LocalData.DatabaseBuilder
import com.ou.gpa_calculator.LocalData.DatabaseHelperImpl
import com.ou.gpa_calculator.LocalData.Model.SemesterInfo
import com.ou.gpa_calculator.LocalData.Model.SessionInfo
import com.ou.gpa_calculator.LocalData.entity.Result
import com.ou.gpa_calculator.R
import com.ou.gpa_calculator.Util.SharedViewModel
import com.ou.gpa_calculator.Util.ViewModelFactory
import com.ou.gpa_calculator.Util.getCgpa
import com.ou.gpa_calculator.Util.getSemesterCount
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
        ViewModelProvider(activity,
            ViewModelFactory(DatabaseHelperImpl(DatabaseBuilder.getInstance(requireContext())))
        ).get(CalculateViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dept = arguments?.getString("course").toString()
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
            renderList(semesterInfo)
        }
    }

    private fun renderList( list : List<SemesterInfo>){
        if(list.isEmpty()){
            calculateHideConstraintNoResult.visibility = View.VISIBLE
            Toast.makeText(requireContext(), "Something Went Wrong!!!", Toast.LENGTH_SHORT).show()
        }
        else{
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
            if (adapter.currentData().isEmpty()){
                Snackbar.make(v, "The List Is Empty, Add A Semester Course.",
                    Snackbar.LENGTH_LONG).show()
            }
            else{
                val sessionInfo = SessionInfo(adapter.currentData())
                calculateViewModel.saveResults(Result( sessionInfo.getCgpa(), sessionInfo.getSemesterCount(), Date()))
                //val bundle = bundleOf("cgpa" to sessionInfo.getCgpa().toString())
                sharedViewModel.updateSessionInfo(sessionInfo)
                Navigation.findNavController(v).navigate(R.id.action_calculateFragment_to_resultFragment)
            }
        }

        //Button To Add A New Semester
        calculateHideConstraintNoResult.setOnClickListener { v ->
            val bundle = bundleOf("course" to dept)
            Navigation.findNavController(v).navigate(R.id.action_calculateFragment_to_coursePickerFragment, bundle)
        }

        //FAB ADD FOR Adding New Semester
        add_semester_button.setOnClickListener { v ->
            val bundle = bundleOf("course" to dept)
            Navigation.findNavController(v).navigate(R.id.action_calculateFragment_to_coursePickerFragment, bundle)
        }

    }
}