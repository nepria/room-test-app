package com.example.room_test_app.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.room_test_app.R
import com.example.room_test_app.fragments.update.UpdateFragmentArgs
import com.example.room_test_app.viewmodel.ViewModel
import kotlinx.android.synthetic.main.fragment_priview.view.*

class priview : Fragment() {
    private val args by navArgs<priviewArgs>()
    private lateinit var mUserViewModel : ViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view =  inflater.inflate(R.layout.fragment_priview, container, false)

        mUserViewModel = ViewModelProvider(this).get(ViewModel::class.java)
        view.authorpreview.text = args.currentUser.author
        view.quotepreview.text = args.currentUser.quote

        return view;
    }
}
