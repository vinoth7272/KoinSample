package com.example.koinsample.view

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.koinsample.R
import com.example.koinsample.model.Employee
import kotlinx.android.synthetic.main.item_view_employee_list.view.*
import kotlin.math.log2

class EmployeeListAdapter(var employeeList: ArrayList<Employee>) :
    RecyclerView.Adapter<EmployeeListAdapter.EmployeeViewHolder>() {

    fun updateList(employee: List<Employee>) {
        employeeList.clear()
        employeeList.addAll(employee)
        notifyDataSetChanged()
    }

    class EmployeeViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        val U_TAG = EmployeeListAdapter::class.java.simpleName
        fun bindData(employee: Employee) {
            Log.d(U_TAG, employee.toString())
            itemView.name.text = employee.employeeName
            itemView.salary.text = employee.emlployeeSal
            itemView.age.text = employee.employeeAge.toString()
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EmployeeViewHolder =
        EmployeeViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_view_employee_list, parent, false)
        )


    override fun getItemCount(): Int = employeeList.size

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        holder.bindData(employeeList.get(position))
    }
}