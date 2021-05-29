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

public class CandidateNewsAdapter extends RecyclerView.Adapter<CandidateNewsAdapter.CandidateNewsViewHolder>{

    private Context context;
    private ArrayList<CandidateNews> candidateNewsArrayList;

    public CandidateNewsAdapter(Context context, ArrayList<CandidateNews> candidateNewsArrayList) {
        this.context = context;
        this.candidateNewsArrayList = candidateNewsArrayList;
    }

    @NonNull
    @Override
    public CandidateNewsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_typical_news, parent, false);

        return new CandidateNewsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CandidateNewsViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {

        return 0;
    }

    class CandidateNewsViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgTypicalNews;
        private TextView tvTitleTypicalNews;
        private TextView tvContentTypicalNews;
        private TextView tvCandidateNameTN;
        private TextView tvTypicalNewsDate;

        CandidateNewsViewHolder(@NonNull View itemView) {
            super(itemView);

            imgTypicalNews = itemView.findViewById(R.id.imgTypicalNews);
            tvTitleTypicalNews = itemView.findViewById(R.id.tvTitleTypicalNews);
            tvContentTypicalNews = itemView.findViewById(R.id.tvContentTypicalNews);
            tvCandidateNameTN = itemView.findViewById(R.id.tvCandidateNameTN);
            tvTypicalNewsDate = itemView.findViewById(R.id.tvTypicalNewsDate);
        }
    }
}
