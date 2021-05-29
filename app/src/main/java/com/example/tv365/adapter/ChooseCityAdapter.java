package com.example.tv365.adapter;

/*
Adapter for searching city, workplace, job ...
*/

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tv365.R;
import com.example.tv365.adapter.itemClick.CityItemClick;
import com.example.tv365.adapter.itemClick.ItemClick;
import com.example.tv365.model.init.City.CityDistrictInfo;

import java.util.ArrayList;
import java.util.List;

public class ChooseCityAdapter extends RecyclerView.Adapter<ChooseCityAdapter.Holder > {

    private List<CityDistrictInfo> ls = new ArrayList<>();
    private Context context;
    private CityItemClick itemClick;

    public ChooseCityAdapter(Context context){

        this.context = context;
    }

    public ChooseCityAdapter(Context context, List<CityDistrictInfo> ls){
        this.ls.addAll(ls);
        this.context = context;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_list, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.txtItem.setText(ls.get(position).getCitName());
    }

    @Override
    public int getItemCount() {
        return ls.size();
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView txtItem;

        public Holder(@NonNull View itemView) {
            super(itemView);
            txtItem = itemView.findViewById(R.id.text_card_item);
            itemView.setOnClickListener(v -> itemClick.onClick(ls.get(getAdapterPosition())));
        }
    }
    public void setOnItemClick(CityItemClick itemClick){
        this.itemClick = itemClick;
    }
}
