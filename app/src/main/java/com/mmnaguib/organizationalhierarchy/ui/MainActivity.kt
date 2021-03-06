package com.mmnaguib.organizationalhierarchy.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.mmnaguib.organizationalhierarchy.R
import com.mmnaguib.organizationalhierarchy.databinding.ActivityMainBinding
import com.mmnaguib.organizationalhierarchy.model.Data
import com.mmnaguib.organizationalhierarchy.model.Employee
import com.mmnaguib.organizationalhierarchy.model.Manager
import com.mmnaguib.organizationalhierarchy.ui.adapters.EmployeesAdapter
import com.mmnaguib.organizationalhierarchy.ui.adapters.HierarchyAdapter
import org.koin.android.viewmodel.ext.android.getViewModel
import org.koin.core.component.KoinComponent

class MainActivity : AppCompatActivity(), KoinComponent {

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: EmployeesAdapter
    private lateinit var viewModel: EmployeesViewModel
    private lateinit var hierarchyAdapter: HierarchyAdapter

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        adapter = EmployeesAdapter()

        subscribeToObserver()
    }

    private fun subscribeToObserver(){

        viewModel = getViewModel()


        viewModel.employeesData.observe(this, Observer {
            Log.e(TAG, "subscribeToObserver: size ${it.Data.size}" )
            adapter.submitData(it.Data as ArrayList<Data>)

            filterList(it.Data)


        })

//        binding.empRv.layoutManager = LinearLayoutManager(this)
//        binding.empRv.adapter = adapter

    }

    fun filterList(list: ArrayList<Data>){

        val listOfManagers = ArrayList<Manager>()
        val listOfEmployees = ArrayList<Employee>()

        for(i in list){

            for (j in list){
                if (i.ManagerID == j.ManagerID){
                    listOfEmployees.add(Employee(j))
                }
            }
            listOfManagers.add(Manager(i,listOfEmployees))
        }
        hierarchyAdapter = HierarchyAdapter(listOfManagers)
        binding.empRv.layoutManager = LinearLayoutManager(this)
        binding.empRv.adapter = hierarchyAdapter

    }

}