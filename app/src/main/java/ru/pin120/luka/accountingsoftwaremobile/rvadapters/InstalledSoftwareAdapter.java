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
import ru.pin120.luka.accountingsoftwaremobile.models.Computer;
import ru.pin120.luka.accountingsoftwaremobile.models.Software;

public class InstalledSoftwareAdapter extends RecyclerView.Adapter<InstalledSoftwareAdapter.InstalledSoftwareViewHolder> {
    List<Computer> computerList = new ArrayList<>();
    private String selectedAudience;
    public void setSelectedAudience(String audience) {
        selectedAudience = audience;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public InstalledSoftwareAdapter.InstalledSoftwareViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_installed_software_item, parent, false);
        return new InstalledSoftwareAdapter.InstalledSoftwareViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull InstalledSoftwareAdapter.InstalledSoftwareViewHolder holder, int position) {
        Computer computer = computerList.get(position);
        if(selectedAudience == null || computerContainsAudience(computer, selectedAudience)){
            holder.itemView.setVisibility(View.VISIBLE);
            holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));

            holder.computerNumber.setText(String.format("Компьютер: %s", computer.getNumber()));
            holder.computerAudience.setText(String.format("Аудитория: %s", computer.getAudience() != null? computer.getAudience().getName() : "Не указано"));

            StringBuilder softwareNameBuilder = new StringBuilder(150);
            String key, dateStart, dateEnd;

            for(Software software : computer.getSoftwares()){
                key = software.getLicence().getLicenceDetails().getLicenceKey() != null? software.getLicence().getLicenceDetails().getLicenceKey() : "Не указано";
                dateStart = software.getLicence().getLicenceDetails().getDateStart() != null? software.getLicence().getLicenceDetails().getDateStart() : "Не указано";
                dateEnd = software.getLicence().getLicenceDetails().getDateEnd() != null? software.getLicence().getLicenceDetails().getDateEnd() : "Не указано";
                softwareNameBuilder.append(String.format("\nПО: %s \nКлюч: %s \nДата: %s - %s \n", software.getSoftwareTechnicalDetails().getName(), key, dateStart, dateEnd));
            }
            if(softwareNameBuilder.length() > 0)
                softwareNameBuilder.deleteCharAt(softwareNameBuilder.length()-1);
            holder.softwareName.setText(softwareNameBuilder.toString());
        }
        else{
            holder.itemView.setVisibility(View.GONE);
            holder.itemView.setLayoutParams(new RecyclerView.LayoutParams(0, 0));
        }

    }
    private boolean computerContainsAudience(Computer computer, String audience) {
        return computer.getAudience() != null? computer.getAudience().getName().equals(audience) : false;
    }
    @Override
    public int getItemCount() { return computerList.size(); }

    public void setData(List<Computer> newList) {
        computerList.clear();
        computerList.addAll(newList);
        notifyDataSetChanged();
    }
    static class InstalledSoftwareViewHolder extends RecyclerView.ViewHolder{

        TextView computerNumber;
        TextView computerAudience;
        TextView softwareName;

        public InstalledSoftwareViewHolder(@NonNull View itemView) {
            super(itemView);
            computerNumber = itemView.findViewById(R.id.textView_rv_installed_software_computer_number);
            computerAudience = itemView.findViewById(R.id.textView_rv_installed_software_audience_name);
            softwareName = itemView.findViewById(R.id.textView_rv_installed_software_data);
        }
    }
}
