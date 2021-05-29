package com.example.tv365.Recruiters.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tv365.R;
import com.example.tv365.Recruiters.activity.CandidateDetails;
import com.example.tv365.Recruiters.model.NewsCandidate;

import java.util.List;

public class NewsCandidate_Adapter extends RecyclerView.Adapter<NewsCandidate_Adapter.ViewHolder> {
    private Context context;
    private List<NewsCandidate> newsCandidateList;

    public NewsCandidate_Adapter(Context context, List<NewsCandidate> newsCandidateList) {
        this.context = context;
        this.newsCandidateList = newsCandidateList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_news_candidate, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //nhớ trả kết quả nhé
    }

    @Override
    public int getItemCount() {
        return newsCandidateList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgAvatar;
        private TextView tvName, tvCareer, tvSalary, tvView, tvAddress;
        private LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgAvatar = itemView.findViewById(R.id.imgAvatar_ItemNewsCandidate);
            tvName = itemView.findViewById(R.id.tvName_ItemNewsCandidate);
            tvCareer = itemView.findViewById(R.id.tvCareer_ItemNewsCandidate);
            tvSalary = itemView.findViewById(R.id.tvSalary_ItemNewsCandidate);
            tvView = itemView.findViewById(R.id.tvView_ItemNewsCandidate);
            tvAddress = itemView.findViewById(R.id.tvAddress_ItemNewsCandidate);
            linearLayout = itemView.findViewById(R.id.llLayout_ItemNewsCandidate);

            // set even onclick
            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, CandidateDetails.class));
                }
            });
        }
    }
}
