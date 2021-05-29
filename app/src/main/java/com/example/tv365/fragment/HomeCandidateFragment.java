package com.example.tv365.fragment;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.core.widget.NestedScrollView;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tv365.R;
import com.example.tv365.adapter.CandidateDialogAdapter;
import com.example.tv365.adapter.itemClick.OnItemUserDrawClickListener;
import com.example.tv365.view.CandidateSearchActivity;
import com.example.tv365.view.MainActivity;
import com.example.tv365.view.NotificationManagementActivity;
import com.example.tv365.view.OnlineSupportActivity;
import com.example.tv365.view.TermsOfUseActivity;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class HomeCandidateFragment extends Fragment implements OnItemUserDrawClickListener {
    private View view;
    private CircleImageView civCandidateAvatar;
    private DrawerLayout drawerLayout;
    private RecyclerView recyclerviewDialogCandidate;
    private CandidateDialogAdapter candidateDialogAdapter;
    private List<String> stringList;
    private TextView tvLogout;
    private TextView tvCancel;
    private ImageView imgSearchHome;
    private CardView cardView;
    private NestedScrollView nestedScrollView;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_home_candidate, container, false);

        mapping();
        initView();
        eventClick();
        return view;
    }

    private void initView() {
        //replaceFragment(new HomeCandidateFragment());

        //final ExtendedFloatingActionButton extendedFloatingActionButton = view.findViewById(R.id.extendedFloatingActionButton);
//        extendedFloatingActionButton.extend();




        nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() {
            @Override
            public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
                // the delay of the extension of the FAB is set for 12 items
                if (scrollY > oldScrollY) {
                    //extendedFloatingActionButton.show();
                    cardView.setVisibility(View.GONE);
                    imgSearchHome.setVisibility(View.VISIBLE);
                } else {
                    //extendedFloatingActionButton.hide();
                    cardView.setVisibility(View.VISIBLE);
                    imgSearchHome.setVisibility(View.GONE);
                }

//                // the delay of the extension of the FAB is set for 12 items
//                if (scrollY < oldScrollY - 12 && !extendedFloatingActionButton.isShown()) {
//                    extendedFloatingActionButton.show();
//                }
//
//                // if the nestedScrollView is at the first item of the list then the
//                // floating action should be in show state
//                if (scrollY == 0) {
//                    extendedFloatingActionButton.show();
//                }
            }
        });

        stringList = new ArrayList<>();
        stringList.add("Trang chủ");
        stringList.add("Quản lý thông báo");
        stringList.add("Hỗ trợ trực tuyến");
        stringList.add("Thỏa thuận sử dụng");

        candidateDialogAdapter = new CandidateDialogAdapter(getActivity(), stringList, this);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), RecyclerView.VERTICAL, false);
        recyclerviewDialogCandidate.setLayoutManager(linearLayoutManager);
        recyclerviewDialogCandidate.setAdapter(candidateDialogAdapter);
    }

    private void eventClick() {
        civCandidateAvatar.setOnClickListener(new View.OnClickListener() {
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

        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CandidateSearchActivity.class));
            }
        });

        imgSearchHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CandidateSearchActivity.class));
            }
        });

    }

    private void mapping() {
        civCandidateAvatar = view.findViewById(R.id.civCandidateAvatar);
        recyclerviewDialogCandidate = view.findViewById(R.id.recyclerviewDialogCandidate);
        drawerLayout = view.findViewById(R.id.drawer_layout);
        tvLogout = view.findViewById(R.id.tvLogout);
        tvCancel = view.findViewById(R.id.tvCancel);
        imgSearchHome = view.findViewById(R.id.imgSearchHome);
        cardView = view.findViewById(R.id.cardViewHome);
        nestedScrollView = view.findViewById(R.id.nestedScrollViewHome);
    }

    private void replaceFragment(Fragment fragment){
        FragmentTransaction fragmentTransaction = getActivity().getSupportFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.content_frame, fragment);
        fragmentTransaction.commit();
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
