package com.appsinventiv.mazad.Activities.Registration;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Spinner;
import android.widget.TextView;

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
import java.util.Calendar;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BidderCompany extends AppCompatActivity {


    Button save;
    EditText companyName, companyRegistrationNumber, registryIssuingArea,
            password, confirmPassword, registryArea;
    Spinner identityOfResidenceSpinner;
    ImageView pickDate, pickExpiry;
    ImageView pickRegistry, residence, photo;
    private String identityOrResidenceChosen;
    private String residenceImgPicked, photoPicked;
    private String pickedRegistry;

    ProgressBar progress;
    private String liveResidencePath;
    private String livePersonPath;
    private String liveRegistryPath;
    TextView dateOfRegistry, expiryOfRegistry;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bidder_company);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setElevation(0);
        }
        this.setTitle("");
        progress = findViewById(R.id.progress);
        registryArea = findViewById(R.id.registryArea);
        confirmPassword = findViewById(R.id.confirmPassword);
        password = findViewById(R.id.password);
        registryIssuingArea = findViewById(R.id.registryIssuingArea);
        companyRegistrationNumber = findViewById(R.id.companyRegistrationNumber);
        companyName = findViewById(R.id.companyName);
        identityOfResidenceSpinner = findViewById(R.id.identityOfResidenceSpinner);
        pickExpiry = findViewById(R.id.pickExpiry);
        pickDate = findViewById(R.id.pickDate);
        pickRegistry = findViewById(R.id.pickRegistry);
        residence = findViewById(R.id.residence);
        dateOfRegistry = findViewById(R.id.dateOfRegistry);
        expiryOfRegistry = findViewById(R.id.expiryOfRegistry);
        photo = findViewById(R.id.photo);
        save = findViewById(R.id.save);

        pickDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog picker = new DatePickerDialog(BidderCompany.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                dateOfRegistry.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);
                            }
                        }, year, month, day);
                picker.show();

            }
        });
        pickExpiry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                DatePickerDialog picker = new DatePickerDialog(BidderCompany.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                expiryOfRegistry.setText((monthOfYear + 1) + "/" + dayOfMonth + "/" + year);

                            }
                        }, year, month, day);
                picker.show();

            }
        });

        residence.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Options options = Options.init()
                        .setRequestCode(100)                                           //Request code for activity results
                        .setCount(1)                                                   //Number of images to restict selection count
                        .setExcludeVideos(true)                                       //Option to exclude videos
                        .setScreenOrientation(Options.SCREEN_ORIENTATION_PORTRAIT)     //Orientaion
                        ;                                       //Custom Path For media Storage

                Pix.start(BidderCompany.this, options);
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

                Pix.start(BidderCompany.this, options);
            }
        });
        pickRegistry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Options options = Options.init()
                        .setRequestCode(102)                                           //Request code for activity results
                        .setCount(1)                                                   //Number of images to restict selection count
                        .setExcludeVideos(true)                                       //Option to exclude videos
                        .setScreenOrientation(Options.SCREEN_ORIENTATION_PORTRAIT)     //Orientaion
                        ;                                       //Custom Path For media Storage

                Pix.start(BidderCompany.this, options);
            }
        });

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectUserType.user.setPassword(password.getText().toString());
                SelectUserType.user.setCompanyName(companyName.getText().toString());
                SelectUserType.user.setCompanyRegistryNumber(companyRegistrationNumber.getText().toString());
                SelectUserType.user.setRegistryIssuingArea(registryIssuingArea.getText().toString());
                SelectUserType.user.setRegistryArea(registryArea.getText().toString());
                SelectUserType.user.setRegistryDate(dateOfRegistry.getText().toString());
                SelectUserType.user.setRegistryExpiryDate(expiryOfRegistry.getText().toString());
                startActivity(new Intent(BidderCompany.this, CompleteProfile.class));

            }
        });
        setupSpinner();
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

                        } else if (whichType.equalsIgnoreCase("registry")) {
                            liveRegistryPath = url;
                            SelectUserType.user.setRegistryPicUrl(liveRegistryPath);

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


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 100 && resultCode == RESULT_OK) {
            ArrayList<String> mSelected = data.getStringArrayListExtra(Pix.IMAGE_RESULTS);
            CompressImage compressImage = new CompressImage(BidderCompany.this);
            residenceImgPicked = compressImage.compressImage(mSelected.get(0));
            Glide.with(BidderCompany.this).load(residenceImgPicked).into(residence);
            uploadImage("residence", residenceImgPicked);


        }
        if (requestCode == 101 && resultCode == RESULT_OK) {
            ArrayList<String> mSelected = data.getStringArrayListExtra(Pix.IMAGE_RESULTS);
            CompressImage compressImage = new CompressImage(BidderCompany.this);
            photoPicked = compressImage.compressImage(mSelected.get(0));
            Glide.with(BidderCompany.this).load(photoPicked).into(photo);
            uploadImage("person", photoPicked);

        }
        if (requestCode == 102 && resultCode == RESULT_OK) {
            ArrayList<String> mSelected = data.getStringArrayListExtra(Pix.IMAGE_RESULTS);
            CompressImage compressImage = new CompressImage(BidderCompany.this);
            pickedRegistry = compressImage.compressImage(mSelected.get(0));
            Glide.with(BidderCompany.this).load(pickedRegistry).into(pickRegistry);
            uploadImage("registry", pickedRegistry);

        }

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