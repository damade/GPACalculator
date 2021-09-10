package com.ou.gpa_calculator.BaseView.AdviseScreen

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.ou.gpa_calculator.LocalData.Model.SessionInfo
import com.ou.gpa_calculator.R
import com.ou.gpa_calculator.Util.SharedViewModel
import com.ou.gpa_calculator.Util.getAdvice
import com.ou.gpa_calculator.Util.getCgpa
import com.ou.gpa_calculator.Util.roundTo
import kotlinx.android.synthetic.main.fragment_advice.*
import kotlinx.android.synthetic.main.fragment_calculate.*
import kotlinx.android.synthetic.main.fragment_result.*
import kotlinx.android.synthetic.main.fragment_result.okay_button

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [AdviceFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class AdviceFragment : Fragment() {

    private val sharedViewModel: SharedViewModel by activityViewModels()

    private var gpa = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        gpa = arguments?.getString("gpa").toString()

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_advice, container, false)
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
         * @return A new instance of fragment AdviceFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance() =
            AdviceFragment()
    }

    private fun setupObserver() {
        sharedViewModel.sessionInfoToObserve.observe(viewLifecycleOwner) { sessionInfo ->
            if(sessionInfo != null){
                renderInfo(sessionInfo)
            }
        }
    }

    private fun renderInfo(sessionInfo: SessionInfo) {
        advise_text.text = sessionInfo.getAdvice()
    }

    private fun setupUI() {

        val score = gpa.toDoubleOrNull()

        /*if (score != null) {
            when (score) {
                in 4.5..5.0 -> advise_text.text = "You are right on track"
                in 3.50..4.49 -> {
                    val diff = 4.50 - score;
                    advise_text.text = "You are ${diff.roundTo(2)} away from being a First Class Student," +
                            " having at least a First Class GPA moving forward would boost your CGPA"
                }
                in 2.40..3.49 ->{
                    val diff = 3.50 - score;
                    advise_text.text = "You are ${diff.roundTo(2)} away from being a Second Class Upper Student," +
                            " having at least a First Class GPA moving forward would boost your CGPA"
                }
                in 1.50..2.39 -> {
                    val diff = 2.40 - score;
                    advise_text.text = "You are ${diff.roundTo(2)} away from being a Second Class Lower Student," +
                            " having at least a First Class GPA moving forward would boost your CGPA"
                }
                in 1.00..1.49 -> {
                    val diff = 4.50 - score;
                    advise_text.text = "You are ${diff.roundTo(2)} away from being a Third Class Student," +
                            " having at least a First Class GPA moving forward would boost your CGPA"
                }
                else -> advise_text.text = "You are very far from any good grade, you really need to consider your options"
            }
        }*/

        //Navigation To Home Screen
        okay_button.setOnClickListener { v ->
            sharedViewModel.clearSessionInfo()
            Navigation.findNavController(v).navigate(R.id.action_adviceFragment_to_homeFragment)
        }


    }
}