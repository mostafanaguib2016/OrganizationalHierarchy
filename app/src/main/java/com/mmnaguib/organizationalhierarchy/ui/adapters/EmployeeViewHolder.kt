package com.mmnaguib.organizationalhierarchy.ui.adapters

import android.widget.RelativeLayout
import com.mmnaguib.organizationalhierarchy.databinding.ItemEmployeeBinding
import com.mmnaguib.organizationalhierarchy.model.Employee
import com.thoughtbot.expandablerecyclerview.viewholders.ChildViewHolder


class EmployeeViewHolder(val binding: ItemEmployeeBinding): ChildViewHolder(binding.root)
{

    fun bind(item: Employee){

        binding.empNameTv.text = item.employee.Name
        binding.empPositionTv.text = item.employee.JobTitle

    }

}