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
import com.example.tv365.Recruiters.model.RecruitmentNews;

import java.util.List;

public class RecruimentNews_Adapter extends RecyclerView.Adapter<RecruimentNews_Adapter.ViewHolder> {
    private Context context;
    private List<RecruitmentNews> recruitmentNewsList;

    public RecruimentNews_Adapter(Context context, List<RecruitmentNews> recruitmentNewsList) {
        this.context = context;
        this.recruitmentNewsList = recruitmentNewsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recruiment_news_manage, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //ớ trả kết quả nhé!
    }

    @Override
    public int getItemCount() {
        return recruitmentNewsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgAvatar;
        private TextView tvTitleRecrui, tvNUmberOfApply, tvAddress, tvSalary, tvView, tvUpdate_Date;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgAvatar = itemView.findViewById(R.id.imgAvatar_ItemRecruimentNewsManage);
            tvTitleRecrui = itemView.findViewById(R.id.tvTitleRecrui_ItemRecruimentNewsManage);
            tvNUmberOfApply = itemView.findViewById(R.id.tvNumberOfApply_ItemRecruimentNewsManage);
            tvAddress = itemView.findViewById(R.id.tvAddress_ItemRecruimentNewsManage);
            tvSalary = itemView.findViewById(R.id.tvSalary_ItemRecruimentNewsManage);
            tvView = itemView.findViewById(R.id.tvView_ItemRecruimentNewsManage);
            tvUpdate_Date = itemView.findViewById(R.id.tvUpdateDate_ItemRecruimentNewsManage);
        }
    }
}
