package com.example.tv365.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.example.tv365.R;
import com.example.tv365.model.Job;

import java.util.ArrayList;

public class CandidateTopJobAdapter extends RecyclerView.Adapter<CandidateTopJobAdapter.TopJobViewholder> {
    private Context context;
    private ArrayList<Job> jobArrayList;

    public CandidateTopJobAdapter(Context context, ArrayList<Job> jobArrayList) {
        this.context = context;
        this.jobArrayList = jobArrayList;
    }

    @NonNull
    @Override
    public TopJobViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_candidate_top_job, parent, false);

        return new TopJobViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopJobViewholder holder, int position) {
        Job job = jobArrayList.get(position);
        if (job == null){
            return;
        }
        holder.tvJobName.setText(job.getJobName());
        holder.tvJobCompany.setText(job.getJobCompany());
        holder.tvJobLocation.setText(job.getJobLocation());
    }

    @Override
    public int getItemCount() {
        if(jobArrayList != null){
            return jobArrayList.size();
        }
        return 0;
    }

    public class TopJobViewholder extends RecyclerView.ViewHolder {

        private ImageView imgTopJob;
        private TextView tvJobName;
        private TextView tvJobCompany;
        private TextView tvJobLocation;

        public TopJobViewholder(@NonNull View itemView) {
            super(itemView);

            imgTopJob = itemView.findViewById(R.id.imgCandidateBanner);
            tvJobName = itemView.findViewById(R.id.tvCandidateJob);
            tvJobCompany = itemView.findViewById(R.id.tvCandidateCompany);
            tvJobLocation = itemView.findViewById(R.id.tvCandidateLocation);
        }
    }
}
