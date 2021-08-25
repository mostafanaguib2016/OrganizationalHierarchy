package com.mmnaguib.organizationalhierarchy.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.mmnaguib.organizationalhierarchy.R
import com.mmnaguib.organizationalhierarchy.model.Employee
import com.mmnaguib.organizationalhierarchy.model.Manager
import com.thoughtbot.expandablerecyclerview.ExpandableRecyclerViewAdapter
import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

class HierarchyAdapter(groups: List<ExpandableGroup<*>?>?)
    : ExpandableRecyclerViewAdapter<ManagerViewHolder,EmployeeViewHolder>(groups)
{
    override fun onCreateGroupViewHolder(parent: ViewGroup, viewType: Int): ManagerViewHolder =
        ManagerViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_employee,parent,false
            )
        )

    override fun onCreateChildViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder =
        EmployeeViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_employee,parent,false
            )
        )

    override fun onBindChildViewHolder(
        holder: EmployeeViewHolder,
        flatPosition: Int,
        group: ExpandableGroup<*>,
        childIndex: Int
    ) {
        val item = group.items[childIndex] as Employee
        holder.bind(item)
    }

    override fun onBindGroupViewHolder(
        holder: ManagerViewHolder,
        flatPosition: Int,
        group: ExpandableGroup<*>
    ) {
        val item = group as Manager
        holder.bind(item)
    }


}