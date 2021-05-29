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
import com.example.tv365.model.CandidateTypicalNews;

import java.util.ArrayList;

public class CandidateNewsTypicalAdapter extends RecyclerView.Adapter<CandidateNewsTypicalAdapter.CandidateTypicalNewsViewHolder> {

    private Context context;
    private ArrayList<CandidateTypicalNews> candidateNewsArrayList;

    public CandidateNewsTypicalAdapter(Context context, ArrayList<CandidateTypicalNews> candidateNewsArrayList) {
        this.context = context;
        this.candidateNewsArrayList = candidateNewsArrayList;
    }

    @NonNull
    @Override
    public CandidateTypicalNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_typical_news, parent, false);

        return new CandidateTypicalNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CandidateTypicalNewsViewHolder holder, int position) {
        CandidateTypicalNews candidateTypicalNews = candidateNewsArrayList.get(position);
        if (candidateTypicalNews == null){
            return;
        }
        holder.tvCandidateNameTN.setText(candidateTypicalNews.getCtnName());
        holder.tvContentTypicalNews.setText(candidateTypicalNews.getCtnContent());
        holder.tvTitleTypicalNews.setText(candidateTypicalNews.getCtnTitle());
        holder.tvTypicalNewsDate.setText(candidateTypicalNews.getCtnDate());
    }

    @Override
    public int getItemCount() {
        if (candidateNewsArrayList != null){
            return candidateNewsArrayList.size();
        }
        return 0;
    }

    class CandidateTypicalNewsViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgTypicalNews;
        private TextView tvTitleTypicalNews;
        private TextView tvContentTypicalNews;
        private TextView tvCandidateNameTN;
        private TextView tvTypicalNewsDate;

        CandidateTypicalNewsViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTypicalNews = itemView.findViewById(R.id.imgTypicalNews);
            tvTitleTypicalNews = itemView.findViewById(R.id.tvTitleTypicalNews);
            tvContentTypicalNews = itemView.findViewById(R.id.tvContentTypicalNews);
            tvCandidateNameTN = itemView.findViewById(R.id.tvCandidateNameTN);
            tvTypicalNewsDate = itemView.findViewById(R.id.tvTypicalNewsDate);
        }
    }
}
