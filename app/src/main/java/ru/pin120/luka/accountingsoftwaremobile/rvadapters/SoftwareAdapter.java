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
import ru.pin120.luka.accountingsoftwaremobile.models.Software;
import ru.pin120.luka.accountingsoftwaremobile.models.SoftwareTechnicalDetails;

public class SoftwareAdapter extends RecyclerView.Adapter<SoftwareAdapter.SoftwareViewHolder>{
    List<Software> softwareList = new ArrayList<>();
    static class SoftwareViewHolder extends RecyclerView.ViewHolder{

        TextView softwareName;
        TextView softwareLicenceKey;
        TextView softwareLicenceType;
        TextView softwareLicenceDateStart;
        TextView softwareLicenceDateEnd;
        TextView softwareLicenceEmployee;
        TextView softwareLicenceCount;
        public SoftwareViewHolder(@NonNull View itemView) {
            super(itemView);

            softwareName = itemView.findViewById(R.id.textView_rv_licence_software_name);
            softwareLicenceKey = itemView.findViewById(R.id.textView_rv_licence_key);
            softwareLicenceType = itemView.findViewById(R.id.textView_rv_licence_type);
            softwareLicenceDateStart = itemView.findViewById(R.id.textView_rv_licence_date_start);
            softwareLicenceDateEnd = itemView.findViewById(R.id.textView_rv_licence_date_end);
            softwareLicenceEmployee = itemView.findViewById(R.id.textView_rv_licence_employee);
            softwareLicenceCount = itemView.findViewById(R.id.textView_rv_licence_count);
        }
    }
    @NonNull
    @Override
    public SoftwareAdapter.SoftwareViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_licence_item, parent, false);
        return new SoftwareAdapter.SoftwareViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoftwareAdapter.SoftwareViewHolder holder, int position) {
        Software software = softwareList.get(position);
        boolean getLicence = software.getLicence() != null;
        boolean getLicenceDetails = false, getLicenceType = false, getLicenceEmployee = false;
        if(getLicence){
            getLicenceDetails = software.getLicence().getLicenceDetails() != null;
            getLicenceEmployee = software.getLicence().getEmployee() != null;
            getLicenceType = software.getLicence().getLicenceType() != null;
        }


        holder.softwareName.setText(software.getSoftwareTechnicalDetails().getName());
        holder.softwareLicenceKey.setText(String.format("Ключ: %s", ((getLicence && getLicenceDetails && software.getLicence().getLicenceDetails().getLicenceKey() != null)?
                software.getLicence().getLicenceDetails().getLicenceKey() : "Не указано" )));
        holder.softwareLicenceType.setText(String.format("Тип: %s", ((getLicence && getLicenceType && software.getLicence().getLicenceType().getName() != null)?
                software.getLicence().getLicenceType().getName() : "Не указано" )));
        holder.softwareLicenceDateStart.setText(String.format("Дата начала: %s", ((getLicence && getLicenceDetails && software.getLicence().getLicenceDetails().getDateStart() != null)?
                software.getLicence().getLicenceDetails().getDateStart() : "Не указано" )));
        holder.softwareLicenceDateEnd.setText(String.format("Дата окончания: %s", ((getLicence && getLicenceDetails && software.getLicence().getLicenceDetails().getDateEnd() != null)?
                software.getLicence().getLicenceDetails().getDateEnd() : "Не указано" )));
        holder.softwareLicenceEmployee.setText(String.format("Ответственное лицо: %s", ((getLicence && getLicenceEmployee && software.getLicence().getEmployee().getFullName() != null)?
                software.getLicence().getEmployee().getFullName() : "Не указано" )));
        holder.softwareLicenceCount.setText(String.format("Количество доступных: %d", ((getLicence && getLicenceDetails)?
                software.getLicence().getLicenceDetails().getCount(): 0)));
    }

    @Override
    public int getItemCount() {
        return softwareList.size();
    }
    public void setData(List<Software> newList) {
        softwareList.clear();
        softwareList.addAll(newList);
        notifyDataSetChanged();
    }
}
