package com.example.tv365.adapter;

import android.content.Context;
import android.graphics.Point;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tv365.R;
import com.example.tv365.model.Job;

import java.util.ArrayList;

public class SuitableJobAdapter extends RecyclerView.Adapter<SuitableJobAdapter.SuitableJobViewHolder> {

    private Context context;
    private ArrayList<Job> jobArrayList;

    public SuitableJobAdapter(Context context, ArrayList<Job> jobArrayList) {
        this.context = context;
        this.jobArrayList = jobArrayList;
    }

    @NonNull
    @Override
    public SuitableJobViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_candidate_suitable_job, parent, false);

        Point size = new Point();
        WindowManager windowManager = (WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        windowManager.getDefaultDisplay().getSize(size);
        int width = size.x/3;
        int height = size.y;

        view.setLayoutParams(new RecyclerView.LayoutParams(width, RecyclerView.LayoutParams.MATCH_PARENT));

        return new SuitableJobViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SuitableJobViewHolder holder, int position) {
        Job job = jobArrayList.get(position);
        if (job == null){
            return;
        }
        holder.bindDataSJ(job);
    }

    @Override
    public int getItemCount() {
        if (jobArrayList != null){
            return jobArrayList.size();
        }
        return 0;
    }

    class SuitableJobViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgSuitableJobLogo;
        private TextView tvJobNameSuitableJob;
        private TextView tvCompanySuitableJob;

        SuitableJobViewHolder(@NonNull View itemView) {
            super(itemView);

            imgSuitableJobLogo = itemView.findViewById(R.id.imgSuitableJobLogo);
            tvJobNameSuitableJob = itemView.findViewById(R.id.tvJobNameSuitableJob);
            tvCompanySuitableJob = itemView.findViewById(R.id.tvCompanySuitableJob);
        }

        private void bindDataSJ(Job job){
            tvCompanySuitableJob.setText(job.getJobCompany());
            tvJobNameSuitableJob.setText(job.getJobName());
        }
    }
}
