package com.example.labon.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
 private Button mTrueButton;
  private Button mFalseButon;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        mTrueButton=(Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(QuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();

            }
        });

        mFalseButon=(Button) findViewById(R.id.false_button);
        mFalseButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
