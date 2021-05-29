package com.example.tv365.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tv365.R;
import com.example.tv365.adapter.ChooseCityAdapter;
import com.example.tv365.adapter.itemClick.CityItemClick;
import com.example.tv365.adapter.itemClick.ItemClick;
import com.example.tv365.model.init.City.CityDistrictInfo;

public class SelectCityFragment extends Fragment {

    private View rootView;

    private ItemClick itemClick;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_select_city, container, false);

        RecyclerView recyclerView = rootView.findViewById(R.id.city_card_container);
        ChooseCityAdapter chooseCityAdapter = new ChooseCityAdapter(getActivity());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(chooseCityAdapter);

        chooseCityAdapter.setOnItemClick(new CityItemClick() {
            @Override
            public void onClick(CityDistrictInfo cityDistrictInfo) {

            }
        });


        return rootView;
    }

    public void setItemClick(ItemClick i){
        this.itemClick = i;
    }
}
