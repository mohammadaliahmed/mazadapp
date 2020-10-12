package com.appsinventiv.mazad.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.appsinventiv.mazad.Activities.Registration.SelectUserType;
import com.appsinventiv.mazad.Adapters.AuctionUserListAdapter;
import com.appsinventiv.mazad.Models.AuctionModel;
import com.appsinventiv.mazad.Models.BidsModel;
import com.appsinventiv.mazad.Models.User;
import com.appsinventiv.mazad.R;
import com.appsinventiv.mazad.Utils.SharedPrefs;
import com.bumptech.glide.Glide;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ViewAuction extends AppCompatActivity {
    TextView name;
    ImageView image;
    RecyclerView recyclerView;
    private AuctionModel auctionModel;
    AuctionUserListAdapter adapter;
    private List<BidsModel> itemList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_auction);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setElevation(0);
        }
        recyclerView = findViewById(R.id.recyclerView);
        image = findViewById(R.id.image);
        name = findViewById(R.id.name);
        Intent i = getIntent();
        Bundle bundle = i.getExtras();
        auctionModel = (AuctionModel) bundle.getSerializable("auction");
        this.setTitle(auctionModel.getName());
        name.setText(auctionModel.getName());
        Glide.with(this).load(auctionModel.getImages()).into(image);

        recyclerView.setLayoutManager(new LinearLayoutManager(this, RecyclerView.VERTICAL, false));

        itemList.add(new BidsModel(1,80000,"Ali",""));
        itemList.add(new BidsModel(1,70000,"Salman",""));
        itemList.add(new BidsModel(1,60000,"Arslan",""));
        itemList.add(new BidsModel(1,50000,"John",""));
        itemList.add(new BidsModel(1,40000,"Lewis",""));
        itemList.add(new BidsModel(1,30000,"Kevin",""));
        itemList.add(new BidsModel(1,20000,"Bob",""));


        adapter = new AuctionUserListAdapter(this, itemList);
        recyclerView.setAdapter(adapter);
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
