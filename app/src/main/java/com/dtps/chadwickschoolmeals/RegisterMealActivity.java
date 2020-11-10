package com.dtps.chadwickschoolmeals;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class RegisterMealActivity extends AppCompatActivity {

    androidx.appcompat.widget.Toolbar registerMeal_toolbar;
    FloatingActionButton fab;
    TextView registerMeal_txt_date;
    EditText registerMeal_edt_m1,registerMeal_edt_m2,registerMeal_edt_m3;
    EditText registerMeal_edt_m4,registerMeal_edt_m5,registerMeal_edt_m6;
    EditText registerMeal_edt_mInt1,registerMeal_edt_mInt2,registerMeal_edt_mInt3;
    EditText registerMeal_edt_mInt4,registerMeal_edt_mInt5,registerMeal_edt_mInt6;
    EditText registerMeal_edt_mNd1,registerMeal_edt_mNd2,registerMeal_edt_mNd3;
    EditText registerMeal_edt_mNd4,registerMeal_edt_mNd5,registerMeal_edt_mNd6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_meal);

        registerMeal_toolbar = (androidx.appcompat.widget.Toolbar) findViewById(R.id.registerMeal_toolbar);
        setSupportActionBar(registerMeal_toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setUp();
        floatingbtn();
    }
    public void setUp(){
        fab=(FloatingActionButton) findViewById(R.id.fab);
        registerMeal_txt_date = (TextView)findViewById(R.id.registerMeal_txt_date);
        registerMeal_edt_m1 = (EditText)findViewById(R.id.registerMeal_edt_m1);
        registerMeal_edt_m2 = (EditText)findViewById(R.id.registerMeal_edt_m2);
        registerMeal_edt_m3 = (EditText)findViewById(R.id.registerMeal_edt_m3);
        registerMeal_edt_m4 = (EditText)findViewById(R.id.registerMeal_edt_m4);
        registerMeal_edt_m5 = (EditText)findViewById(R.id.registerMeal_edt_m5);
        registerMeal_edt_m6 = (EditText)findViewById(R.id.registerMeal_edt_m6);

        registerMeal_edt_mInt1 = (EditText)findViewById(R.id.registerMeal_edt_mInt1);
        registerMeal_edt_mInt2 = (EditText)findViewById(R.id.registerMeal_edt_mInt2);
        registerMeal_edt_mInt3 = (EditText)findViewById(R.id.registerMeal_edt_mInt3);
        registerMeal_edt_mInt4 = (EditText)findViewById(R.id.registerMeal_edt_mInt4);
        registerMeal_edt_mInt5 = (EditText)findViewById(R.id.registerMeal_edt_mInt5);
        registerMeal_edt_mInt6 = (EditText)findViewById(R.id.registerMeal_edt_mInt6);

        registerMeal_edt_mNd1 = (EditText)findViewById(R.id.registerMeal_edt_mNd1);
        registerMeal_edt_mNd2 = (EditText)findViewById(R.id.registerMeal_edt_mNd2);
        registerMeal_edt_mNd3 = (EditText)findViewById(R.id.registerMeal_edt_mNd3);
        registerMeal_edt_mNd4 = (EditText)findViewById(R.id.registerMeal_edt_mNd4);
        registerMeal_edt_mNd5 = (EditText)findViewById(R.id.registerMeal_edt_mNd5);
        registerMeal_edt_mNd6 = (EditText)findViewById(R.id.registerMeal_edt_mNd6);
    }

    public void floatingbtn(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(RegisterMealActivity.this)
                        .setMessage("이대로 식단을 등록하시겠습니까?")
                        .setPositiveButton("예", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                Intent intent = new Intent(RegisterMealActivity.this,HomeActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
            }
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(RegisterMealActivity.this)
                .setMessage("뒤로가면 내용이 저장되지 않습니다.?")
                .setPositiveButton("계속", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        Intent intent = new Intent(RegisterMealActivity.this,HomeActivity.class);
                        startActivity(intent);
                        finish();
                    }
                })
                .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case android.R.id.home:{
                new AlertDialog.Builder(RegisterMealActivity.this)
                        .setMessage("뒤로가면 내용이 저장되지 않습니다.?")
                        .setPositiveButton("계속", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                                Intent intent = new Intent(RegisterMealActivity.this,HomeActivity.class);
                                startActivity(intent);
                                finish();
                            }
                        })
                        .setNegativeButton("취소", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                dialogInterface.dismiss();
                            }
                        }).show();
                return true;
            }
        }
        return super.onOptionsItemSelected(item);
    }
}