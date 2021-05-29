package com.example.tv365.Recruiters.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tv365.R;
import com.example.tv365.Recruiters.activity.Recruiters_Search_Activity;
import com.example.tv365.Recruiters.adapter.CandidateViewMultiplle_Adapter;
import com.example.tv365.Recruiters.adapter.HighLightsCandidate_Adapter;
import com.example.tv365.Recruiters.adapter.LastestNews_Adapter;
import com.example.tv365.Recruiters.adapter.NewsCandidate_Adapter;
import com.example.tv365.Recruiters.model.CandidateViewMultiple;
import com.example.tv365.Recruiters.model.LastestNews;
import com.example.tv365.Recruiters.model.NewsCandidate;
import com.example.tv365.adapter.CandidateDialogAdapter;
import com.example.tv365.adapter.itemClick.OnItemUserDrawClickListener;
import com.example.tv365.view.NotificationManagementActivity;
import com.example.tv365.view.OnlineSupportActivity;
import com.example.tv365.view.TermsOfUseActivity;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeRecruiters_Fragment extends Fragment implements View.OnClickListener, OnItemUserDrawClickListener {
    private View view;
    private CardView cvSearch;
    private RecyclerView rcNewCandidate, rcCandiHighlights, rcCandiViewMultiple, rcListLatestNews;
    private List<NewsCandidate> newsCandidateList;
    private List<NewsCandidate> canHighlightsList;
    private List<CandidateViewMultiple> candidateViewMultipleList;
    private List<LastestNews> lastestNewsList;
    private CandidateViewMultiplle_Adapter candiViewMultipleAdapter;
    private NewsCandidate_Adapter newCandiadapter;
    private HighLightsCandidate_Adapter candiHighlightsadapter;
    private LastestNews_Adapter lastestNewsAdapter;

    private CircleImageView circleImageView;
    private DrawerLayout drawerLayout;
    private RecyclerView recyclerviewDialogRecruiters;
    private CandidateDialogAdapter recruitersDialogAdapter;
    private List<String> stringList;
    private TextView tvLogout;
    private TextView tvCancel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(inflater.getContext()).inflate(R.layout.home_recruiters, container, false);

        initView();

        stringList = new ArrayList<>();
        stringList.add("Trang chủ");
        stringList.add("Quản lý thông báo");
        stringList.add("Hỗ trợ trực tuyến");
        stringList.add("Thỏa thuận sử dụng");

        recruitersDialogAdapter = new CandidateDialogAdapter(getActivity(), stringList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        recyclerviewDialogRecruiters.setLayoutManager(linearLayoutManager);
        recyclerviewDialogRecruiters.setAdapter(recruitersDialogAdapter);
        eventClick();

        RecyListNewsCandidate();
        RecyListCandidateHighlights();
        RecyCandidateViewMultiple();
        RecyListLastestNews();

        cvSearch.setOnClickListener(this);


        return view;
    }

    private void eventClick() {
        circleImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                candidateDialog = new CandidateDialog(getActivity());
//                candidateDialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
//                candidateDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
//                candidateDialog.show();
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });


    }

    private void RecyListLastestNews() {
        lastestNewsList = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            lastestNewsList.add(new LastestNews());
        }
        lastestNewsAdapter = new LastestNews_Adapter(getContext(), lastestNewsList);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        rcListLatestNews.setAdapter(lastestNewsAdapter);
        rcListLatestNews.setLayoutManager(linearLayoutManager);

    }

    private void RecyCandidateViewMultiple() {
        candidateViewMultipleList = new ArrayList<>();
        //Tự phát sinh 6 dữ liệu mẫu
        for (int i = 0; i <= 5; i++) {
            candidateViewMultipleList.add(new CandidateViewMultiple());
        }

        candiViewMultipleAdapter = new CandidateViewMultiplle_Adapter(getContext(), candidateViewMultipleList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        rcCandiViewMultiple.setAdapter(candiViewMultipleAdapter);
        rcCandiViewMultiple.setLayoutManager(linearLayoutManager);

    }

    private void RecyListCandidateHighlights() {
        canHighlightsList = new ArrayList<>();
        //Tự phát sinh 6 dữ liệu mẫu
        for (int i = 0; i <= 5; i++) {
            canHighlightsList.add(new NewsCandidate());
        }

        candiHighlightsadapter = new HighLightsCandidate_Adapter(getContext(), canHighlightsList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        rcCandiHighlights.setAdapter(candiHighlightsadapter);
        rcCandiHighlights.setLayoutManager(linearLayoutManager);
    }

    private void RecyListNewsCandidate() {
        newsCandidateList = new ArrayList<NewsCandidate>();
        //Tự phát sinh 6 dữ liệu mẫu
        for (int i = 0; i <= 5; i++) {
            newsCandidateList.add(new NewsCandidate());
        }

        newCandiadapter = new NewsCandidate_Adapter(getContext(), newsCandidateList);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);

        rcNewCandidate.setAdapter(newCandiadapter);
        rcNewCandidate.setLayoutManager(linearLayoutManager);
    }

    private void initView() {
        rcNewCandidate = view.findViewById(R.id.rcNewCandidate_HomeRecruiters);
        rcCandiHighlights = view.findViewById(R.id.rcCandidateHighlights_HomeRecruiters);
        rcCandiViewMultiple = view.findViewById(R.id.rcCandidateViewMultiple_HomeRecruiters);
        rcListLatestNews = view.findViewById(R.id.rcListLatestNews_HomeRecruiters);
        cvSearch = view.findViewById(R.id.cvSearch_HomeRecruiters);

        circleImageView = view.findViewById(R.id.cImgAvatar_HomeRecruiters);
        drawerLayout = view.findViewById(R.id.drawerlayout_HomeRecruiters);
        recyclerviewDialogRecruiters = view.findViewById(R.id.recyclerviewDialogRecruiters);
        tvLogout = view.findViewById(R.id.tvLogout_HomeRecruiters);
        tvCancel = view.findViewById(R.id.tvCancel_HomeRecruiters);

    }

    @Override
    public void onClick(View v) {
        if (cvSearch.getId() == v.getId()) {
            startActivity(new Intent(getContext(), Recruiters_Search_Activity.class));
        }
    }

    @Override
    public void onItemUserDrawClick(int position) {
        switch (position){
            case 0:
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case 1:
                Intent intent0 = new Intent(getActivity(), NotificationManagementActivity.class);
                startActivity(intent0);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case 2:
                Intent intent1 = new Intent(getActivity(), OnlineSupportActivity.class);
                startActivity(intent1);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
            case 3:
                Intent intent2 = new Intent(getActivity(), TermsOfUseActivity.class);
                startActivity(intent2);
                drawerLayout.closeDrawer(GravityCompat.START);
                break;
        }
    }
}


