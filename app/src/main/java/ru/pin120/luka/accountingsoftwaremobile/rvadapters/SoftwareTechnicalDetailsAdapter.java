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
import ru.pin120.luka.accountingsoftwaremobile.models.SoftwareTechnicalDetails;

public class SoftwareTechnicalDetailsAdapter extends RecyclerView.Adapter<SoftwareTechnicalDetailsAdapter.SoftwareTechnicalDetailsViewHolder>{
    List<SoftwareTechnicalDetails> softwareTechnicalDetailsList = new ArrayList<>();
    static class SoftwareTechnicalDetailsViewHolder extends RecyclerView.ViewHolder{

        TextView softwareNameSubjectArea;
        TextView viewHolderIndex;
        public SoftwareTechnicalDetailsViewHolder(@NonNull View itemView) {
            super(itemView);

            softwareNameSubjectArea = itemView.findViewById(R.id.textView_rv_software_name);
            viewHolderIndex = itemView.findViewById(R.id.textView_rv_software_subject_area_name);
        }
    }
    @NonNull
    @Override
    public SoftwareTechnicalDetailsAdapter.SoftwareTechnicalDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_software_item, parent, false);
        return new SoftwareTechnicalDetailsAdapter.SoftwareTechnicalDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SoftwareTechnicalDetailsAdapter.SoftwareTechnicalDetailsViewHolder holder, int position) {
        SoftwareTechnicalDetails softwareTechnicalDetails = softwareTechnicalDetailsList.get(position);
        holder.softwareNameSubjectArea.setText(String.format("%s", softwareTechnicalDetails.getName()));
        holder.viewHolderIndex.setText(softwareTechnicalDetails.getSubjectArea() != null? softwareTechnicalDetails.getSubjectArea().getName() : "Не указано");
    }

    @Override
    public int getItemCount() {
        return softwareTechnicalDetailsList.size();
    }
    public void setData(List<SoftwareTechnicalDetails> newList) {
        softwareTechnicalDetailsList.clear();
        softwareTechnicalDetailsList.addAll(newList);
        notifyDataSetChanged();
    }
}
