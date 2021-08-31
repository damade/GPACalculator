package com.ou.gpa_calculator.BaseView.Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.flowWithLifecycle
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.ou.gpa_calculator.LocalData.DatabaseBuilder
import com.ou.gpa_calculator.LocalData.DatabaseHelperImpl
import com.ou.gpa_calculator.LocalData.entity.User
import com.ou.gpa_calculator.R
import com.ou.gpa_calculator.Util.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_lecturer_login.*
import kotlinx.android.synthetic.main.fragment_student_login.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach


class StaffLoginFragment: Fragment() {

    private val loginViewModel: LoginViewModel by lazy {
        val activity = requireActivity()
        ViewModelProvider(
            activity,
            ViewModelFactory(DatabaseHelperImpl(DatabaseBuilder.getInstance(requireContext())))
        ).get(LoginViewModel::class.java)
    }



    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_lecturer_login, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        setupObserver()
    }


    companion object {

        @JvmStatic
        fun newInstance() =
            StaffLoginFragment()
    }

    private fun setupObserver() {
        loginViewModel.staffQueryResults.observe(viewLifecycleOwner){ userInfo ->
            handleQueryResult(userInfo)
        }
    }

    private fun handleQueryResult(userInfo : User?){
        if (userInfo != null){
            view?.let { Navigation.findNavController(it).navigate(R.id.action_lecturerLoginFragment_to_homeFragment) }
        }
        else{
            view?.let { Snackbar.make(it,"Incorrect Staff Name or Password", Snackbar.LENGTH_SHORT).show() }
        }
    }


    private fun setupUI() {

//        //OnClickForCalculation
        lecturerLoginIn.setOnClickListener {
            val fullName = lecturerLoginName.text.toString()
            val password = lecturerLoginPassword.text.toString()

            if(fullName.isNullOrEmpty() || password.isNullOrEmpty()){
                Snackbar.make(
                    it, "Empty Staff Name or Password Field",
                    Snackbar.LENGTH_LONG
                ).show()
            }
            else {
                loginViewModel.queryIfStaffExist("%$fullName%", password, "%Lecturer%")
            }
        }

        //Go to lecturer Signin screen.
        goToStudentSignIn.setOnClickListener { v ->
            Navigation.findNavController(v).navigate(R.id.action_lecturerLoginFragment_to_studentLoginFragment)
        }

        lecturerRegisterBtn.setOnClickListener{ v ->
            Navigation.findNavController(v).navigate(R.id.action_lecturerLoginFragment_to_lecturerRegisterFragment)
        }

    }
}