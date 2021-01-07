package com.dtps.chadwickschoolmeals;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;

import com.dtps.chadwickschoolmeals.interfaces.GetMenuView;
import com.dtps.chadwickschoolmeals.models.GetMenuResponse;
import com.dtps.chadwickschoolmeals.services.GetMenuService;
import com.dtps.chadwickschoolmeals.services.SignInService;

import com.dtps.chadwickschoolmeals.services.SignInService;

import java.util.Calendar;

public class HomeActivity extends AppCompatActivity {

    Toolbar home_toolbar;
    DatePicker datepicker;
    Button home_btn_RegisterMeal;
    Button home_btn_gotoKoreanEvaluate;
    Button home_btn_gotoIntlEvaluate;
    Button home_btn_gotoNoodleEvaluate;
    private int mYear,mMonth,mDate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        home_toolbar = (Toolbar) findViewById(R.id.home_toolbar);
        setSupportActionBar(home_toolbar);

      //  getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setUp();
        activityMover();

        if(ApplicationClass.authority == SignInService.STUDENT){
            home_btn_RegisterMeal.setVisibility(View.GONE);
        }

        final Calendar calendar = Calendar.getInstance();
        mYear = calendar.get(Calendar.YEAR);
        mMonth = calendar.get(Calendar.MONTH);
        mDate = calendar.get(Calendar.DATE);

        datepicker.init(mYear, mMonth, mDate, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker datePicker, int year, int month, int date) {
                mYear = year;
                mMonth = month;
                mDate = date;
            }
        });
    }

    public void setUp(){
        datepicker = (DatePicker)findViewById(R.id.datepicker);
        home_btn_RegisterMeal = (Button)findViewById(R.id.home_btn_RegisterMeal);
        home_btn_gotoKoreanEvaluate = (Button)findViewById(R.id.home_btn_gotoKoreanEvaluate);
        home_btn_gotoIntlEvaluate = (Button)findViewById(R.id.home_btn_gotoIntlEvaluate);
        home_btn_gotoNoodleEvaluate = (Button)findViewById(R.id.home_btn_gotoNoodleEvaluate);
    }

    public void activityMover(){

        home_btn_RegisterMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, RegisterMealActivity.class);
                intent.putExtra("year",mYear);
                intent.putExtra("month",mMonth);
                intent.putExtra("date",mDate);
                startActivity(intent);
                finish();
            }
        });

        home_btn_gotoKoreanEvaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, EvaluateActivity.class);
                intent.putExtra("year",mYear);
                intent.putExtra("month",mMonth);
                intent.putExtra("date",mDate);
                intent.putExtra("foodIdx",1);
                startActivity(intent);
                finish();

            }
        });

        home_btn_gotoIntlEvaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, EvaluateActivity.class);
                intent.putExtra("year",mYear);
                intent.putExtra("month",mMonth);
                intent.putExtra("date",mDate);
                intent.putExtra("foodIdx",2);
                startActivity(intent);
                finish();

            }
        });

        home_btn_gotoNoodleEvaluate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this, EvaluateActivity.class);
                intent.putExtra("year",mYear);
                intent.putExtra("month",mMonth);
                intent.putExtra("date",mDate);
                intent.putExtra("foodIdx",3);
                startActivity(intent);
                finish();

            }
        });
    }

    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(HomeActivity.this)
                .setMessage("Do you want to close the App?")
                .setPositiveButton("exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                        finish();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).show();
    }

}