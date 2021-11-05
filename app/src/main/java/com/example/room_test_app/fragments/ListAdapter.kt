package com.example.room_test_app.fragments

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.room_test_app.R
import com.example.room_test_app.data.User
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
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    fun setData(user: List<User>) {
        this.userList = user
        notifyDataSetChanged()
    }

}