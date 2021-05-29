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
import com.example.tv365.model.CandidateNews;

import java.util.ArrayList;

public class CandidateNewsBannerAdapter extends RecyclerView.Adapter<CandidateNewsBannerAdapter.RNViewHolder> {

    private Context context;
    private ArrayList<CandidateNews> candidateNewsArrayList;

    public CandidateNewsBannerAdapter(Context context, ArrayList<CandidateNews> candidateNewsArrayList) {
        this.context = context;
        this.candidateNewsArrayList = candidateNewsArrayList;
    }

    @NonNull
    @Override
    public RNViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_candidate_news_banner, parent, false);

        return new RNViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RNViewHolder holder, int position) {
        CandidateNews candidateNews = candidateNewsArrayList.get(position);
        if (candidateNews == null){
            return;
        }
        holder.tvTitle1.setText(candidateNews.getRnTitle1());
        holder.tvTitle2.setText(candidateNews.getRnTitle2());
        holder.tvJobPositionRN.setText(candidateNews.getRnJobPosition());
        holder.tvJobNumber.setText(candidateNews.getRnJobNumber());

    }

    @Override
    public int getItemCount() {
        if (candidateNewsArrayList != null){
            return candidateNewsArrayList.size();
        }
        return 0;
    }

    class RNViewHolder extends RecyclerView.ViewHolder {

        private TextView tvTitle1;
        private TextView tvTitle2;
        private ImageView imgRNBanner;
        private TextView tvJobPositionRN;
        private TextView tvJobNumber;

        RNViewHolder(@NonNull View itemView) {
            super(itemView);

            tvTitle1 = itemView.findViewById(R.id.tvTitleRNBanner);
            tvTitle2 = itemView.findViewById(R.id.tvTitleRNBanner1);
            imgRNBanner = itemView.findViewById(R.id.imgRNBanner);
            tvJobPositionRN = itemView.findViewById(R.id.tvJobPositionRN);
            tvJobNumber = itemView.findViewById(R.id.tvJobNumber);
        }
    }
}
