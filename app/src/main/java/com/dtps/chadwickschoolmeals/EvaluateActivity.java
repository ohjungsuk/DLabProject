package com.dtps.chadwickschoolmeals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.dtps.chadwickschoolmeals.interfaces.GetMenuView;
import com.dtps.chadwickschoolmeals.interfaces.ReviewRetrofitInterface;
import com.dtps.chadwickschoolmeals.interfaces.ReviewView;
import com.dtps.chadwickschoolmeals.models.GetMenuResponse;
import com.dtps.chadwickschoolmeals.models.GetReviewResponse;
import com.dtps.chadwickschoolmeals.models.GetTotalReviewResponse;
import com.dtps.chadwickschoolmeals.models.Review;
import com.dtps.chadwickschoolmeals.services.GetMenuService;
import com.dtps.chadwickschoolmeals.services.ReviewService;
import com.dtps.chadwickschoolmeals.services.SignInService;

import java.util.ArrayList;
import java.util.List;

import static android.view.View.GONE;

public class EvaluateActivity extends AppCompatActivity implements GetMenuView, ReviewView {

    Button evaluate_btn_RegisterEval;
    Toolbar evaluate_toolbar;
    TextView evaluate_txt_date,evaluate_txt_menu;
    TextView evaluate_txt_soup,evaluate_txt_main,evaluate_txt_sub1,evaluate_txt_sub2;
    TextView evaluate_txt_sub3,evaluate_txt_sub4;
    TextView evaluate_txt_rating;
    RatingBar evaluate_ratingbar;
    ProgressBar evaluate_progressBar_menu;
    ProgressBar evaluate_progressBar_RecyclcerView;
    int mfoodIdx;
    String date;

    RecyclerView mRecyclerView = null;
    Adapter mAdapter = null;
    ArrayList<RecyclerItem> mList = new ArrayList<RecyclerItem>();

    int foodIdx = -1;

    @Override
    protected void onResume() {
        super.onResume();
        new GetMenuService(this).getMenu(this.date,foodIdx);
        new ReviewService(this).getReview(foodIdx, this.date);
        new ReviewService(this).getTotalReview(foodIdx, this.date);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);

        evaluate_toolbar = (Toolbar)findViewById(R.id.evaluate_toolbar);
        setSupportActionBar(evaluate_toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setUp();
        activityMover();

        if(ApplicationClass.authority == SignInService.TEACHER){
            evaluate_btn_RegisterEval.setVisibility(View.INVISIBLE);
        }

        int year = getIntent().getExtras().getInt("year");
        int month = getIntent().getExtras().getInt("month");
        int date = getIntent().getExtras().getInt("date");
        foodIdx = getIntent().getExtras().getInt("foodIdx", -1);

        mfoodIdx = foodIdx;

        this.date = String.format("%04d-%02d-%02d",year,month+1,date);

        switch (foodIdx) {
            case 1:
                evaluate_txt_menu.setText("Korean");
                break;
            case 2:
                evaluate_txt_menu.setText("International");
                break;
            case 3:
                evaluate_txt_menu.setText("Noodles");
                break;
        }

        evaluate_txt_date.setText(this.date);

        mRecyclerView = findViewById(R.id.recylerview);

        mAdapter = new Adapter(mList);
        mRecyclerView.setAdapter(mAdapter);
        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setReverseLayout(true);
        mLayoutManager.setStackFromEnd(true);
        mRecyclerView.setLayoutManager(mLayoutManager);
   //     mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

    }

    public void addItem(String user, String comment, Double rating){
        RecyclerItem item = new RecyclerItem();

        item.setUser(user);
        item.setComment(comment);
        item.setRating(rating);

        mList.add(item);
    }

