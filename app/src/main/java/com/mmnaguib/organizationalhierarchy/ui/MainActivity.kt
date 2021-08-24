package com.mmnaguib.organizationalhierarchy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mmnaguib.organizationalhierarchy.R
import com.mmnaguib.organizationalhierarchy.databinding.ActivityMainBinding
import com.mmnaguib.organizationalhierarchy.model.Data
import com.mmnaguib.organizationalhierarchy.ui.adapters.EmployeesAdapter
import org.koin.android.viewmodel.ext.android.getViewModel
import org.koin.core.component.KoinComponent

class MainActivity : AppCompatActivity(), KoinComponent {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: EmployeesAdapter
    private lateinit var viewModel: EmployeesViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        adapter = EmployeesAdapter()

        subscribeToObserver()
    }

    private fun subscribeToObserver(){

        viewModel = getViewModel()

        viewModel.employeesData.observe(this, Observer {

            adapter.submitData(it.Data as ArrayList<Data>)

        })

        binding.empRv.layoutManager = LinearLayoutManager(this)
        binding.empRv.adapter = adapter

    }

}