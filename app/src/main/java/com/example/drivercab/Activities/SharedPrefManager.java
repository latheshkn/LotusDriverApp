package com.example.drivercab.Activities;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.drivercab.OtpVarificationModel.Otp;
import com.example.drivercab.RegisterModel.Register;
import com.example.drivercab.RegisterModel.RegisterResponse;

public class SharedPrefManager {

    private static SharedPrefManager sharedPrefrenceManager;
    //to handle we need Context object
    private Context context;
    //Create Constructor

    public SharedPrefManager(Context context) {
        this.context = context;
    }

    //we will create Syncronized Method as we only want a single instance
    public static synchronized SharedPrefManager getInstance(Context context) {
        if (sharedPrefrenceManager == null) {   //this mean the object is no yet created in this case we will make new SharedPrefrenceManager
            sharedPrefrenceManager = new SharedPrefManager(context);

        }
        return sharedPrefrenceManager;
    }

    //now we will creat method   that we store user inside SharedPrefrences
    public void saveUser(Otp otpResponse) {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MY_PREF", Context.MODE_PRIVATE);//here mode is private bcz we only this app to access shared prefrences
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //now we will put all the infromation inside shared prefrences whic we got From VerifyOtpResponse
        editor.putString("status", otpResponse.getStatus());
        editor.putString("mobile", otpResponse.getMobile());
        editor.putString("otp", otpResponse.getOtp());
        editor.putString("id", otpResponse.getId());
        editor.putString("did", otpResponse.getDid());
        editor.putString("data", otpResponse.getData());



        editor.apply(); //now we have saved user in shared prefrences

    }

    //we will create method to check weather user is already logged in or not
    //if user information is already saved in sharedprefrences then we will assume user is already loggedIn
    public boolean isLoggedIn() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MY_PREF", Context.MODE_PRIVATE);

        //it mean that value in id is saved bcz in database we cannot put id == -1
        return sharedPreferences.getString("id", "-1") != "-1"; //bcz user is already logged in
    }

    //now we need to get back the user
    public Otp getUser() {
        SharedPreferences sharedPreferences = context.getSharedPreferences("MY_PREF", Context.MODE_PRIVATE);
        //now we can read the value form sharePrefrences object
        Otp verifyOtpResponse = new Otp(
                sharedPreferences.getString("status",null),
                sharedPreferences.getString("mobile",null),
                sharedPreferences.getString("otp",null),
                sharedPreferences.getString("id","-1"),
                sharedPreferences.getString("did",null),
                sharedPreferences.getString("data",null)
        );
        return verifyOtpResponse;
    }

    //Create a method to Logout
    public void logOut(){

        SharedPreferences sharedPreferences = context.getSharedPreferences("MY_PREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }
}


