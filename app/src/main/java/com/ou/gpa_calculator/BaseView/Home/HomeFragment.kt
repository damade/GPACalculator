package com.ou.gpa_calculator.BaseView.Home


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.ou.gpa_calculator.Base.ResultAdapter
import com.ou.gpa_calculator.LocalData.DatabaseBuilder
import com.ou.gpa_calculator.LocalData.DatabaseHelperImpl
import com.ou.gpa_calculator.LocalData.entity.Result
import com.ou.gpa_calculator.R
import com.ou.gpa_calculator.Util.ViewModelFactory
import kotlinx.android.synthetic.main.bottom_home_layout.*
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private lateinit var adapter: ResultAdapter

    private val homeViewModel: HomeViewModel by lazy {
        val activity = requireActivity()
        ViewModelProvider(activity,
            ViewModelFactory(DatabaseHelperImpl(DatabaseBuilder.getInstance(requireContext()))))
            .get(HomeViewModel::class.java)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()

        setupObserver()

    }

    private fun setupObserver() {
        homeViewModel.results
            .flowWithLifecycle(lifecycle, Lifecycle.State.STARTED)
            .onEach { result -> renderList(result)
            }
            .launchIn(lifecycleScope)
    }

   private fun renderList( list : List<Result>){
       if(list.isEmpty()){
           progressBar.visibility = View.GONE
           recentLayout.visibility = View.GONE
           hideConstraintNoResult.visibility = View.VISIBLE
           Toast.makeText(requireContext(), "Welcome New Student",Toast.LENGTH_SHORT).show()
       }
       else{
           progressBar.visibility = View.GONE
           homeAllResultRecycler.visibility = View.VISIBLE
           adapter.clearData()
           adapter.addData(list)
           adapter.notifyDataSetChanged()
       }
    }

    private fun setupUI() {


        //RecylcerView And Its Adapter
        homeAllResultRecycler.layoutManager = LinearLayoutManager(requireContext())
        adapter =
            ResultAdapter(
                arrayListOf()
            )
        homeAllResultRecycler.addItemDecoration(
            DividerItemDecoration(
                homeAllResultRecycler.context,
                (homeAllResultRecycler.layoutManager as LinearLayoutManager).orientation
            )
        )
        homeAllResultRecycler.adapter = adapter

        //OnClickForNewCalculation
        addCalculation.setOnClickListener { v ->
            showBottomSheetDialog()
        }

        //FAB ADD FOR NEW CALCULATION
        home_add_button.setOnClickListener { v ->
            showBottomSheetDialog()
        }

    }

    private fun showBottomSheetDialog() {
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
    }

    companion object {
        @JvmStatic
        fun newInstance() = HomeFragment()
    }
}