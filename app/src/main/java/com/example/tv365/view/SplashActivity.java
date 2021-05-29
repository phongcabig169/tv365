package com.example.tv365.view;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tv365.R;
import com.example.tv365.config.ConfigRetrofitApi;
import com.example.tv365.config.InterfaceAPI;
import com.example.tv365.model.init.AcademiRank.AcademiRankData;
import com.example.tv365.model.init.AcademiRank.AcademicRank;
import com.example.tv365.model.init.Cate.Cate;
import com.example.tv365.model.init.Cate.CateInfo;
import com.example.tv365.model.init.Cate.ComCate;
import com.example.tv365.model.init.Cate.ComCateData;
import com.example.tv365.model.init.City.City;
import com.example.tv365.model.init.City.CityDistrict;
import com.example.tv365.model.init.City.CityDistrictInfo;
import com.example.tv365.model.init.ComSize.ComSize;
import com.example.tv365.model.init.Degree.Degree;
import com.example.tv365.model.init.Exp.ComExp;
import com.example.tv365.model.init.Exp.Exp;
import com.example.tv365.model.init.Gender.Gender;
import com.example.tv365.model.init.Language.Language;
import com.example.tv365.model.init.MarriedStatus.MarriedStatus;
import com.example.tv365.model.init.Rank.Rank;
import com.example.tv365.model.init.Salary.Salary;
import com.example.tv365.model.init.Tags.Tags;
import com.example.tv365.model.init.WorkType.WorkType;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class SplashActivity extends AppCompatActivity {

    private ImageView imageView;

    private List<CityDistrictInfo> listCD = new ArrayList<>();

    public TextView txtDotLoad;

    private List<City> lsCity = new ArrayList<>();

    private List<CityDistrictInfo> lsCD = new ArrayList<>();

    public final static String SHARED_SPLASH = "this is shared pref splash";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        imageView = this.findViewById(R.id.img_splash);
        txtDotLoad = this.findViewById(R.id.txt_loading_dot);

        RotateAnimation rotate = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotate.setDuration(1200);
        rotate.setRepeatCount(Animation.INFINITE);
        rotate.setInterpolator(new LinearInterpolator());

        imageView.startAnimation(rotate);

        new SplashAsyntask().execute();
    }


    public class SplashAsyntask extends AsyncTask<String , Integer, String>{

        @Override
        protected String doInBackground(String... strings) {
            getGender();
            getDegree();
            getCityDistrict("0");
            getExp();
            getRank();
            getCate();
            getComCate();
            getMarriedStatus();
            getComExp();
            getTags("1");
            getAcademicRank();
            getWorkType();
            getComSize();
            getLanguage();
            getSalary();
            return null;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);

        }

        @Override
        protected void onPostExecute(String s) {
            Intent i = new Intent(SplashActivity.this,HomeLoginActivity.class);
            startActivity(i);
            SplashActivity.this.finish();
            super.onPostExecute(s);
        }
    }

    // get city
    private void getCityDistrict(String id){
        List<CityDistrictInfo> cdList = new ArrayList<>();
        Retrofit retrofit = ConfigRetrofitApi.getInstance();
        retrofit.create(InterfaceAPI.class)
                .getCity(id)
                .enqueue(new Callback<CityDistrict>() {
                    @Override
                    public void onResponse(Call<CityDistrict> call, Response<CityDistrict> response) {
                        if (response.body().getData() != null) {
                            CityDistrict cd = response.body();
                            cdList.addAll(cd.getData().getQuanhuyen());
                            addToSharedPref("city", cdList);
                            Log.d("TAG", "Quan huyen: " + cdList.get(1).getCitId());
                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<CityDistrict> call, Throwable t) {
                        Toast.makeText(SplashActivity.this, "Lỗi mạng hoặc lỗi hệ thống",
                                Toast.LENGTH_LONG).show();
                        Log.e("aab", t.getMessage());
                    }
                });
    }

    //Api gioi tinh
    private void getGender(){
        Retrofit retrofit = ConfigRetrofitApi.getInstance();
        retrofit.create(InterfaceAPI.class)
                .getGender()
                .enqueue(new Callback<Gender>() {
                    @Override
                    public void onResponse(Call<Gender> call, Response<Gender> response) {
                        if (response.body().getData() != null) {
                            Gender gender = response.body();
                            Log.d("TAG", "Gioi tinh: "+gender.getData().getGioitinh().get2());
                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<Gender> call, Throwable t) {
                        Toast.makeText(SplashActivity.this, "Lỗi mạng hoặc lỗi hệ thống",
                                Toast.LENGTH_LONG).show();
                        Log.e("aab", t.getMessage());
                    }
                });
    }

    // api bang cap
    private void getDegree(){
        Retrofit retrofit = ConfigRetrofitApi.getInstance();
        retrofit.create(InterfaceAPI.class)
                .getDegree()
                .enqueue(new Callback<Degree>() {
                    @Override
                    public void onResponse(Call<Degree> call, Response<Degree> response) {
                        if (response.body().getData() != null) {
                            Degree degree = response.body();
                            Log.d("TAG", "Bang cap: "+ degree.getData().getBangcap().get2());
                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<Degree> call, Throwable t) {
                        Toast.makeText(SplashActivity.this, "Lỗi mạng hoặc lỗi hệ thống",
                                Toast.LENGTH_LONG).show();
                        Log.e("aab", t.getMessage());
                    }
                });
    }

    //kinh nghiệm
    private void getExp(){
        Retrofit retrofit = ConfigRetrofitApi.getInstance();
        retrofit.create(InterfaceAPI.class)
                .getExp()
                .enqueue(new Callback<Exp>() {
                    @Override
                    public void onResponse(Call<Exp> call, Response<Exp> response) {
                        if (response.body().getData() != null) {
                            Exp cd = response.body();
                            Log.d("TAG", "Kinh nghiem" + cd.getData().getKinhnghiem().get(1));
                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<Exp> call, Throwable t) {
                        Toast.makeText(SplashActivity.this, "Lỗi mạng hoặc lỗi hệ thống",
                                Toast.LENGTH_LONG).show();
                        Log.e("aab", t.getMessage());
                    }
                });
    }
    //Cấp bậc
    private void getRank(){
        Retrofit retrofit = ConfigRetrofitApi.getInstance();
        retrofit.create(InterfaceAPI.class)
                .getRank()
                .enqueue(new Callback<Rank>() {
                    @Override
                    public void onResponse(Call<Rank> call, Response<Rank> response) {
                        if (response.body().getData() != null) {
                            Rank cd = response.body();
                            Log.d("TAG", "cấp bậc" + cd.getData().getCapbac().get(1));
                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<Rank> call, Throwable t) {
                        Toast.makeText(SplashActivity.this, "Lỗi mạng hoặc lỗi hệ thống",
                                Toast.LENGTH_LONG).show();
                        Log.e("aab", t.getMessage());
                    }
                });
    }

    //ngành nghề
    private void getCate(){
        Retrofit retrofit = ConfigRetrofitApi.getInstance();
        retrofit.create(InterfaceAPI.class)
                .getCate()
                .enqueue(new Callback<Cate>() {
                    @Override
                    public void onResponse(Call<Cate> call, Response<Cate> response) {
                        if (response.body().getData() != null) {
                            Cate cd = response.body();

                            CateInfo cateInfo= cd.getData().getCate().get(1);
                            Log.d("TAG", "ID/Cate: " + cateInfo.getCatId() + "/" + cateInfo.getCatName());
                            addToSharedPref("cate", cd.getData().getCate());

                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<Cate> call, Throwable t) {
                        Toast.makeText(SplashActivity.this, "Lỗi mạng hoặc lỗi hệ thống",
                                Toast.LENGTH_LONG).show();
                        Log.e("aab", t.getMessage());
                    }
                });
    }

    //ngành nghề yêu cầu
    private void getComCate(){
        Retrofit retrofit = ConfigRetrofitApi.getInstance();
        retrofit.create(InterfaceAPI.class)
                .getCateCom()
                .enqueue(new Callback<ComCate>() {
                    @Override
                    public void onResponse(Call<ComCate> call, Response<ComCate> response) {
                        if (response.body().getData() != null) {
                            ComCate cd = response.body();
                            ComCateData cdData = cd.getData();
                            Log.d("TAG", "ID/ComCate: " + cdData.getLinhvuc().get(1).getCateId() + "/" + cdData.getLinhvuc().get(1).getCateName());
                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<ComCate> call, Throwable t) {
                        Toast.makeText(SplashActivity.this, "Lỗi mạng hoặc lỗi hệ thống",
                                Toast.LENGTH_LONG).show();
                        Log.e("aab", t.getMessage());
                    }
                });
    }

    //yêu cầu kinh nghiem
    private void getComExp(){
        Retrofit retrofit = ConfigRetrofitApi.getInstance();
        retrofit.create(InterfaceAPI.class)
                .getExpCom()
                .enqueue(new Callback<ComExp>() {
                    @Override
                    public void onResponse(Call<ComExp> call, Response<ComExp> response) {
                        if (response.body().getData() != null) {
                            ComExp comExp = response.body();
                            Log.d("TAG", "Kinh nghiem yeu cau: " + comExp.getData().getKinhnghiemCom().get(1));
                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<ComExp> call, Throwable t) {
                        Toast.makeText(SplashActivity.this, "Lỗi mạng hoặc lỗi hệ thống",
                                Toast.LENGTH_LONG).show();
                        Log.e("aab", t.getMessage());
                    }
                });
    }

    //hon nhan
    private void getMarriedStatus(){
        Retrofit retrofit = ConfigRetrofitApi.getInstance();
        retrofit.create(InterfaceAPI.class)
                .getMarriedStatus()
                .enqueue(new Callback<MarriedStatus>() {
                    @Override
                    public void onResponse(Call<MarriedStatus> call, Response<MarriedStatus> response) {
                        if (response.body().getData() != null) {
                            MarriedStatus comExp = response.body();
                            Log.d("TAG", "Hon nhan: " + comExp.getData().getHonnhan().get1());
                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<MarriedStatus> call, Throwable t) {
                        Toast.makeText(SplashActivity.this, "Lỗi mạng hoặc lỗi hệ thống",
                                Toast.LENGTH_LONG).show();
                        Log.e("aab", t.getMessage());
                    }
                });
    }

    //hinh thuc lam viec
    private void getWorkType(){
        Retrofit retrofit = ConfigRetrofitApi.getInstance();
        retrofit.create(InterfaceAPI.class)
                .getWorkType()
                .enqueue(new Callback<WorkType>() {
                    @Override
                    public void onResponse(Call<WorkType> call, Response<WorkType> response) {
                        if (response.body().getData() != null) {
                            WorkType comExp = response.body();
                            Log.d("TAG", "Hinh thuc lam viec: " + comExp.getData().getHtlv().get(1));
                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<WorkType> call, Throwable t) {
                        Toast.makeText(SplashActivity.this, "Lỗi mạng hoặc lỗi hệ thống",
                                Toast.LENGTH_LONG).show();
                        Log.e("aab", t.getMessage());
                    }
                });
    }

    //Muc luong
    private void getSalary(){
        Retrofit retrofit = ConfigRetrofitApi.getInstance();
        retrofit.create(InterfaceAPI.class)
                .getSalary()
                .enqueue(new Callback<Salary>() {
                    @Override
                    public void onResponse(Call<Salary> call, Response<Salary> response) {
                        if (response.body().getData() != null) {
                            Salary comExp = response.body();
                            Log.d("TAG", "Muc luong 1: " + comExp.getData().getMucluong().get(1));
                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<Salary> call, Throwable t) {
                        Toast.makeText(SplashActivity.this, "Lỗi mạng hoặc lỗi hệ thống",
                                Toast.LENGTH_LONG).show();
                        Log.e("aab", t.getMessage());
                    }
                });
    }

    //Ngon ngu
    private void getLanguage(){
        Retrofit retrofit = ConfigRetrofitApi.getInstance();
        retrofit.create(InterfaceAPI.class)
                .getLanguage()
                .enqueue(new Callback<Language>() {
                    @Override
                    public void onResponse(Call<Language> call, Response<Language> response) {
                        if (response.body().getData() != null) {
                            Language comExp = response.body();
                            Log.d("TAG", "Ngon ngu 1: " + comExp.getData().getNgonngu().get(1));
                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<Language> call, Throwable t) {
                        Toast.makeText(SplashActivity.this, "Lỗi mạng hoặc lỗi hệ thống",
                                Toast.LENGTH_LONG).show();
                        Log.e("aab", t.getMessage());
                    }
                });
    }

    //Quy mo cong ty
    private void getComSize(){
        Retrofit retrofit = ConfigRetrofitApi.getInstance();
        retrofit.create(InterfaceAPI.class)
                .getComSize()
                .enqueue(new Callback<ComSize>() {
                    @Override
                    public void onResponse(Call<ComSize> call, Response<ComSize> response) {
                        if (response.body().getData() != null) {
                            ComSize comExp = response.body();
                            Log.d("TAG", "Ngon ngu 1: " + comExp.getData().getQuymo().get(1));
                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<ComSize> call, Throwable t) {
                        Toast.makeText(SplashActivity.this, "Lỗi mạng hoặc lỗi hệ thống",
                                Toast.LENGTH_LONG).show();
                        Log.e("aab", t.getMessage());
                    }
                });
    }


    //Tags
    private void getTags(String cate){
        Retrofit retrofit = ConfigRetrofitApi.getInstance();
        retrofit.create(InterfaceAPI.class)
                .getTags(cate)
                .enqueue(new Callback<Tags>() {
                    @Override
                    public void onResponse(Call<Tags> call, Response<Tags> response) {
                        if (response.body().getData() != null) {
                            Tags comExp = response.body();
                            Log.d("TAG", "Tags 1: " + comExp.getData().getTags().get(1).getTagName());
                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<Tags> call, Throwable t) {
                        Toast.makeText(SplashActivity.this, "Lỗi mạng hoặc lỗi hệ thống",
                                Toast.LENGTH_LONG).show();
                        Log.e("aab", t.getMessage());
                    }
                });
    }
    //Xep loai hoc luc
    private void getAcademicRank(){
        Retrofit retrofit = ConfigRetrofitApi.getInstance();
        retrofit.create(InterfaceAPI.class)
                .getAcademicRank()
                .enqueue(new Callback<AcademicRank>() {
                    @Override
                    public void onResponse(Call<AcademicRank> call, Response<AcademicRank> response) {
                        if (response.body().getData() != null) {
                            AcademicRank comExp = response.body();
                            Log.d("TAG", "Academic 1: " + comExp.getData().getXeploai().get(1));
                        } else {

                        }
                    }

                    @Override
                    public void onFailure(Call<AcademicRank> call, Throwable t) {
                        Toast.makeText(SplashActivity.this, "Lỗi mạng hoặc lỗi hệ thống",
                                Toast.LENGTH_LONG).show();
                        Log.e("aab", t.getMessage());
                    }
                });
    }

    private void addToSharedPref(String name, Object obj){
        SharedPreferences sharedPreferences = this.getSharedPreferences(SHARED_SPLASH, MODE_PRIVATE);
        Gson gson = new Gson();

        String json = gson.toJson(obj);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(name, json);
        editor.apply();
    }

}