package com.appsinventiv.mazad.Activities;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.appsinventiv.mazad.Adapters.HomeAuctionAdapter;
import com.appsinventiv.mazad.Adapters.HomeMenuAdapter;
import com.appsinventiv.mazad.Models.AuctionModel;
import com.appsinventiv.mazad.R;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class HomeFragment extends androidx.fragment.app.Fragment {
    private View rootView;

    RecyclerView menuRecycler, auctionRecycler;
    HomeMenuAdapter homeMenuAdapter;
    HomeAuctionAdapter auctionAdapter;
    private List<AuctionModel> itemList=new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_home, container, false);
        initViews();
        return rootView;
    }

    private void initViews() {

        initMenu();
        initAuction();

    }

    private void initAuction() {
        auctionRecycler = rootView.findViewById(R.id.auctionRecycler);
        itemList.add(new AuctionModel("https://i.pinimg.com/originals/be/cd/a7/becda76c6441fa6766b83b1f82d36c3c.jpg","Dream house #5 | Dream beach houses, House","10/10/2020","Available","31/12/2020",""));
        itemList.add(new AuctionModel("https://www.championhomes.com.au/uploads/2019/08/duplex-construction-1.jpg","Champion Homes 5 Reasons to Consider Duplex","10/10/2020","Available","31/12/2020",""));
        itemList.add(new AuctionModel("https://www.wpi.edu/sites/default/files/2019/09/24/Schussler%20House.jpg","Worcester Polytechnic Institute Schussler House","10/10/2020","Available","31/12/2020",""));
        itemList.add(new AuctionModel("https://5.imimg.com/data5/IH/FN/MY-7303908/fully-furnished-developed-farm-house-in-pushkar-2bhk-500x500.jpg","Fully Furnished Developed Bank Loanble Farm House In Pushkar","10/10/2020","Available","31/12/2020",""));
        itemList.add(new AuctionModel("https://res.akamaized.net/domain/image/upload/t_web/c_fill,w_500,h_300/v1538713881/bigsmall_Mirvac_house2_twgogv.jpg","Seymour House |","10/10/2020","Available","31/12/2020",""));
        auctionAdapter = new HomeAuctionAdapter(getContext(), itemList);
        auctionRecycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        auctionRecycler.setAdapter(auctionAdapter);
    }

    private void initMenu() {
        menuRecycler = rootView.findViewById(R.id.menuRecycler);

        List<String> menuList = new ArrayList<>();
        menuList.add("Buy a Home/Property");
        menuList.add("Sell a Home/Property");
        menuList.add("Rent a house");
        menuList.add("My Task");
        homeMenuAdapter = new HomeMenuAdapter(getContext(), menuList);
        menuRecycler.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        menuRecycler.setAdapter(homeMenuAdapter);
    }

}
