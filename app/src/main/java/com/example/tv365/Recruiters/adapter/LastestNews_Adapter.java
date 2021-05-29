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
import com.example.tv365.Recruiters.model.LastestNews;

import java.util.List;

public class LastestNews_Adapter extends RecyclerView.Adapter<LastestNews_Adapter.ViewHolder> {
    private Context context;
    private List<LastestNews> lastestNewsList;

    public LastestNews_Adapter(Context context, List<LastestNews> lastestNewsList) {
        this.context = context;
        this.lastestNewsList = lastestNewsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_latestnews_recruiters, parent, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        //nhớ trả kết quả nhé

//        Picasso.get().load(lastestNewsList.get(position).getImgPosterNews()).into(holder.imgPosterNews);
//        holder.tvTitle.setText(lastestNewsList.get(position).getTitle());
//        holder.tvContent.setText(lastestNewsList.get(position).getContent());
//        holder.tvAuthor.setText(lastestNewsList.get(position).getAuthor());
//        holder.tvDateSubmit.setText(lastestNewsList.get(position).getDateSubmit());

    }

    @Override
    public int getItemCount() {
        return lastestNewsList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgPosterNews;
        private TextView tvTitle, tvContent, tvAuthor, tvDateSubmit;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            imgPosterNews = itemView.findViewById(R.id.imgPoster_ItemLatestNewsRecruiters);
            tvTitle = itemView.findViewById(R.id.tvTitle_ItemLatestNewsRecruiters);
            tvContent = itemView.findViewById(R.id.tvContent_ItemLatestNewsRecruiters);
            tvAuthor = itemView.findViewById(R.id.tvAuthor_ItemLatestNewsRecruiters);
            tvDateSubmit = itemView.findViewById(R.id.tvDateSubmit_ItemLatestNewsRecruiters);
        }
    }
}
