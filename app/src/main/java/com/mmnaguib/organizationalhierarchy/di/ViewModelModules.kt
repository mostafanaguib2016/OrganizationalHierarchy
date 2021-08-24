package com.mmnaguib.organizationalhierarchy.di


import com.mmnaguib.organizationalhierarchy.ui.EmployeesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelsModule = module {

    viewModel { EmployeesViewModel(get()) }

}