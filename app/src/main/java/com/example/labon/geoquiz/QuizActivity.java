package com.example.labon.geoquiz;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import static android.view.Gravity.CENTER_HORIZONTAL;
import static android.view.Gravity.TOP;
import static android.widget.Toast.makeText;

public class QuizActivity extends AppCompatActivity {
    private static final String TAG= "QuizActivity";
    private static final String KEY_INDEX="index";
    private Button mTrueButton;
    private Button mFalseButon;
    private Button mNextButton;
    private Button mPervButton;
    private TextView mQuestionTextView;
    private Question[]mQuestionsBank = new Question[]{
            new Question(R.string.question_australia,true) ,
            new Question(R.string.question_Ocean,true),
            new Question(R.string.question_mideast,false),
            new Question(R.string.question_africa,false),
            new Question(R.string.question_america,true),
            new Question(R.string.question_asia,true),
    };
    private int mCurrentIndex=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG,"onCreate(Bundle)called");
        setContentView(R.layout.activity_quiz);
                    /*saving data*/
                    if(savedInstanceState != null){
                        mCurrentIndex = savedInstanceState.getInt(KEY_INDEX,0);
                    }
        mQuestionTextView=(TextView) findViewById(R.id.question_text_view) ;
        mQuestionTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex+1)% mQuestionsBank.length;
                UpdateQuestion();
            }
        });

        mTrueButton=(Button) findViewById(R.id.true_button);
        mTrueButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Toast.makeText(QuizActivity.this,R.string.correct_toast,Toast.LENGTH_SHORT).show();
                CheckAnswer(true);
//                mTrueButton.setEnabled(false);
            }
        });

        mFalseButon=(Button) findViewById(R.id.false_button);
        mFalseButon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(false);
            }
        });
        mNextButton=(Button) findViewById(R.id.next_button);
        mNextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mCurrentIndex = (mCurrentIndex+1)% mQuestionsBank.length;
                UpdateQuestion();
            }
        });
        mPervButton=(Button) findViewById(R.id.prev_button);
        mPervButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           /*     mCurrentIndex = (mCurrentIndex-1)% mQuestionsBank.length;
                UpdateQuestion();*/
            }
        });
        UpdateQuestion();
    }
    private void  UpdateQuestion(){
        int question= mQuestionsBank[mCurrentIndex].getTextResID();
        mQuestionTextView.setText(question);
//        mTrueButton.setEnabled(true);
    }
    /*Compare user Answer with Question answer and the display Toast */
    private void CheckAnswer(boolean userPressedTrue){
        boolean answerIsTrue = mQuestionsBank[mCurrentIndex].isAnswerTrue();
        int messageResId;
                if(userPressedTrue == answerIsTrue)
                {
                    messageResId = R.string.correct_toast;
                }
                else{
                    messageResId = R.string.incorrect_toast;
                }
               /*How to change the toast position
                Toast myToast = Toast.makeText(QuizActivity.this,messageResId,Toast.LENGTH_SHORT);
                myToast.setGravity(TOP|CENTER_HORIZONTAL, 0, 0);
                myToast.show();*/

                 Toast.makeText(QuizActivity.this,messageResId,Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onSaveInstanceState(Bundle  saveInstanceState) {
        super.onSaveInstanceState( saveInstanceState);
        Log.i(TAG," onSaveInstanceState");
        saveInstanceState.getInt(KEY_INDEX,mCurrentIndex);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG,"onStart()Called");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop()Called");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG,"onPause()Called");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG,"onResume()Called");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG," onDestroy()Called");
    }
}

