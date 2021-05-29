package com.example.tv365.config;

import com.example.tv365.model.Login.LoginEmployer;
import com.example.tv365.model.Register.EmployerRegister;
import com.example.tv365.model.init.AcademiRank.AcademicRank;
import com.example.tv365.model.init.Cate.Cate;
import com.example.tv365.model.init.Cate.ComCate;
import com.example.tv365.model.init.City.CityDistrict;
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

import java.io.File;
import java.util.Map;
import retrofit2.Call;

import okhttp3.MultipartBody;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


/**
 * Created by Windows 10 Now on 11/16/2017.
 */

public interface InterfaceAPI {
    //api bằng cấp
    @GET("api_job/p_bangcap.php")
    Call<Degree> getDegree();

    //api cấp bậc
    @GET("api_job/p_capbac.php")
    Call<Rank> getRank();

    //aip Linh vuc tuyển dụng
    @GET("api_job/p_cate_com.php")
    Call<ComCate> getCateCom();

    //api ngành nghề
    @GET("api_job/p_cate.php")
    Call<Cate> getCate();

    //api tỉnh thành phố
    @FormUrlEncoded
    @POST("api_job/p_district.php")
    Call<CityDistrict> getCity(@Field("city") String id);

    //api yêu cầu kinh nghiệm
    @GET("api_job/p_exp_com.php")
    Call<ComExp> getExpCom();

    //api kinh nghiệm bản thân
    @GET("api_job/p_exp.php")
    Call<Exp> getExp();

    //api giới tính
    @GET("api_job/p_gioitinh.php")
    Call<Gender> getGender();

    //hôn nhân
    @GET("api_job/p_honnhan.php")
    Call<MarriedStatus> getMarriedStatus();

    //hình thức làm việc
    @GET("api_job/p_htlv.php")
    Call<WorkType> getWorkType();

    //api mức lương
    @GET("api_job/p_mucluong.php")
    Call<Salary> getSalary();

    //api ngôn ngữ
    @GET("api_job/p_ngonngu.php")
    Call<Language> getLanguage();

    //api quy mô công ty
    @GET("api_job/p_quymo.php")
    Call<ComSize> getComSize();

    //api Tags
    @FormUrlEncoded
    @POST("api_job/p_tags.php")
    Call<Tags> getTags(@Field("cate") String cate);

    //api học lực
    @GET("api_job/p_xeploai.php")
    Call<AcademicRank> getAcademicRank();

    //dang nhap nha tuyen dung
    @FormUrlEncoded
    @POST("api_job/com_login.php")
    Call<LoginEmployer> loginEmployer(@Field("email") String email,@Field("password") String pass);

    @FormUrlEncoded
    @Multipart
    @POST("api_job/com_dangky.php")
    Call<EmployerRegister> registerEmployer(@Part MultipartBody.Part image, @FieldMap Map<String, String> map);
}
