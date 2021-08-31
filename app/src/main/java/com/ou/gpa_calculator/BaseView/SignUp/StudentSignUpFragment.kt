package com.ou.gpa_calculator.BaseView.SignUp

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
import com.ou.gpa_calculator.BaseView.Login.LoginViewModel
import com.ou.gpa_calculator.BaseView.Login.StudentLoginFragment
import com.ou.gpa_calculator.LocalData.DatabaseBuilder
import com.ou.gpa_calculator.LocalData.DatabaseHelperImpl
import com.ou.gpa_calculator.LocalData.entity.User
import com.ou.gpa_calculator.R
import com.ou.gpa_calculator.Util.ViewModelFactory
import kotlinx.android.synthetic.main.fragment_student_sign_up.*
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import java.util.*

class StudentSignUpFragment : Fragment() {

    private val loginViewModel: LoginViewModel by lazy {
        val activity = requireActivity()
        ViewModelProvider(
            activity,
            ViewModelFactory(DatabaseHelperImpl(DatabaseBuilder.getInstance(requireContext())))
        ).get(LoginViewModel::class.java)
   }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_student_sign_up, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupUI()
        setupObserver()

    }

    private fun setupObserver() {
        loginViewModel.savedUser.observe(viewLifecycleOwner){ isSaved ->
           handleQueryResult(isSaved)
        }
    }

    private fun handleQueryResult(isSaved : Long){
        if(isSaved.toInt() >= 1){
            view?.let {
                Snackbar.make(
                    it, "Account Created Successfully",
                    Snackbar.LENGTH_LONG
                ).show()
            }
            view?.let { Navigation.findNavController(it).navigate(R.id.action_studentSignUpFragment_to_studentLoginFragment) }
        }
        else{
            view?.let {
                Snackbar.make(
                    it, "Something went wrong, Try Again later.",
                    Snackbar.LENGTH_LONG
                ).show()
            }
        }

    }


    companion object {

        @JvmStatic
        fun newInstance() =
            StudentSignUpFragment()
    }

    private fun setupUI() {

        //OnClickForCalculation
        signUpButtonStudent.setOnClickListener {
            val matricNumber = sign_up_student_matric.text.toString()
            val fullName = sign_upName_student .text.toString()
            val department = sign_up_student_department.text.toString()
            val phoneNumber = sign_up_student_phoneNumber.text.toString()
            val password = sign_up_student_Password.text.toString()

            if (matricNumber.isNullOrEmpty() || password.isNullOrEmpty() || fullName.isNullOrEmpty()
                || department.isNullOrEmpty() || phoneNumber.isNullOrEmpty()) {
                Snackbar.make(
                    it, "Empty Fields, Fill Inputs",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                val user = User(matricNumber, fullName, password,"Student", department
                    , phoneNumber, Date()
                )
                loginViewModel.saveStudentUser(user)
                //Navigation.findNavController(it).navigate(R.id.action_studentSignUpFragment_to_studentLoginFragment)
            }
        }

        //Go to lecturer Signin screen.
        signInToStudentLogin.setOnClickListener { v ->
            Navigation.findNavController(v).navigate(R.id.action_studentSignUpFragment_to_studentLoginFragment)
        }
    }
}