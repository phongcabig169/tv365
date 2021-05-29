package com.example.tv365.Recruiters.activity;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.tv365.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Create_RecruimentNews extends AppCompatActivity implements View.OnClickListener, AdapterView.OnItemSelectedListener {
    private EditText edtTitle, edtNumCandi, edtJobDes, edtJobReq, edtBenefit, edtRecords, edtDeadline, edtContactName, edtContactPhone, edtContactEmail, edtContactAddress;
    private Spinner spLevel, spCareer, spFormWork, spSalary, spExp, spEdu, spAddress, spGender;
    private Button btnUpdate;
    private ArrayAdapter<CharSequence> adapter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_recruites_news);

        initView();
        spinner();

        edtDeadline.setOnClickListener(this);

    }

    private void spinner() {
        //splevel
        adapter = ArrayAdapter.createFromResource(this, R.array.strLevel_CreateRecruiters, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spLevel.setAdapter(adapter);
        spLevel.setOnItemSelectedListener(this);
        //spCareer
        adapter = ArrayAdapter.createFromResource(this, R.array.strCareer_CreateRecruiters, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCareer.setAdapter(adapter);
        spCareer.setOnItemSelectedListener(this);
        //spFormWork
        adapter = ArrayAdapter.createFromResource(this, R.array.strFormWork_CreateRecruiters, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spFormWork.setAdapter(adapter);
        spFormWork.setOnItemSelectedListener(this);
        //spSalary
        adapter = ArrayAdapter.createFromResource(this, R.array.strSalary_CreateRecruiters, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spSalary.setAdapter(adapter);
        spSalary.setOnItemSelectedListener(this);
        //spExp
        adapter = ArrayAdapter.createFromResource(this, R.array.strExp_CreateRecruiters, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spExp.setAdapter(adapter);
        spExp.setOnItemSelectedListener(this);
        //spEdu
        adapter = ArrayAdapter.createFromResource(this, R.array.strEdu_CreateRecruiters, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spEdu.setAdapter(adapter);
        spEdu.setOnItemSelectedListener(this);
        //SpAddress
        adapter = ArrayAdapter.createFromResource(this, R.array.strAddress_CreateRecruiters, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spAddress.setAdapter(adapter);
        spAddress.setOnItemSelectedListener(this);
        //spGender
        adapter = ArrayAdapter.createFromResource(this, R.array.strGender_CreateRecruiters, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spGender.setAdapter(adapter);
        spGender.setOnItemSelectedListener(this);
    }

    private void initView() {
        edtTitle = findViewById(R.id.edtTitle_CreateRecruitersNews);
        edtNumCandi = findViewById(R.id.edtNumCandi_CreateRecruitersNews);
        edtJobDes = findViewById(R.id.edtJobDes_CreateRecruitersNews);
        edtJobReq = findViewById(R.id.edtJobReq_CreateRecruitersNews);
        edtBenefit = findViewById(R.id.edtBenefit_CreateRecruitersNews);
        edtRecords = findViewById(R.id.edtRecords_CreateRecruitersNews);
        edtDeadline = findViewById(R.id.edtDeadline_CreateRecruitersNews);
        edtContactName = findViewById(R.id.edtContactName_CreateRecruitersNews);
        edtContactPhone = findViewById(R.id.edtContactPhone_CreateRecruitersNews);
        edtContactEmail = findViewById(R.id.edtContactEmail_CreateRecruitersNews);
        edtContactAddress = findViewById(R.id.edtContactAddress_CreateRecruitersNews);
        spLevel = findViewById(R.id.spLevel_CreateRecruitersNews);
        spCareer = findViewById(R.id.spCareer_CreateRecruitersNews);
        spFormWork = findViewById(R.id.spFormWork_CreateRecruitersNews);
        spSalary = findViewById(R.id.spSalary_CreateRecruitersNews);
        spExp = findViewById(R.id.spExp_CreateRecruitersNews);
        spEdu = findViewById(R.id.spEdu_CreateRecruitersNews);
        spAddress = findViewById(R.id.spAddress_CreateRecruitersNews);
        spGender = findViewById(R.id.spGender_CreateRecruitersNews);

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//        String strText = parent.getItemAtPosition(position).toString();
//        Toast.makeText(this, strText, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    public void onClick(View v) {
        if (edtDeadline.getId() == v.getId()) {
            final Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            final int day = calendar.get(Calendar.DAY_OF_MONTH);
            DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
                @Override
                public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                    calendar.set(year, month, dayOfMonth);
                    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
                    edtDeadline.setText(simpleDateFormat.format(calendar.getTime()));
                }
            }, year, month, day);
            datePickerDialog.show();
        }
    }
}
