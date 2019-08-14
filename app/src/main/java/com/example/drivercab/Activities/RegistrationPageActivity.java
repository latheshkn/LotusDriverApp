package com.example.drivercab.Activities;

import android.Manifest;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.provider.Settings;
import android.util.Base64;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.StringRequestListener;
import com.androidnetworking.interfaces.UploadProgressListener;
import com.example.drivercab.NameUpateModel.NameResponse;
import com.example.drivercab.R;
import com.example.drivercab.RegisterModel.Register;
import com.example.drivercab.RegisterModel.RegisterResponse;
import com.example.drivercab.Retrofit.Api;
import com.example.drivercab.Retrofit.BaseClient;
import com.karumi.dexter.Dexter;
import com.karumi.dexter.PermissionToken;
import com.karumi.dexter.listener.PermissionDeniedResponse;
import com.karumi.dexter.listener.PermissionGrantedResponse;
import com.karumi.dexter.listener.PermissionRequest;
import com.karumi.dexter.listener.single.PermissionListener;
import com.theartofdev.edmodo.cropper.CropImage;
import com.theartofdev.edmodo.cropper.CropImageView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegistrationPageActivity extends AppCompatActivity {
Button register;
EditText fname,mobileno,vehicleno,vehiclename;
    int PICK_IMAGE=1;
    int IMAGE_REQUEST=1;
    Uri imageuri  ;
    Bitmap bitmap;
    Button imgsave,imgchoose;
    ImageView imgcamdp,imgcamlicense,imgcamrc;
    ProgressDialog progressDialog;


    ConstraintLayout constpf,conslicense,constraintrc,conspfupload;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);
        register=findViewById(R.id.register);
        fname=findViewById(R.id.fname);
        mobileno=findViewById(R.id.mobileno);
        vehicleno=findViewById(R.id.vehicleno);
        vehiclename=findViewById(R.id.vehiclename);
        constpf=findViewById(R.id.constpf);

