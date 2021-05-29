package com.example.tv365.Recruiters.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tv365.R;
import com.example.tv365.Recruiters.activity.CandidateDetails;
import com.example.tv365.Recruiters.model.CandidateViewMultiple;

import java.util.List;

public class CandidateViewMultiplle_Adapter extends RecyclerView.Adapter<CandidateViewMultiplle_Adapter.ViewHolder> {
    private Context context;
    private List<CandidateViewMultiple> candidateViewMultipleList;

    public CandidateViewMultiplle_Adapter(Context context, List<CandidateViewMultiple> candidateViewMultipleList) {
        this.context = context;
        this.candidateViewMultipleList = candidateViewMultipleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_candidate_view_multiple, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        // nhớ trả kết quả nhé
    }

    @Override
    public int getItemCount() {
        return candidateViewMultipleList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgAvatar;
        private ConstraintLayout constraintLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAvatar = itemView.findViewById(R.id.imgBgAvatar_ItemCandidateViewMultiple);
            constraintLayout = itemView.findViewById(R.id.ctLayout_ItemCandidateViewMultiple);

            constraintLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    context.startActivity(new Intent(context, CandidateDetails.class));
                }
            });

        }
    }
}
