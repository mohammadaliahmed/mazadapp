package com.appsinventiv.mazad.Activities.Registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;

import com.appsinventiv.mazad.R;
import com.appsinventiv.mazad.Utils.AppConfig;
import com.appsinventiv.mazad.Utils.CommonUtils;
import com.appsinventiv.mazad.Utils.CompressImage;
import com.appsinventiv.mazad.Utils.UserClient;
import com.bumptech.glide.Glide;
import com.fxn.pix.Options;
import com.fxn.pix.Pix;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BidderOwner extends AppCompatActivity {


    ImageView residence, photo;
    private String photoPicked, residenceImgPicked;
    Spinner identityOfResidenceSpinner;
    private String identityOrResidenceChosen;
    String liveResidencePath, livePersonPath;
    Button save;
    EditText password, confirmPassword;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bidder_owner);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setElevation(0);
        }
        this.setTitle("");
        identityOfResidenceSpinner = findViewById(R.id.identityOfResidenceSpinner);
        progress = findViewById(R.id.progress);
        photo = findViewById(R.id.photo);
        password = findViewById(R.id.password);
        save = findViewById(R.id.save);
        confirmPassword = findViewById(R.id.confirmPassword);
        residence = findViewById(R.id.residence);
        residence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Options options = Options.init()
                        .setRequestCode(100)                                           //Request code for activity results
                        .setCount(1)                                                   //Number of images to restict selection count
                        .setExcludeVideos(true)                                       //Option to exclude videos
                        .setScreenOrientation(Options.SCREEN_ORIENTATION_PORTRAIT)     //Orientaion
                        ;                                       //Custom Path For media Storage

                Pix.start(BidderOwner.this, options);
            }
        });
        photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Options options = Options.init()
                        .setRequestCode(101)                                           //Request code for activity results
                        .setCount(1)                                                   //Number of images to restict selection count
                        .setExcludeVideos(true)                                       //Option to exclude videos
                        .setScreenOrientation(Options.SCREEN_ORIENTATION_PORTRAIT)     //Orientaion
                        ;                                       //Custom Path For media Storage

                Pix.start(BidderOwner.this, options);
            }
        });
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectUserType.user.setPassword(password.getText().toString());
                startActivity(new Intent(BidderOwner.this, CompleteProfile.class));
            }
        });
        setupSpinner();
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            ArrayList<String> mSelected = data.getStringArrayListExtra(Pix.IMAGE_RESULTS);
            CompressImage compressImage = new CompressImage(BidderOwner.this);
            residenceImgPicked = compressImage.compressImage(mSelected.get(0));
            Glide.with(BidderOwner.this).load(residenceImgPicked).into(residence);
            uploadImage("residence", residenceImgPicked);


        }
        if (requestCode == 101 && resultCode == RESULT_OK) {
            ArrayList<String> mSelected = data.getStringArrayListExtra(Pix.IMAGE_RESULTS);
            CompressImage compressImage = new CompressImage(BidderOwner.this);
            photoPicked = compressImage.compressImage(mSelected.get(0));
            Glide.with(BidderOwner.this).load(photoPicked).into(photo);
            uploadImage("person", photoPicked);

        }

    }

    private void uploadImage(final String whichType, String path) {
        progress.setVisibility(View.VISIBLE);
        CommonUtils.showToast("Uploading " + whichType + " image");
        File file = new File(path);

        UserClient service = AppConfig.getRetrofit().create(UserClient.class);

        RequestBody requestBody = RequestBody.create(MediaType.parse("image/*"), file);
        MultipartBody.Part fileToUpload = MultipartBody.Part.createFormData("photo", file.getName(), requestBody);
        RequestBody filename = RequestBody.create(MediaType.parse("text/plain"), file.getName());

        // finally, execute the request
        Call<ResponseBody> call = service.uploadFile(fileToUpload, filename);
        call.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 200) {
                    try {

                        String url = response.body().string();
                        if (whichType.equalsIgnoreCase("residence")) {
                            liveResidencePath = url;
                            SelectUserType.user.setResidencePermitPicUrl(liveResidencePath);

                        } else if (whichType.equalsIgnoreCase("person")) {
                            livePersonPath = url;
                            SelectUserType.user.setProfilePhotoPath(livePersonPath);

                        }
                        progress.setVisibility(View.GONE);

                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } else {
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                progress.setVisibility(View.GONE);

                CommonUtils.showToast(t.getMessage());
            }
        });

    }

    public void setupSpinner() {
        final List<String> list = new ArrayList<>();
        list.add("Identity or residence");
        list.add("Identity ");
        list.add("Residence");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        identityOfResidenceSpinner.setAdapter(dataAdapter);
        identityOfResidenceSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                gridViewAdapter.getFilter().filter(list.get(position));

                identityOrResidenceChosen = list.get(position);
                SelectUserType.user.setIdentityOrResidence(identityOrResidenceChosen);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {


            finish();
        }

        return super.onOptionsItemSelected(item);
    }

}