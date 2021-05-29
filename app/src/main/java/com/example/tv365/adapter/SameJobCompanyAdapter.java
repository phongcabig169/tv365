package com.example.tv365.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tv365.R;
import com.example.tv365.model.CandidateJob;
import com.example.tv365.model.Job;

import java.util.ArrayList;

public class SameJobCompanyAdapter extends RecyclerView.Adapter<SameJobCompanyAdapter.SameJCViewHolder> {

    private Context context;
    private ArrayList<CandidateJob> jobArrayList;

    public SameJobCompanyAdapter(Context context, ArrayList<CandidateJob> jobArrayList) {
        this.context = context;
        this.jobArrayList = jobArrayList;
    }

    @NonNull
    @Override
    public SameJCViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_candidate_job, parent, false);

        return new SameJCViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SameJCViewHolder holder, int position) {
        CandidateJob candidateJob = jobArrayList.get(position);
        if (candidateJob == null){
            return;
        }
        holder.tvRecruitmentTitle.setText(candidateJob.getCjTitle());
        holder.tvRecruitmentCompany.setText(candidateJob.getCjCompany());
        holder.txt_job_address.setText(candidateJob.getCjLocation());
        holder.tvRecruitmentSalary.setText(candidateJob.getCjSalary());
        holder.tvRecruitmentDateUpdate.setText(candidateJob.getCjDate());
    }

    @Override
    public int getItemCount() {
        if (jobArrayList != null){
            return jobArrayList.size();
        }
        return 0;
    }

    class SameJCViewHolder extends RecyclerView.ViewHolder {

        private TextView tvRecruitmentTitle;
        private TextView tvRecruitmentCompany;
        private TextView txt_job_address;
        private TextView tvRecruitmentSalary;
        private TextView tvRecruitmentDateUpdate;

        public SameJCViewHolder(@NonNull View itemView) {
            super(itemView);

            tvRecruitmentTitle = itemView.findViewById(R.id.tvRecruitmentTitle);
            tvRecruitmentCompany = itemView.findViewById(R.id.tvRecruitmentCompany);
            txt_job_address = itemView.findViewById(R.id.txt_job_address);
            tvRecruitmentSalary = itemView.findViewById(R.id.tvRecruitmentSalary);
            tvRecruitmentDateUpdate = itemView.findViewById(R.id.tvRecruitmentDateUpdate);
        }
    }

}
