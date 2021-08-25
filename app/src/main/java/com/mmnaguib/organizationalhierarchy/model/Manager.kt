package com.mmnaguib.organizationalhierarchy.model

import com.thoughtbot.expandablerecyclerview.models.ExpandableGroup

data class Manager(val manager: Data , val employees: List<Employee>):
        ExpandableGroup<Employee>(manager.Name,employees)
