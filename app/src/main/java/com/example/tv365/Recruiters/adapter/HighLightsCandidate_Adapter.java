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

public class HighLightsCandidate_Adapter extends RecyclerView.Adapter<HighLightsCandidate_Adapter.ViewHolder> {
    private Context context;
    private List<NewsCandidate> candiHighlightsList;

    public HighLightsCandidate_Adapter(Context context, List<NewsCandidate> candiHighlightsList) {
        this.context = context;
        this.candiHighlightsList = candiHighlightsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_candidate_highlights, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // nhớ trả kết qảu nhé
    }

    @Override
    public int getItemCount() {
        return candiHighlightsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgAvatar;
        private TextView tvName, tvCareer, tvSalary, tvView, tvAddress;
        private LinearLayout linearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAvatar = itemView.findViewById(R.id.imgAvatar_ItemCandidateHighlights);
            tvName = itemView.findViewById(R.id.tvName_ItemCandidateHighlights);
            tvCareer = itemView.findViewById(R.id.tvCareer_ItemCandidateHighlights);
            tvSalary = itemView.findViewById(R.id.tvSalary_ItemCandidateHighlights);
            tvView = itemView.findViewById(R.id.tvView_ItemCandidateHighlights);
            tvAddress = itemView.findViewById(R.id.tvAddress_ItemCandidateHighlights);
            linearLayout = itemView.findViewById(R.id.llLayout_ItemCandidateHighlights);

            linearLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, CandidateDetails.class));
                }
            });
        }
    }
}
