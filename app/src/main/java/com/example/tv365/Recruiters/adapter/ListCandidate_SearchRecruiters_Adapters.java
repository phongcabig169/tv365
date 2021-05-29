package com.example.tv365.Recruiters.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.example.tv365.R;
import com.example.tv365.Recruiters.activity.CandidateDetails;
import com.example.tv365.Recruiters.model.NewsCandidate;

import java.util.List;

public class ListCandidate_SearchRecruiters_Adapters extends BaseAdapter {
    private Context context;
    private List<NewsCandidate> candidateListSearch;

    public ListCandidate_SearchRecruiters_Adapters(Context context, List<NewsCandidate> candidateListSearch) {
        this.context = context;
        this.candidateListSearch = candidateListSearch;
    }

    @Override
    public int getCount() {
        return candidateListSearch.size();
    }

    @Override
    public NewsCandidate getItem(int position) {
        return candidateListSearch.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null){
            convertView = LayoutInflater.from(context).inflate(R.layout.item_candidate_highlights, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.imgAvatar = convertView.findViewById(R.id.imgAvatar_ItemCandidateHighlights);
            viewHolder.tvName = convertView.findViewById(R.id.tvName_ItemCandidateHighlights);
            viewHolder.tvCareer = convertView.findViewById(R.id.tvCareer_ItemCandidateHighlights);
            viewHolder.tvSalary = convertView.findViewById(R.id.tvSalary_ItemCandidateHighlights);
            viewHolder.tvView = convertView.findViewById(R.id.tvView_ItemCandidateHighlights);
            viewHolder.tvAddress = convertView.findViewById(R.id.tvAddress_ItemCandidateHighlights);
            viewHolder.linearLayout = convertView.findViewById(R.id.llLayout_ItemCandidateHighlights);

            convertView.setTag(viewHolder);
        }else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //nhớ trả kết quả nhé bạn
        viewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                context.startActivity(new Intent(context, CandidateDetails.class));
            }
        });

        return convertView;
    }

   private class ViewHolder{
       private ImageView imgAvatar;
       private TextView tvName, tvCareer, tvSalary, tvView, tvAddress;
       private LinearLayout linearLayout;
   }

}
