package com.appsinventiv.mazad.Activities.Registration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.appsinventiv.mazad.R;
import com.appsinventiv.mazad.Utils.CommonUtils;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;

public class SelectBidderType extends AppCompatActivity {

    Spinner individualTypeSpinner;
    private String individualTypeChosen;
    Button continueTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bidder_type);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
            getSupportActionBar().setElevation(0);
        }
        this.setTitle("Select Individual Type");
        individualTypeSpinner = findViewById(R.id.individualTypeSpinner);
        continueTo = findViewById(R.id.continueTo);
        continueTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (individualTypeChosen.equalsIgnoreCase("Bidder Owner")) {
                    startActivity(new Intent(SelectBidderType.this, BidderOwner.class));
                } else if (individualTypeChosen.equalsIgnoreCase("Bidder Company")) {
                    startActivity(new Intent(SelectBidderType.this, BidderCompany.class));
                } else {
                    CommonUtils.showToast("Please select user type");
                }
            }
        });

        setupSpinner();
    }

    public void setupSpinner() {
        final List<String> list = new ArrayList<>();
        list.add("Select individual type");
        list.add("Bidder Owner");
        list.add("Bidder Company");


        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        individualTypeSpinner.setAdapter(dataAdapter);
        individualTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                gridViewAdapter.getFilter().filter(list.get(position));

                individualTypeChosen = list.get(position);

                SelectUserType.user.setIndividualType(individualTypeChosen);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

}