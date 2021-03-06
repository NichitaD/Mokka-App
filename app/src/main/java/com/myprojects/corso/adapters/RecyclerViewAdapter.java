package com.myprojects.corso.adapters;


import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.myprojects.corso.R;
import com.myprojects.corso.model.Review;

import java.util.ArrayList;
import java.util.Random;

public class RecyclerViewAdapter  extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>{

    private static final String TAG = "RecycleViewAdapter";
    private ArrayList<Review> mReviews;

    public RecyclerViewAdapter(ArrayList<Review> reviews){
       Log.d(TAG, "constructor called");
       mReviews = reviews;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "view_holde_called");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_list_item, parent, false) ;
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.email.setText((String) mReviews.get(position).getAuthor());
        holder.rating_bar.setRating((Float)mReviews.get(position).getRating().floatValue());
        if (mReviews.get(position).getText() == ""){
            holder.review_content.setText("-User didn't leave a review-");
            holder.review_content.setTextColor(Color.WHITE);
        } else {
            holder.review_content.setText(mReviews.get(position).getText());
        }
        holder.rating_bar.setIsIndicator(true);
        Random rnd = new Random();
        int color = Color.argb(255, rnd.nextInt(256), rnd.nextInt(256), rnd.nextInt(256));
        holder.container.setCardBackgroundColor(color);

    }

    @Override
    public int getItemCount() {
       return  mReviews.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
         TextView email;
         TextView review_content;
         RatingBar rating_bar;
         CardView container;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            email = itemView.findViewById(R.id.review_email);
            review_content = itemView.findViewById(R.id.review_content);
            rating_bar = itemView.findViewById(R.id.ratingBar2);
            container = itemView.findViewById(R.id.container);
        }
    }
}
