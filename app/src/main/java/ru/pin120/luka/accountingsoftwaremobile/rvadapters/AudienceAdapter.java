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
import ru.pin120.luka.accountingsoftwaremobile.models.Audience;
import ru.pin120.luka.accountingsoftwaremobile.models.Employee;

public class AudienceAdapter extends RecyclerView.Adapter<AudienceAdapter.AudienceViewHolder>{
    private List<Audience> audienceList = new ArrayList<>();
    static class AudienceViewHolder extends RecyclerView.ViewHolder{

        TextView audienceNumber;
        TextView viewHolderIndex;
        public AudienceViewHolder(@NonNull View itemView) {
            super(itemView);

            audienceNumber = itemView.findViewById(R.id.textView_rv_audience_number);
            viewHolderIndex = itemView.findViewById(R.id.textView_rv_audience_holder_number);
        }
    }
    @NonNull
    @Override
    public AudienceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_audience_item, parent, false);
        return new AudienceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AudienceViewHolder holder, int position) {
        Audience audience = audienceList.get(position);
        holder.audienceNumber.setText(audience.getName());
        holder.viewHolderIndex.setText(String.valueOf(position + 1));
    }

    @Override
    public int getItemCount() {
        return audienceList.size();
    }
    public void setData(List<Audience> newList) {
        audienceList.clear();
        audienceList.addAll(newList);
        notifyDataSetChanged();
    }
}
