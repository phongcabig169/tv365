package com.example.tv365.fragment;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tv365.R;
import com.example.tv365.adapter.ChooseWorkPlaceAdapter;
import com.example.tv365.adapter.itemClick.ItemClick;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SelectWorkPlaceFragment extends Fragment {

    private View rootView;

    private ItemClick itemClick;

    private Button btnConfirm;

    private EditText editText;

    private ChooseWorkPlaceAdapter chooseWorkPlaceAdapter;

    private List<String> ls = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_select_workplace, container, false);

        btnConfirm = rootView.findViewById(R.id.btn_confirm);
        editText = rootView.findViewById(R.id.edit_search);

        ls.add("Hà Nội");
        ls.add("Hải Phòng");
        ls.add("TP.Hồ Chí Minh");
        ls.add("Bắc Giang");
        ls.add("Lạng Sơn");
        ls.add("Sài Gòn");
        ls.add("Huế");

        RecyclerView recyclerView = rootView.findViewById(R.id.workplace_card_container);
        chooseWorkPlaceAdapter = new ChooseWorkPlaceAdapter(getActivity(),ls);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(chooseWorkPlaceAdapter);

        editText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                SearchFilter searchFilter = new SearchFilter();
                searchFilter.filter(s);
            }
        });

        btnConfirm.setOnClickListener(v -> {
            List<String> list = chooseWorkPlaceAdapter.getChecked();

            if(list.size()!= 0 && list.size() < 4) {
                StringBuilder s = new StringBuilder();
                for(int i = 0; i < list.size(); i ++ ) {
                    s.append(list.get(i)).append(", ");
                }
                itemClick.onClick(s.substring(0, s.length()-2));
            }else if(list.size() > 4){
                Toast.makeText(getActivity(), "Chọn tối đa 3 mục", Toast.LENGTH_SHORT).show();
            }else if(list.size() == 0){
                Toast.makeText(getActivity(), "Hãy chọn nơi làm việc mong muốn của bạn", Toast.LENGTH_SHORT).show();
            }
        });

        return rootView;
    }

    public void setItemClick(ItemClick i){
        this.itemClick = i;
    }


    class SearchFilter extends Filter{

        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            constraint = constraint.toString().toLowerCase();
            FilterResults result = new FilterResults();
            ArrayList<String> f = new ArrayList<String>();
            ArrayList<String> p = new ArrayList<String>(ls);
            if(constraint != null && constraint.toString().length() > 0)
            {
                for(int i = 0; i < p.size(); i++)
                {
                    String product = p.get(i);
                    if(product.toLowerCase().contains(constraint))
                        f.add(product);
                }
                result.count = f.size();
                result.values = f;
            }
            else
            {
                result.values = p;
                result.count = p.size();
            }
            return result;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            List<String> s = new ArrayList<>();
            if(results!=null) {
                s.addAll((Collection<String>) results.values);
            }
            chooseWorkPlaceAdapter.setData(s);
        }
    }
}
