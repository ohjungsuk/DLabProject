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
import android.widget.Toast;

import com.dtps.chadwickschoolmeals.interfaces.RegisterMealActivityView;
import com.dtps.chadwickschoolmeals.models.RegisterMealResponse;
import com.dtps.chadwickschoolmeals.services.RegisterMealService;
import com.dtps.chadwickschoolmeals.services.SignUpService;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class RegisterMealActivity extends AppCompatActivity implements RegisterMealActivityView{

    androidx.appcompat.widget.Toolbar registerMeal_toolbar;
    FloatingActionButton fab;
    String date;
    TextView registerMeal_txt_date;
    ArrayList koreanL = new ArrayList<String>();
    ArrayList internationalL = new ArrayList<String>();
    ArrayList noodleL = new ArrayList<String>();
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


        Intent intent = getIntent();
        int nyear = intent.getExtras().getInt("year");
        int nmonth = intent.getExtras().getInt("month");
        int ndate = intent.getExtras().getInt("date");
        date = ((String.format("%04d-%02d-%02d",nyear,nmonth+1,ndate)));

        Toast.makeText(this, date, Toast.LENGTH_SHORT).show();

        registerMeal_txt_date.setText((String.format("%4d년 %2d월 %2d일",nyear,nmonth+1,ndate)));



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
                                koreanL.add(registerMeal_edt_m1.getText().toString());
                                koreanL.add(registerMeal_edt_m2.getText().toString());
                                koreanL.add(registerMeal_edt_m3.getText().toString());
                                koreanL.add(registerMeal_edt_m4.getText().toString());
                                koreanL.add(registerMeal_edt_m5.getText().toString());
                                koreanL.add(registerMeal_edt_m6.getText().toString());

                                internationalL.add(registerMeal_edt_mInt1.getText().toString());
                                internationalL.add(registerMeal_edt_mInt2.getText().toString());
                                internationalL.add(registerMeal_edt_mInt3.getText().toString());
                                internationalL.add(registerMeal_edt_mInt4.getText().toString());
                                internationalL.add(registerMeal_edt_mInt5.getText().toString());
                                internationalL.add(registerMeal_edt_mInt6.getText().toString());

                                noodleL.add(registerMeal_edt_mNd1.getText().toString());
                                noodleL.add(registerMeal_edt_mNd2.getText().toString());
                                noodleL.add(registerMeal_edt_mNd3.getText().toString());
                                noodleL.add(registerMeal_edt_mNd4.getText().toString());
                                noodleL.add(registerMeal_edt_mNd5.getText().toString());
                                noodleL.add(registerMeal_edt_mNd6.getText().toString());
                                new RegisterMealService(RegisterMealActivity.this).postKorean(
                                        date,
                                        1,
                                        koreanL
                                );
                                new RegisterMealService(RegisterMealActivity.this).postInternational(
                                        date,
                                        2,
                                        internationalL
                                );
                                new RegisterMealService(RegisterMealActivity.this).postNoodle(
                                        date,
                                        3,
                                        noodleL
                                );
//                                Intent intent = new Intent(RegisterMealActivity.this,HomeActivity.class);
//                                startActivity(intent);
//                                finish();
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

    @Override
    public void validateSuccess(RegisterMealResponse response) {
        if(response == null){
            Toast.makeText(RegisterMealActivity.this, "something wrong in validateSuccess", Toast.LENGTH_SHORT).show();
        }else{
            switch(response.getCode()){
                case 200:
                    Toast.makeText(RegisterMealActivity.this, "메뉴등록 완료", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(RegisterMealActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                    break;
                case 400:
                    Toast.makeText(RegisterMealActivity.this, "Type Error!", Toast.LENGTH_SHORT).show();
                    break;
                case 403:
                    Toast.makeText(RegisterMealActivity.this, "인증된 사용자가 아닙니다.", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }

    @Override
    public void validateFailure() {
        Toast.makeText(this, "메뉴 등록 실패", Toast.LENGTH_LONG).show();
    }

}