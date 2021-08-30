package com.ou.gpa_calculator.BaseView.Login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.textfield.TextInputEditText
import com.ou.gpa_calculator.DataBase.UsersDataClass
import com.ou.gpa_calculator.LocalData.DatabaseBuilder
import com.ou.gpa_calculator.LocalData.DatabaseHelperImpl
import com.ou.gpa_calculator.LocalData.entity.User
import com.ou.gpa_calculator.R
import com.ou.gpa_calculator.Util.ViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.fragment_student_login.*
@AndroidEntryPoint
class StudentLoginFragment: Fragment() {

//    private val loginViewModel: LoginViewModel by lazy {
//        val activity = requireActivity()
//        ViewModelProvider(
//            activity,
//            ViewModelFactory(DatabaseHelperImpl(DatabaseBuilder.getInstance(requireContext())))
//        ).get(LoginViewModel::class.java)
//    }

    private val loginViewModel: LoginViewModel by viewModels()

    private lateinit var userList: List<UsersDataClass>
    private lateinit var button: Button
    private var userMatric: String = "u/17/cs/0123"
    private var userPassword: String = "okafor"
    private var userMatric1: String = "u/17/cs/0205"
    private var userPassword1: String = "williams"
    private lateinit var matric: TextInputEditText
    private lateinit var word: TextInputEditText

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_student_login, container, false)

//        loginViewModel = ViewModelProvider(requireActivity(), ViewModelFactory(DatabaseHelperImpl
//            (DatabaseBuilder.getInstance(requireContext())))).get(LoginViewModel::class.java)

//        loginViewModel.getAllUsers().observe(requireActivity(), {
//            if (it != null && it.isNotEmpty()) {
//                userList = ArrayList(it)
//            }
//        })

        button = view.findViewById(R.id.studentLoginIn)
        matric = view.findViewById(R.id.studentLoginMatric)
        word = view.findViewById(R.id.studentLoginPassword)

        //OnClickForCalculation
        button.setOnClickListener {
            val matricnumber = matric.text.toString()
            val password = word.text.toString()

            if (matricnumber.isNullOrEmpty() || password.isNullOrEmpty()) {
                Snackbar.make(
                    it, "Empty Matric Number or Password Field",
                    Snackbar.LENGTH_LONG
                ).show()
            } else {
                if (matricnumber.isNotEmpty() && password.isNotEmpty()) {

                    Navigation.findNavController(it).navigate(R.id.action_studentLoginFragment_to_homeFragment)
                    //loginViewModel.queryIfUserExist(matricnumber, password, "Student")
                }else{
                    Toast.makeText(activity, "Login Details not Correct", Toast.LENGTH_SHORT).show()
                }

//                for (usersInfo: UsersDataClass in userList) {
//                    userMatric = usersInfo.userId
//                    userPassword = usersInfo.password
//                    if (userPassword.equals(matricnumber) && userMatric.equals(password)) {
//
//                        Navigation.findNavController(it).navigate(R.id.action_studentLoginFragment_to_homeFragment)
//                        //loginViewModel.queryIfUserExist(matricnumber, password, "Student")
//                    }
//                }

                //Go to lecturer Signin screen.
                goToLecturerSignIn.setOnClickListener { v ->
                    Navigation.findNavController(v).navigate(R.id.action_studentLoginFragment_to_lecturerLoginFragment)
                }

            }
        }


        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //setupUI()
        //setupObserver()
    }


    companion object {

        @JvmStatic
        fun newInstance() =
            StudentLoginFragment()
    }

    private fun setupObserver() {

//       loginViewModel.user.observe(viewLifecycleOwner) { userInfo ->
//            if (userInfo != null){
//                view?.let { Navigation.findNavController(it).navigate(R.id.action_studentLoginFragment_to_homeFragment) }
//            }
//           else{
//                view?.let { Snackbar.make(it,"Incorrect Matric Number or Password",Snackbar.LENGTH_SHORT).show() }
//           }
//        }
    }


    private fun setupUI() {

//        //OnClickForCalculation
//        studentLoginIn.setOnClickListener {
//            val matricnumber = studentLoginMatric.text.toString()
//            val password = studentLoginPassword.text.toString()
//
//            if (matricnumber.isNullOrEmpty() || password.isNullOrEmpty()) {
//                Snackbar.make(
//                    it, "Empty Matric Number or Password Field",
//                    Snackbar.LENGTH_LONG
//                ).show()
//            } else {
//                for (usersInfo: User in userList) {
//                    userMatric = usersInfo.userId
//                    userPassword = usersInfo.password
//                    if (userPassword.equals(matricnumber) && userMatric.equals(password)) {
//
//                        Navigation.findNavController(it).navigate(R.id.action_studentLoginFragment_to_homeFragment)
//                        //loginViewModel.queryIfUserExist(matricnumber, password, "Student")
//                    }
//                }
//
//                //Go to lecturer Signin screen.
//                goToLecturerSignIn.setOnClickListener { v ->
//                    Navigation.findNavController(v).navigate(R.id.action_studentLoginFragment_to_lecturerLoginFragment)
//                }
//
//            }
//        }
    }
}