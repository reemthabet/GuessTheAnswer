package com.barmej.guesstheanswer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class ShareActivity extends AppCompatActivity {
private String mQuestionText;
public EditText mEditTextShare;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_share);
        mQuestionText=getIntent().getStringExtra("shareQuestion");
        mEditTextShare= findViewById(R.id.editTextTextShareTitel);
        SharedPreferences sharedPreferences=getSharedPreferences("appPref",MODE_PRIVATE);
        String questionTitle=sharedPreferences.getString("share title","");
        mEditTextShare.setText(questionTitle);
    }

    public void onShareQuestion(View view) {
       String questionTitle=mEditTextShare.getText().toString();
        Intent shareIntent=new Intent();
        shareIntent.setAction(Intent.ACTION_SEND);
        shareIntent.putExtra(Intent.EXTRA_TEXT,questionTitle+"/n"+mQuestionText);
        shareIntent.setType("text/plain");
        startActivity(shareIntent);

        SharedPreferences sharedPreferences = getSharedPreferences("app_pref", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("share_title", questionTitle);
        editor.apply();

    }
}