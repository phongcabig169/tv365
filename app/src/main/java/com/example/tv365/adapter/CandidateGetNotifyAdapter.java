package com.example.tv365.adapter;

import android.content.Context;
import android.os.Build;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;


import com.example.tv365.R;
import com.example.tv365.model.CandidateGetNotify;

import java.util.ArrayList;

import de.hdodenhof.circleimageview.CircleImageView;

public class CandidateGetNotifyAdapter extends RecyclerView.Adapter<CandidateGetNotifyAdapter.GetNotifyViewHolder>{

    private Context context;
    private ArrayList<CandidateGetNotify> candidateGetNotifyArrayList;

    public CandidateGetNotifyAdapter(Context context, ArrayList<CandidateGetNotify> candidateGetNotifyArrayList) {
        this.context = context;
        this.candidateGetNotifyArrayList = candidateGetNotifyArrayList;
    }

    @NonNull
    @Override
    public GetNotifyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_candidate_get_notify, parent, false);

        return new GetNotifyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GetNotifyViewHolder holder, int position) {
        CandidateGetNotify candidateGetNotify = candidateGetNotifyArrayList.get(position);
        if (candidateGetNotify == null){
            return;
        }
        holder.tvCGNContent.setText(candidateGetNotify.getCgnContent());

        if (position % 2 == 0) {
            //holder.item_cgn.setBackgroundColor(0xFF00FF00);
            holder.item_cgn.setBackgroundResource(R.drawable.notify_list_background);
        } else {
            holder.item_cgn.setBackgroundResource(R.drawable.notify_list_background_alternate);
        }
    }

    @Override
    public int getItemCount() {
        if (candidateGetNotifyArrayList != null){
            return candidateGetNotifyArrayList.size();
        }
        return 0;
    }

    class GetNotifyViewHolder extends RecyclerView.ViewHolder {

        private CircleImageView imgCGN;
        private TextView tvCGNContent;
        private ConstraintLayout item_cgn;

        GetNotifyViewHolder(@NonNull View itemView) {
            super(itemView);

            imgCGN = itemView.findViewById(R.id.imgCGN);
            tvCGNContent = itemView.findViewById(R.id.tvCGNContent);
            item_cgn = itemView.findViewById(R.id.item_cgn);

        }
    }
}
