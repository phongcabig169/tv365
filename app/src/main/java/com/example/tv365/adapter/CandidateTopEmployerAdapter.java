package com.example.tv365.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.ViewPager2;

import com.example.tv365.R;
import com.example.tv365.model.Employer;
import java.util.ArrayList;

public class CandidateTopEmployerAdapter extends RecyclerView.Adapter<CandidateTopEmployerAdapter.TopEmployerViewHolder> {

    private ViewPager2 viewPager2;
    private ArrayList<Employer> employerArrayList;

    public CandidateTopEmployerAdapter(ViewPager2 viewPager2, ArrayList<Employer> employerArrayList) {
        this.viewPager2 = viewPager2;
        this.employerArrayList = employerArrayList;
    }

    @NonNull
    @Override
    public TopEmployerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_candidate_top_employer, parent, false);
        /*view.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));*/
        RecyclerView.LayoutParams lp = new RecyclerView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        view.setLayoutParams(lp);
        return new TopEmployerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TopEmployerViewHolder holder, int position) {
        Employer employer = employerArrayList.get(position);
        if (employer == null){
            return;
        }
        holder.tvEmployerName.setText(employer.getEmpName());

        if (position == employerArrayList.size() - 2){
            viewPager2.post(runnable);
        }
    }

    @Override
    public int getItemCount() {
        if (employerArrayList != null){
            return employerArrayList.size();
        }
        return 0;
    }

    public class TopEmployerViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgEmployerLogo;
        private TextView tvEmployerName;

        public TopEmployerViewHolder(@NonNull View itemView) {
            super(itemView);

            imgEmployerLogo = itemView.findViewById(R.id.imgEmployerLogo);
            tvEmployerName = itemView.findViewById(R.id.tvEmployerName);
        }
    }

    private Runnable runnable = new Runnable() {
        @Override
        public void run() {
            employerArrayList.addAll(employerArrayList);
            notifyDataSetChanged();
        }
    };
}
