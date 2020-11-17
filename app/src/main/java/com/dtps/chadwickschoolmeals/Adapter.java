package com.dtps.chadwickschoolmeals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {
    private ArrayList<RecyclerItem> mData = null;



    Adapter(ArrayList<RecyclerItem> list){
        mData=list;
    }
    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View view = inflater.inflate(R.layout.evaluation_item,parent,false);
        Adapter.ViewHolder vh = new Adapter.ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, int position) {
        RecyclerItem item = mData.get(position);

        holder.user.setText(item.getUser());
        holder.comment.setText(item.getComment());
        holder.ratingBar.setRating((float)item.getRating().doubleValue());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView user;
        TextView comment;
        RatingBar ratingBar;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            ratingBar = itemView.findViewById(R.id.evalItem_ratingbar);
            user = itemView.findViewById(R.id.evalItem_user);
            comment = itemView.findViewById(R.id.evalItem_comment);
        }
    }

    public void clearData(){
        mData.clear();
    }
}
