package com.example.room_test_app.fragments.update

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.room_test_app.R
import com.example.room_test_app.model.User
import com.example.room_test_app.viewmodel.ViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class UpdateFragment : Fragment() {

    private val args by navArgs<UpdateFragmentArgs>()

    private lateinit var mUserViewModel : ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment

      val view = inflater.inflate(R.layout.fragment_update, container, false)

        mUserViewModel = ViewModelProvider(this).get(ViewModel::class.java)

        view.updatefirstname.setText(args.currentUser.firstName)
        view.updatelastname.setText(args.currentUser.lastName)
        view.updateage.setText(args.currentUser.age.toString())

        view.updatebtn.setOnClickListener {

       }


        return view
    }
    private fun updateItem() {
        val firstName = updatefirstname.text.toString()
        val lastName = updatelastname.text.toString()
        val  Age = Integer.parseInt(updateage.text.toString())

        if(inputCheck(firstName, lastName, updateage.text)) {
            val updatedUser = User(args.currentUser.id, firstName,lastName,Age)
            mUserViewModel.updateUser(updatedUser)
            Toast.makeText(requireContext(), "Updated Successfully!", Toast.LENGTH_LONG)
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
        } else {
            Toast.makeText(requireContext(), "Please fill all details", Toast.LENGTH_LONG)
        }
    }
    private fun inputCheck(firstname: String, lastname: String, age: Editable): Boolean {
        return !(TextUtils.isEmpty(firstname) && TextUtils.isEmpty(lastname) && age.isEmpty())
    }

}
