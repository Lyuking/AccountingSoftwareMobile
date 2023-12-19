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
import ru.pin120.luka.accountingsoftwaremobile.models.Computer;

public class ComputerAdapter extends RecyclerView.Adapter<ComputerAdapter.ComputerViewHolder>{
    private List<Computer> computerList = new ArrayList<>();

    @NonNull
    @Override
    public ComputerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_computer_item, parent, false);
        return new ComputerAdapter.ComputerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ComputerViewHolder holder, int position) {
        Computer computer = computerList.get(position);
        holder.computerNumber.setText(String.format("Номер: %s", computer.getNumber()));
        holder.computerIpAddress.setText(String.format("IPv4: %s", computer.getIpAddress() != null ? computer.getIpAddress() : "Не указано"));
        holder.computerAudienceName.setText(String.format("Аудитория: %s", computer.getAudience() != null ? computer.getAudience().getName() : "Не указано"));
        holder.computerProcessor.setText(String.format("Процессор: %s", computer.getProcessor() != null ? computer.getProcessor() : "Не указано"));
        holder.computerVideocard.setText(String.format("Видеокарта: %s", computer.getVideocard() != null ? computer.getVideocard() : "Не указано"));
        holder.computerRam.setText(String.format("ОЗУ: %s", computer.getRam() != null ? computer.getRam() : "Не указано"));
        holder.computerTotalSpace.setText(String.format("Место на диске: %s", computer.getTotalSpace() != null ? computer.getTotalSpace() : "Не указано"));

    }

    @Override
    public int getItemCount() { return computerList.size(); }

    public void setData(List<Computer> newList) {
        computerList.clear();
        computerList.addAll(newList);
        notifyDataSetChanged();
    }


    static class ComputerViewHolder extends RecyclerView.ViewHolder{

        TextView computerNumber;
        TextView computerIpAddress;
        TextView computerAudienceName;
        TextView computerProcessor;
        TextView computerVideocard;
        TextView computerRam;
        TextView computerTotalSpace;
        public ComputerViewHolder(@NonNull View itemView) {
            super(itemView);
            computerNumber = itemView.findViewById(R.id.textView_rv_computer_number);
            computerIpAddress = itemView.findViewById(R.id.textView_rv_computer_ipAddress);
            computerAudienceName = itemView.findViewById(R.id.textView_rv_computer_audience_name);
            computerProcessor = itemView.findViewById(R.id.textView_rv_computer_processor);
            computerVideocard = itemView.findViewById(R.id.textView_rv_computer_videocard);
            computerRam = itemView.findViewById(R.id.textView_rv_computer_ram);
            computerTotalSpace = itemView.findViewById(R.id.textView_rv_computer_totalspace);
        }
    }
}
