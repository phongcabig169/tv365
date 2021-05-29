package com.example.tv365.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.view.GravityCompat;
import androidx.recyclerview.widget.RecyclerView;


import com.example.tv365.R;
import com.example.tv365.adapter.itemClick.OnItemUserDrawClickListener;

import java.util.List;

public class CandidateDialogAdapter extends RecyclerView.Adapter<CandidateDialogAdapter.CandidateDialogViewHolder> {

    private Context context;
    private List<String> stringList;
    private OnItemUserDrawClickListener onItemUserDrawClickListener;

    public CandidateDialogAdapter(Context context, List<String> stringList, OnItemUserDrawClickListener onItemUserDrawClickListener1) {
        this.context = context;
        this.stringList = stringList;
        this.onItemUserDrawClickListener = onItemUserDrawClickListener1;
    }

    @NonNull
    @Override
    public CandidateDialogViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_dialog_candidate, parent, false);

        return new CandidateDialogViewHolder(view, onItemUserDrawClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CandidateDialogViewHolder holder, int position) {
        if (stringList.get(position) == null){
            return;
        }
        holder.tvLinkPageDialog.setText(stringList.get(position));
    }

    @Override
    public int getItemCount() {
        if (stringList != null){
            return stringList.size();
        }
        return 0;
    }

    class CandidateDialogViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private TextView tvLinkPageDialog;
        private OnItemUserDrawClickListener onItemUserDrawClickListener;

        CandidateDialogViewHolder(@NonNull View itemView, OnItemUserDrawClickListener onItemUserDrawClickListener1) {
            super(itemView);

            tvLinkPageDialog = itemView.findViewById(R.id.tvLinkPageDialog);

            this.onItemUserDrawClickListener = onItemUserDrawClickListener1;
            itemView.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            onItemUserDrawClickListener.onItemUserDrawClick(getAdapterPosition());
        }
    }
}
