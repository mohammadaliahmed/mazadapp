package com.appsinventiv.mazad.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.appsinventiv.mazad.Models.BidsModel;
import com.appsinventiv.mazad.R;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AuctionUserListAdapter extends RecyclerView.Adapter<AuctionUserListAdapter.ViewHolder> {
    Context context;
    List<BidsModel> itemList;

    public AuctionUserListAdapter(Context context, List<BidsModel> itemList) {
        this.context = context;
        this.itemList = itemList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.bid_user_item_layout, parent, false);
        AuctionUserListAdapter.ViewHolder viewHolder = new AuctionUserListAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        BidsModel model = itemList.get(position);
        holder.name.setText(model.getName());
        holder.bid.setText("$" + model.getAmount());

    }

    @Override
    public int getItemCount() {
        return itemList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name, bid;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            bid = itemView.findViewById(R.id.bid);
        }
    }


}
