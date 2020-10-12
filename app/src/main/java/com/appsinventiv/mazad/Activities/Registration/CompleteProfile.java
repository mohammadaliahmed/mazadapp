package com.appsinventiv.mazad.Activities.Registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ProgressBar;

import com.appsinventiv.mazad.Activities.MainActivity;
import com.appsinventiv.mazad.Models.User;
import com.appsinventiv.mazad.NetworkResponses.ApiResponse;
import com.appsinventiv.mazad.R;
import com.appsinventiv.mazad.Utils.AppConfig;
import com.appsinventiv.mazad.Utils.CommonUtils;
import com.appsinventiv.mazad.Utils.SharedPrefs;
import com.appsinventiv.mazad.Utils.UserClient;
import com.google.gson.JsonObject;

import androidx.appcompat.app.AppCompatActivity;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CompleteProfile extends AppCompatActivity {


    Button save;
    EditText firstname, secondname, thirdname, sirname, email;
    ProgressBar progress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.complete_profile);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setElevation(0);
        }
        this.setTitle("");
        save = findViewById(R.id.save);
        progress = findViewById(R.id.progress);
        firstname = findViewById(R.id.firstname);
        secondname = findViewById(R.id.secondname);
        thirdname = findViewById(R.id.thirdname);
        sirname = findViewById(R.id.sirname);
        email = findViewById(R.id.email);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SelectUserType.user.setFirstName(firstname.getText().toString());
                SelectUserType.user.setSecondName(secondname.getText().toString());
                SelectUserType.user.setThirdName(thirdname.getText().toString());
                SelectUserType.user.setSirName(sirname.getText().toString());
                SelectUserType.user.setEmail(email.getText().toString());

                registerUser();

            }
        });

    }

    private void registerUser() {
        progress.setVisibility(View.VISIBLE);
        UserClient getResponse = AppConfig.getRetrofit().create(UserClient.class);
        SelectUserType.user.setApi_password(AppConfig.API_PASSOWRD);
        SelectUserType.user.setApi_username(AppConfig.API_USERNAME);
        Call<ApiResponse> call = getResponse.register(SelectUserType.user);


        call.enqueue(new Callback<ApiResponse>() {
            @Override
            public void onResponse(Call<ApiResponse> call, Response<ApiResponse> response) {
                progress.setVisibility(View.GONE);
                if (response.code() == 200) {
                    User user = response.body().getUser();
                    SharedPrefs.setUser(user);
                    CommonUtils.showToast("Registered Successfully");
                    Intent i = new Intent(CompleteProfile.this, MainActivity.class);
                    i.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(i);
                    finish();
                } else {
                    CommonUtils.showToast(response.message());
                }

            }

            @Override
            public void onFailure(Call<ApiResponse> call, Throwable t) {
                progress.setVisibility(View.GONE);
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