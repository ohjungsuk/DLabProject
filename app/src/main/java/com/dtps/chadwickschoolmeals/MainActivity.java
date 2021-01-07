package com.dtps.chadwickschoolmeals;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.Toast;

import com.dtps.chadwickschoolmeals.interfaces.SignInActivityView;
import com.dtps.chadwickschoolmeals.models.SignInResponse;
import com.dtps.chadwickschoolmeals.services.SignInService;

import static com.dtps.chadwickschoolmeals.ApplicationClass.X_ACCESS_TOKEN;

public class MainActivity extends AppCompatActivity implements SignInActivityView {

    EditText main_edtTv_id;
    EditText main_edtTv_pw;
    Button main_btn_signIn;
    Button main_btn_makeId;
    CheckBox main_cBox_student;
    CheckBox main_cBox_teacher;
    int sign_in_flag = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setUp();
        setListeners();
    }

    public void setUp(){
        main_edtTv_id = (EditText)findViewById(R.id.main_edtTv_id);
        main_edtTv_pw = (EditText)findViewById(R.id.main_edtTv_pw);
        main_btn_signIn = (Button)findViewById(R.id.main_btn_signIn);
        main_btn_makeId = (Button)findViewById(R.id.main_btn_makeId);
        main_cBox_student = (CheckBox)findViewById(R.id.main_cBox_student);
        main_cBox_teacher = (CheckBox)findViewById(R.id.main_cBox_teacher);
    }

    public void setListeners(){
        activityMover();
        setCheckBoxListeners();
    }

    public void setCheckBoxListeners(){

        main_cBox_student.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    sign_in_flag = SignInService.STUDENT;
                    ApplicationClass.authority = SignInService.STUDENT;
                    if(main_cBox_teacher.isChecked()) {
                        main_cBox_teacher.setChecked(false);
                    }
                }
                Log.d("flag_debug", String.valueOf(sign_in_flag));
            }
        });

        main_cBox_teacher.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if(b){
                    sign_in_flag = SignInService.TEACHER;
                    ApplicationClass.authority = SignInService.TEACHER;
                    if(main_cBox_student.isChecked()) {
                        main_cBox_student.setChecked(false);
                    }
                }
                Log.d("flag_debug", String.valueOf(sign_in_flag));
            }

        });

    }

    public void activityMover(){
        main_btn_signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(sign_in_flag != -1) {
                    new SignInService(MainActivity.this).postSignIn(main_edtTv_id.getText().toString(),
                            main_edtTv_pw.getText().toString(),
                            sign_in_flag
                    );
                }else{
                    Toast.makeText(MainActivity.this, "Select your job!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        main_btn_makeId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,SignUpActivity.class);

                startActivity(intent);
                finish();
            }
        });
    }

    private void saveAccessToken(String jwt){
        SharedPreferences.Editor editor = ApplicationClass.sSharedPreferences.edit();
        editor.putString(X_ACCESS_TOKEN, jwt);
        editor.apply();
    }

    @Override
    public void validateFailure() {
        Toast.makeText(MainActivity.this, "networking error!", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void validateSuccess(SignInResponse response) {
        if(response == null){
  //          Toast.makeText(MainActivity.this, "something wrong in validateSuccess", Toast.LENGTH_SHORT).show();
        }else{
            switch(response.getCode()){
                case 200:
                    saveAccessToken(response.getJwt());
                    Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                    startActivity(intent);
                    finish();
                    Toast.makeText(MainActivity.this, "welcome!", Toast.LENGTH_SHORT).show();
                    break;
                case 400:
                    Toast.makeText(MainActivity.this, "Invalid ID/PW format", Toast.LENGTH_SHORT).show();
                    break;
                case 404:
                    Toast.makeText(MainActivity.this, "ID/PW does not exist", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }


}