//        imgcam=findViewById(R.id.imgnxtrc);
        imgcamdp=findViewById(R.id.imgcamdp);
        progressDialog = new ProgressDialog(RegistrationPageActivity.this);
        progressDialog.setMessage("Uploading Please Wait");
        progressDialog.setCancelable(false);
        progressDialog.setMax(100);
        progressDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);


        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                login();

            }
        });


        imgcamdp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dexter.withActivity(RegistrationPageActivity.this).withPermission(Manifest.permission.READ_EXTERNAL_STORAGE)
                        .withListener(new PermissionListener() {
                            @Override
                            public void onPermissionGranted(PermissionGrantedResponse response) {
                                CropImage.activity()
                                        .setGuidelines(CropImageView.Guidelines.ON)
                                        .start(RegistrationPageActivity.this);
                            }

                            @Override
                            public void onPermissionDenied(PermissionDeniedResponse response) {
                                if (response.isPermanentlyDenied()) {
                                    AlertDialog.Builder builder = new AlertDialog.Builder(RegistrationPageActivity.this);
                                    builder.setTitle("Permission Required")
                                            .setMessage("App needed Storage permission to run press ok to continue")
                                            .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialogInterface, int i) {
                                                    Intent intent = new Intent();
                                                    intent.setAction(Settings.ACTION_APPLICATION_DETAILS_SETTINGS);
                                                    intent.setData(Uri.fromParts("package", getPackageName(), null));
                                                    startActivityForResult(intent, 51);
                                                }
                                            })
                                            .setNegativeButton("Cancel", null)
                                            .show();
                                }

                            }

                            @Override
                            public void onPermissionRationaleShouldBeShown(PermissionRequest permission, PermissionToken token) {
                                token.continuePermissionRequest();
                            }


                        }).check();
            }
        });



    }

    private void login() {

        String name = fname.getText().toString();
        String mobilenum = mobileno.getText().toString();
        String vehiclenum = vehicleno.getText().toString();
        String vehiclenamen = vehiclename.getText().toString();


//        if (memail.isEmpty()) {
//            txtEmail.setError("Email required");
//            txtEmail.requestFocus();
//            return;
//        }
//        if (Patterns.EMAIL_ADDRESS.matcher(memail).matches()) {
//            txtEmail.setError("Enter a valid Email");
//            txtEmail.requestFocus();
//            return;
//        }


//        if (mpassword.length() > 6) {
//            txtPassword.setError("password should be atleast of 6 charact");
//            txtPassword.requestFocus();
//            return;
//        }

        if (name.isEmpty()) {
            fname.setError("name reqired");
            fname.requestFocus();
            return;

        }

        if (mobilenum.isEmpty()) {
            mobileno.setError("phone number required");
            mobileno.requestFocus();
            return;
        }


        if (vehiclenum.isEmpty()) {
            vehicleno.setError("Vehicle number reqired");
            vehicleno.requestFocus();
            return;

        }

        if (vehiclenamen.isEmpty()) {
            vehiclename.setError("vehicle name reqired");
            vehiclename.requestFocus();
            return;

        }




        Api recipeHomeApi = BaseClient.getBaseClient().create(Api.class);
        Call<RegisterResponse> call = recipeHomeApi.getregistration(name,mobilenum,vehiclenum);

        call.enqueue(new Callback<RegisterResponse>() {
            @Override
            public void onResponse(Call<RegisterResponse> call, Response<RegisterResponse> response) {
                if (response.isSuccessful()) {
//                    RegisterResponse registerresponse = response.body();
//                    SharedPrefManager.getInstance(RegistrationPageActivity.this)
//                            .saveUser(registerresponse); //we
                    Intent intent =new Intent(RegistrationPageActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();

                    Toast.makeText(RegistrationPageActivity.this, response.message(), Toast.LENGTH_SHORT).show();

                    Toast.makeText(RegistrationPageActivity.this, "success", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(RegistrationPageActivity.this, "UnSucessful", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<RegisterResponse> call, Throwable t) {

                Toast.makeText(RegistrationPageActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }






    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CropImage.CROP_IMAGE_ACTIVITY_REQUEST_CODE) {
            CropImage.ActivityResult result = CropImage.getActivityResult(data);
            if (resultCode == RESULT_OK) {
                final Uri resultUri = result.getUri();
                imgcamdp.setImageURI(resultUri);
                constpf.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {

                        File Imagefile = new File(resultUri.getPath());

                        progressDialog.show();
                        AndroidNetworking.upload("http://lotuscabs.com/api/driver_register.php")
                                .addMultipartFile("dl_image", Imagefile)
                                .addMultipartParameter("mobile", "9898798799")
                                .setPriority(Priority.HIGH)
                                .build()
                                .setUploadProgressListener(new UploadProgressListener() {
                                    @Override
                                    public void onProgress(long bytesUploaded, long totalBytes) {
                                        float progress = (float) bytesUploaded / totalBytes * 100;
                                        progressDialog.setProgress((int) progress);
                                    }
                                })
                                .getAsString(new StringRequestListener() {
                                    @Override
                                    public void onResponse(String response) {
//                                        Log.i("mytag",response);
                                        try {
                                            progressDialog.dismiss();
                                            JSONObject jsonObject = new JSONObject(response);
                                            int status = jsonObject.getInt("status");
                                            String message = jsonObject.getString("message");

                                            if (status == 0) {
                                                Toast.makeText(RegistrationPageActivity.this, "Unable to upload Image" + message, Toast.LENGTH_SHORT).show();
                                            } else {
                                                Toast.makeText(RegistrationPageActivity.this, message, Toast.LENGTH_SHORT).show();
                                            }

                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                            Toast.makeText(RegistrationPageActivity.this, "Uploaded", Toast.LENGTH_SHORT).show();
                                        }
                                    }

                                    @Override
                                    public void onError(ANError anError) {
                                        progressDialog.dismiss();
                                        anError.printStackTrace();
                                        Toast.makeText(RegistrationPageActivity.this, "Error loading  ", Toast.LENGTH_SHORT).show();
                                    }
                                });
                    }
                });



            } else if (resultCode == CropImage.CROP_IMAGE_ACTIVITY_RESULT_ERROR_CODE) {
                Exception error = result.getError();
            }
        }
    }


}
