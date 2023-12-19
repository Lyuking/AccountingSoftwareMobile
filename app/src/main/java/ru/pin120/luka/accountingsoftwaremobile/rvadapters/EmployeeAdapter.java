package ru.pin120.luka.accountingsoftwaremobile.rvadapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import ru.pin120.luka.accountingsoftwaremobile.R;
import ru.pin120.luka.accountingsoftwaremobile.models.Employee;

public class EmployeeAdapter extends RecyclerView.Adapter<EmployeeAdapter.EmployeeViewHolder>{
    private List<Employee> employeeList = new ArrayList<>();

    static class EmployeeViewHolder extends RecyclerView.ViewHolder{

        TextView employeeFullName;
        TextView viewHolderIndex;
        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);

            employeeFullName = itemView.findViewById(R.id.textView_rv_employee_fullname);
            viewHolderIndex = itemView.findViewById(R.id.textView_rv_employee_holder_number);
        }
    }
    @NonNull
    @Override
    public EmployeeAdapter.EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_employee_item, parent, false);
        return new EmployeeAdapter.EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeAdapter.EmployeeViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.employeeFullName.setText(employee.getFullName());
        holder.viewHolderIndex.setText(String.valueOf(position + 1));
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }
    public void setData(List<Employee> newList) {
        employeeList.clear();
        employeeList.addAll(newList);
        notifyDataSetChanged();
    }
}
