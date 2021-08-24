package com.mmnaguib.organizationalhierarchy.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.mmnaguib.organizationalhierarchy.R
import com.mmnaguib.organizationalhierarchy.databinding.ItemEmployeeBinding
import com.mmnaguib.organizationalhierarchy.model.Data
import com.mmnaguib.organizationalhierarchy.model.EmployeesResponse

class EmployeesAdapter():RecyclerView.Adapter<EmployeesAdapter.ViewHolder>()
{

    var list = ArrayList<Data>()


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_employee,parent,false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = list[position]
        holder.bind(item)
    }

    override fun getItemCount(): Int = list.size

    inner class ViewHolder(val binding: ItemEmployeeBinding):RecyclerView.ViewHolder(binding.root){

        fun bind(item: Data){

            binding.empNameTv.text = item.Name
            binding.empPositionTv.text = item.JobTitle

        }

    }

    fun submitData(list: ArrayList<Data>)
    {
        this.list = list
        notifyDataSetChanged()

    }


}