    public void setUp(){
        evaluate_btn_RegisterEval = (Button)findViewById(R.id.evaluate_btn_RegisterEval);
        evaluate_txt_rating = findViewById(R.id.evaluate_textview_total);
        evaluate_txt_date = (TextView)findViewById(R.id.evaluate_txt_date);
        evaluate_txt_menu = (TextView)findViewById(R.id.evaluate_txt_menu);
        evaluate_txt_soup = (TextView)findViewById(R.id.evaluate_txt_soup);
        evaluate_txt_main = (TextView)findViewById(R.id.evaluate_txt_main);
        evaluate_txt_sub1 = (TextView)findViewById(R.id.evaluate_txt_sub1);
        evaluate_txt_sub2 = (TextView)findViewById(R.id.evaluate_txt_sub2);
        evaluate_txt_sub3 = (TextView)findViewById(R.id.evaluate_txt_sub3);
        evaluate_txt_sub4 = (TextView)findViewById(R.id.evaluate_txt_sub4);
        evaluate_ratingbar = (RatingBar)findViewById(R.id.evaluate_ratingbar);
        evaluate_progressBar_menu = (ProgressBar)findViewById(R.id.evaluate_progress_bar_menu);
        evaluate_progressBar_RecyclcerView = (ProgressBar)findViewById(R.id.evaluate);
    }

    public void activityMover(){
        evaluate_btn_RegisterEval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EvaluateActivity.this, RegisterEvalActivity.class);
                intent.putExtra("foodIdx",mfoodIdx);
                intent.putExtra("date",EvaluateActivity.this.date);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(EvaluateActivity.this,HomeActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                Intent intent = new Intent(EvaluateActivity.this,HomeActivity.class);
                startActivity(intent);
                finish();
            }
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void validateMenu(GetMenuResponse response) {
  //      Toast.makeText(this, response.getMessage().toString(), Toast.LENGTH_SHORT).show();
        evaluate_progressBar_menu.setVisibility(GONE);

        evaluate_txt_soup.setVisibility(View.VISIBLE);
        evaluate_txt_main.setVisibility(View.VISIBLE);
        evaluate_txt_sub1.setVisibility(View.VISIBLE);
        evaluate_txt_sub2.setVisibility(View.VISIBLE);
        evaluate_txt_sub3.setVisibility(View.VISIBLE);
        evaluate_txt_sub4.setVisibility(View.VISIBLE);

        switch(response.getCode()){
            case 200:
  //              Toast.makeText(this, "success", Toast.LENGTH_SHORT).show();
                setMenuToTextView(response.getResult());
                break;
            case 400:
  //              Toast.makeText(this, "something wrong in server", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    public void setMenuToTextView(List<String> menu){
        TextView[] textViews = {
                evaluate_txt_soup,
                evaluate_txt_main,
                evaluate_txt_sub1,
                evaluate_txt_sub2,
                evaluate_txt_sub3,
                evaluate_txt_sub4,
        };

        if(menu == null){
            for(TextView tv: textViews){
                tv.setText("-");
            }
            return;
        }

        int idx = 0;
        for(String content: menu){
            if(content.equals("")){
                textViews[idx].setText("-");
            }else{
                textViews[idx].setText(content);
            }
            idx++;
        }
    }

    @Override
    public void validateFailure() {
        Toast.makeText(this, "networking error!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void validateSuccess() {

    }

    @Override
    public void validateRecyclerView(GetReviewResponse response) {
        evaluate_progressBar_RecyclcerView.setVisibility(GONE);
        mRecyclerView.setVisibility(View.VISIBLE);
        mAdapter.clearData();

        if(response.getCode() == 481) {
            mAdapter.notifyDataSetChanged();
            return;
        }

        ArrayList<Review> reviews = (ArrayList<Review>)response.getReviewList();

        if(reviews == null){
            mAdapter.notifyDataSetChanged();
            return;

        }else{
            for(Review review : reviews){
                String getCreated = review.getCreatedAt();
                if(getCreated == null){
                    getCreated="";
                }
                addItem(getCreated, review.getContent().toString(), review.getScore());
            }
        }

        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void validateRatingBar(GetTotalReviewResponse response) {
        Log.d("validateRatingBar", String.valueOf(response.getCode()));

 //       float mscore = (float) response.getTotalScore().doubleValue();
 //       String s_score = String.valueOf(Math.round(mscore*10)/10.0);

        if(!response.getIsSuccess()){
            evaluate_ratingbar.setRating(0);
            evaluate_txt_rating.setText("0");

        }else {
            evaluate_ratingbar.setRating((float)response.getTotalScore().doubleValue());
            System.out.println(response.getTotalScore() + "totalValue\n");
            evaluate_txt_rating.setText(String.valueOf( Math.round( (float) response.getTotalScore().doubleValue()*10 )/10.0 ));
        }
    }
}