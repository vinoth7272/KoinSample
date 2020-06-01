package com.example.koinsample.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.koinsample.R
import com.example.koinsample.viewmodel.EmployeeViewModel
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.movie_activity.*
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.viewModel

class EmployeeActivity : AppCompatActivity() {

    private val employeeViewModel: EmployeeViewModel by viewModel()
    private val picasso: Picasso by inject()
    private val employeeListAdapter = EmployeeListAdapter(arrayListOf())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.movie_activity)

        employeeViewModel.getEmployees()
        rvEmployeeList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = employeeListAdapter
        }

        observerViewModel()

    }

    private fun observerViewModel() {
        employeeViewModel.employeeApiResponse.observe(this, Observer { employees ->
            employees?.let {
                rvEmployeeList.visibility = View.VISIBLE
                employeeListAdapter.updateList(it.data)
            }
        })
        employeeViewModel.employeeDataState.observe(this, Observer { isError ->
            list_error.visibility = if (isError === null) View.GONE else View.VISIBLE
        })

        employeeViewModel.loading.observe(this, Observer { isLoading ->
            isLoading?.let {
                loading_view.visibility = if (it) View.VISIBLE else View.GONE
                if (it) {
                    rvEmployeeList.visibility = View.GONE
                    list_error.visibility = View.GONE
                }
            }
        })
    }

}