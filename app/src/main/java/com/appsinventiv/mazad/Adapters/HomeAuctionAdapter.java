package com.appsinventiv.mazad.Adapters;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.appsinventiv.mazad.Activities.ViewAuction;
import com.appsinventiv.mazad.Models.AuctionModel;
import com.appsinventiv.mazad.R;
import com.bumptech.glide.Glide;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomeAuctionAdapter extends RecyclerView.Adapter<HomeAuctionAdapter.ViewHolder> {
    Context context;
    List<AuctionModel> itemList;

    public HomeAuctionAdapter(Context context, List<AuctionModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.home_auction_item_layout, parent, false);
        HomeAuctionAdapter.ViewHolder viewHolder = new HomeAuctionAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final AuctionModel model = itemList.get(position);
        holder.name.setText(model.getName());
        holder.date.setText(model.getDate());
        Glide.with(context).load(model.getImages()).into(holder.image);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent yourIntent = new Intent(context, ViewAuction.class);

                Bundle b = new Bundle();
                b.putSerializable("auction", model);
                yourIntent.putExtras(b); //pass bundle to your intent
                context.startActivity(yourIntent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, date;
        ImageView image;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            image = itemView.findViewById(R.id.image);
        }
    }


}
