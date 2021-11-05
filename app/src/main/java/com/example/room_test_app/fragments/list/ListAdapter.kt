package com.example.room_test_app.fragments.list

import android.app.ListFragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.example.room_test_app.R
import com.example.room_test_app.fragments.listFragmentDirections
import com.example.room_test_app.model.User
import kotlinx.android.synthetic.main.custom_row.view.*
import java.util.Collections.emptyList


class ListAdapter: RecyclerView.Adapter<ListAdapter.MyViewHolder>() {
    private var userList = emptyList<User>()
    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
       return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
       val currentItem = userList[position]
        holder.itemView.number.text = currentItem.id.toString()
        holder.itemView.firstname.text = currentItem.firstName
        holder.itemView.lastname.text = currentItem.lastName
        holder.itemView.age.text = currentItem.age.toString()

        holder.itemView.row_layout.setOnClickListener{
            val action = listFragmentDirections.actionListFragmentToUpdateFragment(currentItem)
            holder.itemView.findNavController().navigate(action)
        }


    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }

}