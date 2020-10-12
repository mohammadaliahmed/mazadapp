package com.appsinventiv.mazad.Activities.Registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;

import com.appsinventiv.mazad.Models.User;
import com.appsinventiv.mazad.R;

import androidx.appcompat.app.AppCompatActivity;

public class SelectUserType extends AppCompatActivity {

    LinearLayout bidder;
    public static User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_user_type);
        user=new User();
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setElevation(0);
        }
        this.setTitle("");
        bidder = findViewById(R.id.bidder);
        bidder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                user.setUserType("bidder");
                startActivity(new Intent(SelectUserType.this, SelectBidderType.class));
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