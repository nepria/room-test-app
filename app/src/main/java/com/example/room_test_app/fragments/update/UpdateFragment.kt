package com.example.room_test_app.fragments.update

import android.os.Bundle
import android.text.Editable
import android.text.TextUtils
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.afollestad.materialdialogs.MaterialDialog
import com.example.room_test_app.R
import com.example.room_test_app.model.User
import com.example.room_test_app.viewmodel.ViewModel
import kotlinx.android.synthetic.main.fragment_update.*
import kotlinx.android.synthetic.main.fragment_update.view.*


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
            updateItem()
        }

        setHasOptionsMenu(true)
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

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == R.id.menu_delete) {
            deleteUser()
        }
        return super.onOptionsItemSelected(item)
    }

    private fun deleteUser() {
        MaterialDialog(requireContext()).show {
            title(text = "Do you want to delete the user")
            message(text = "This operation cannot be reversed")
            positiveButton(text = "Yes") {
                mUserViewModel.deleteUser(args.currentUser)
            Toast.makeText(requireContext(), "Successfully removed: ${args.currentUser.firstName}",
            Toast.LENGTH_SHORT).show()
            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
            }
            negativeButton(text = "No") {
                it.dismiss()
            }
        }
//        val builder = AlertDialog.Builder(requireContext())
//        builder.setPositiveButton("Yes") {_, _ ->
//           mUserViewModel.deleteUser(args.currentUser)
//            Toast.makeText(requireContext(), "Successfully removed: ${args.currentUser.firstName}",
//            Toast.LENGTH_SHORT).show()
//            findNavController().navigate(R.id.action_updateFragment_to_listFragment)
//        }
//        builder.setNegativeButton("No"){_, _ -> }
//        builder.setTitle("Delete ${args.currentUser.firstName}?")
//        builder.setMessage("Are you sure you want to delete ${args.currentUser.firstName}?")
//        builder.create().show()
    }

}
