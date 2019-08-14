package com.example.drivercab.Retrofit;

import com.example.drivercab.AboutPageModel.AboutResponse;
import com.example.drivercab.CarProfileModel.CarProfileResponse;
import com.example.drivercab.ContactModel.ContactResponse;
import com.example.drivercab.DriverBankDetailEditModel.Example;
import com.example.drivercab.DriverBankDetailModel.BankResponse;
import com.example.drivercab.DriverProfilemodel.Profile;
import com.example.drivercab.DriverProfilemodel.ProfileResponse;
import com.example.drivercab.MobileNoEnterModel.MobileNoResponse;
import com.example.drivercab.NameUpateModel.NameResponse;
import com.example.drivercab.OtpVarificationModel.Otp;
import com.example.drivercab.RegisterModel.Register;
import com.example.drivercab.RegisterModel.RegisterResponse;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface Api {

    @FormUrlEncoded
    @POST("driver_response.php")
    Call<MobileNoResponse> enterMobileNum(
            @Field("mobile") String mobile);

    //       s @FormUrlEncoded
//        @POST("user_login.php")
//        Call<LoginResponce> Drivelogin(
//                @Field("mobile") String mobile,
//                @Field("password") String password);
//        //   @Field("password")String password);
//
//
    @FormUrlEncoded
    @POST("response.php")
    Call<ResponseBody> Otpresponse(
            @Field("mobile") String mobile);


    @GET("about.php")
    Call<AboutResponse> aboutresponce(
            @Query("detail") String details);


    @FormUrlEncoded
    @POST("insert_driver_bank_details.php")
    Call<Example> editbank(
            @Field("ac_holder_name") String ac_holder_name,
            @Field("bank_name") String bank_name,
            @Field("account_number") String account_number,
            @Field("ifsc_code") String ifsc_code);


    @GET("driver_bank_details.php")
    Call<BankResponse> bankdetail(
            @Query("did") String did);

    @FormUrlEncoded
    @POST("update_driver_name.php?mobile")
    Call<NameResponse> updatename(
            @Query("mobile") String mobile,
            @Field("name") String name);


    @GET("driver_details.php")
    Call<ProfileResponse> getprofile(
            @Query("mobile") String mobile
    );


    @GET("driver_details.php")
    Call<ProfileResponse> getheader(
            @Query("mobile") String mobile
    );

    @GET("vehicle_details.php")
    Call<CarProfileResponse> getcarprofile(
            @Query("did") String did);


    @FormUrlEncoded
    @POST("driver_issue.php?mobile")
    Call<ContactResponse> getcontact(
            @Field("name") String name,
            @Field("email") String email,
            @Field("message") String message);

    @FormUrlEncoded
    @POST("driver_register.php?mobile")
    Call<RegisterResponse> getregistration(
            @Field("name") String name,
            @Field("password") String email,
            @Field("address") String message
    );


    @FormUrlEncoded
    @POST("driver_verify.php")
    Call<Otp> getverify(
            @Field("mobile") String mobile,
            @Field("otp") String otp);


}


