package com.example.tv365.Recruiters.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tv365.R;
import com.example.tv365.Recruiters.model.NewsCandidate;

import java.util.List;

public class CandidateSeen_Adapter extends RecyclerView.Adapter<CandidateSeen_Adapter.ViewHolder>{
    private Context context;
    private List<NewsCandidate> candidateListSeen;

    public CandidateSeen_Adapter(Context context, List<NewsCandidate> candidateListSeen) {
        this.context = context;
        this.candidateListSeen = candidateListSeen;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_view_candidate, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // nhớ trả kết quả nhé bạn

    }

    @Override
    public int getItemCount() {
        return candidateListSeen.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgAvatar;
        private TextView tvName, tvCareer, tvSalary, tvView, tvAddress;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAvatar = itemView.findViewById(R.id.imgAvatar_ItemViewCandidate);
            tvName = itemView.findViewById(R.id.tvName_ItemViewCandidate);
            tvCareer = itemView.findViewById(R.id.tvCareer_ItemViewCandidate);
            tvSalary = itemView.findViewById(R.id.tvSalary_ItemSaveCandidate);
            tvView = itemView.findViewById(R.id.tvView_ItemViewCandidate);
            tvAddress = itemView.findViewById(R.id.tvAddress_ItemViewCandidate);
        }
    }
}
