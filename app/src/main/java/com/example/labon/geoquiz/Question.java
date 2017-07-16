package com.example.labon.geoquiz;

/**
 * Created by Labon on 15/07/17.
 */

public class Question {
    private int mTextResID;
    private boolean mAnswerTrue;

    public Question(int mTextResID, boolean mAnswerTrue) {
        this.mTextResID = mTextResID;
        this.mAnswerTrue = mAnswerTrue;
    }

    public int getTextResID() {
        return mTextResID;
    }

    public void setTextResID(int textResID) {
        mTextResID = textResID;
    }

    public boolean isAnswerTrue() {
        return mAnswerTrue;
    }

    public void setAnswerTrue(boolean answerTrue) {
        mAnswerTrue = answerTrue;
    }
}
