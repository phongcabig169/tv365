package com.example.tv365.Recruiters.fragment;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.example.tv365.R;
import com.example.tv365.Recruiters.activity.ChangePass_Recruiters;
import com.example.tv365.Recruiters.activity.Manage_RecruimentNews;
import com.example.tv365.Recruiters.activity.Update_Reference_Person_Recruiters;
import com.example.tv365.Recruiters.activity.Updated_Company_Info;

import java.io.InputStream;

public class RecruitersProfile_Fragment extends Fragment implements View.OnClickListener {
    private View view;
    private ImageView imgAvatar;
    private Button btnChangePass, btnRecruitmentManage, btnEditReferePerson, btnEditCompanyInfo;
    private Intent intent;
    private Bitmap bitmap;
    private static final int REQUEST_ID_READ_WRITE_PERMISSION = 99;
    private static final int REQUEST_ID_IMAGE_CAPTURE = 100;
    private static final int REQUEST_CHOOSE_PHOTO = 123;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = LayoutInflater.from(inflater.getContext()).inflate(R.layout.recruiters_profile, container, false);
        initView();

        imgAvatar.setOnClickListener(this);
        btnChangePass.setOnClickListener(this);
        btnRecruitmentManage.setOnClickListener(this);
        btnEditCompanyInfo.setOnClickListener(this);
        btnEditReferePerson.setOnClickListener(this);


        return view;
    }

    private void initView() {
        imgAvatar = view.findViewById(R.id.imgProfile_RecruitersPfofile);
        btnChangePass = view.findViewById(R.id.btnChangePass_RecruitersProfiles);
        btnRecruitmentManage = view.findViewById(R.id.btnRecruitmentManage_RecruitersProfiles);
        btnEditCompanyInfo = view.findViewById(R.id.btnEditCompanyInfo_RecruitersProfile);
        btnEditReferePerson = view.findViewById(R.id.btnReferePersonEdit_RecruitersProfile);

    }

    @Override
    public void onClick(View v) {
        if (imgAvatar.getId() == v.getId()) {
            verifyPermissions();
        } else if (btnRecruitmentManage.getId() == v.getId()) {
            startActivity(new Intent(getActivity(), Manage_RecruimentNews.class));
        } else if (btnChangePass.getId() == v.getId()) {
            startActivity(new Intent(getActivity(), ChangePass_Recruiters.class));
        } else if (btnEditCompanyInfo.getId() == v.getId()) {
            startActivity(new Intent(getActivity(), Updated_Company_Info.class));
        } else if (btnEditReferePerson.getId() == v.getId()) {
            startActivity(new Intent(getActivity(), Update_Reference_Person_Recruiters.class));
        }
    }

    private boolean verifyPermissions() {
        String[] permissions = {Manifest.permission.READ_EXTERNAL_STORAGE,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.CAMERA};
        if (ContextCompat.checkSelfPermission(view.getContext(),
                permissions[0]) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(view.getContext(),
                permissions[1]) == PackageManager.PERMISSION_GRANTED
                && ContextCompat.checkSelfPermission(view.getContext(),
                permissions[2]) == PackageManager.PERMISSION_GRANTED) {
            choosePhotoOrCamera();
        } else {
            ActivityCompat.requestPermissions(getActivity(),
                    permissions,
                    REQUEST_ID_READ_WRITE_PERMISSION);
        }
        return false;
    }

    private void choosePhotoOrCamera() {
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_choose_photo_or_gallery, null);
        builder.setView(dialogView);
        Button btnCamera = dialogView.findViewById(R.id.btnCamera_ChoosePhotoOrGallery);
        Button btnGallery = dialogView.findViewById(R.id.btnGallery_ChoosePhotoOrGallery);

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

        btnCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cameraNow();
                alertDialog.cancel();
            }
        });
        btnGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                choosePhoto();
                alertDialog.cancel();
            }
        });
    }

    private void cameraNow() {
        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, REQUEST_ID_IMAGE_CAPTURE);
    }

    private void choosePhoto() {
        intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, REQUEST_CHOOSE_PHOTO);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == getActivity().RESULT_OK) {
            if (requestCode == REQUEST_CHOOSE_PHOTO) {
                try {
                    Uri imgUri = data.getData();
                    InputStream is = getContext().getContentResolver().openInputStream(imgUri);
                    bitmap = BitmapFactory.decodeStream(is);
                    imgAvatar.setImageBitmap(bitmap);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (requestCode == REQUEST_ID_IMAGE_CAPTURE) {
                bitmap = (Bitmap) data.getExtras().get("data");
                imgAvatar.setImageBitmap(bitmap);
            }
        }
    }
}
