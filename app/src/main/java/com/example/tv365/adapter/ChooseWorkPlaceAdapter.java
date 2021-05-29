package com.example.tv365.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tv365.R;
import com.example.tv365.adapter.itemClick.ItemClick;

import java.util.ArrayList;
import java.util.List;

public class ChooseWorkPlaceAdapter extends RecyclerView.Adapter<ChooseWorkPlaceAdapter.Holder > {

    private List<String> ls = new ArrayList<String>();
    private Context context;
    private ItemClick itemClick;
    private List<String> listChecked = new ArrayList<>();

    public ChooseWorkPlaceAdapter(Context context){
        this.context = context;
    }

    public ChooseWorkPlaceAdapter(Context context, List<String> ls){
        this.ls.addAll(ls);
        this.context = context;
    }

    public List<String> getList(){
        return ls;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.card_check_box, parent, false);
        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        holder.txtItem.setText(ls.get(position));

        holder.checkBox.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if(isChecked){
                listChecked.add(ls.get(position));

            }else {
                listChecked.remove(ls.get(position));

            }
        });
    }


    @Override
    public int getItemCount() {
        return ls.size();
    }

    public List<String> getChecked(){
        return listChecked;
    }

    public void setData(List<String> s) {
        Log.d("TAG", "setData: " + s.size());
        ls.clear();
        ls.addAll(s);
        this.notifyDataSetChanged();
    }

    public class Holder extends RecyclerView.ViewHolder {

        TextView txtItem;

        CheckBox checkBox;
        public Holder(@NonNull View itemView) {
            super(itemView);

            txtItem = itemView.findViewById(R.id.text_card_item);

            checkBox = itemView.findViewById(R.id.card_checkbox);


            itemView.setOnClickListener(v -> {
                Log.d("TAG", "Holder: " + getAdapterPosition());
                checkBox.setChecked(!checkBox.isChecked());
                int pos = getAdapterPosition();
                notifyItemChanged(pos);
            });
        }
    }
}