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
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.TextView;

import java.util.ArrayList;

public class EvaluateActivity extends AppCompatActivity {

    Button evaluate_btn_RegisterEval;
    Toolbar evaluate_toolbar;
    TextView evaluate_txt_date,evaluate_txt_menu;
    TextView evaluate_txt_soup,evaluate_txt_main,evaluate_txt_sub1,evaluate_txt_sub2;
    TextView evaluate_txt_sub3,evaluate_txt_sub4;
    RatingBar evaluate_ratingbar;

    RecyclerView mRecyclerView = null;
    Adapter mAdapter = null;
    ArrayList<RecyclerItem> mList = new ArrayList<RecyclerItem>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_evaluate);

        evaluate_toolbar = (Toolbar)findViewById(R.id.evaluate_toolbar);
        setSupportActionBar(evaluate_toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setUp();
        activityMover();

        mRecyclerView = findViewById(R.id.recylerview);

        mAdapter = new Adapter(mList);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        addItem("USER","너무 맛있어요");
        addItem("USER","국이 너무 싱거워요");
        addItem("USER","반찬이 너무 부실해요");
        addItem("USER","밥이 너무 질어요");
        addItem("USER","국이 너무 싱거워요");
        addItem("USER","국이 너무 싱거워요");
    }

    public void addItem(String user,String comment){
        RecyclerItem item = new RecyclerItem();

        item.setUser(user);
        item.setComment(comment);

        mList.add(item);
    }

    public void setUp(){
        evaluate_btn_RegisterEval = (Button)findViewById(R.id.evaluate_btn_RegisterEval);
        evaluate_txt_date = (TextView)findViewById(R.id.evaluate_txt_date);
        evaluate_txt_menu = (TextView)findViewById(R.id.evaluate_txt_menu);
        evaluate_txt_soup = (TextView)findViewById(R.id.evaluate_txt_soup);
        evaluate_txt_main = (TextView)findViewById(R.id.evaluate_txt_main);
        evaluate_txt_sub1 = (TextView)findViewById(R.id.evaluate_txt_sub1);
        evaluate_txt_sub2 = (TextView)findViewById(R.id.evaluate_txt_sub2);
        evaluate_txt_sub3 = (TextView)findViewById(R.id.evaluate_txt_sub3);
        evaluate_txt_sub4 = (TextView)findViewById(R.id.evaluate_txt_sub4);
        evaluate_ratingbar = (RatingBar)findViewById(R.id.evaluate_ratingbar);
    }

    public void activityMover(){
        evaluate_btn_RegisterEval.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(EvaluateActivity.this, RegisterEvalActivity.class);
                startActivity(intent);
                finish();
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
}