package garonhock.quizapp_checkpoint2;

public class Question {
    private int mTextResId;
    private boolean mAnswer;
    private int mHintTextId;


    public Question(int textResId, boolean answer, int hintTextId) {
        mTextResId = textResId;
        mAnswer = answer;
        mHintTextId = hintTextId;


    }

    public int getTextResId() {
        return mTextResId;
    }

    public void setTextResId(int textResId) {
        mTextResId = textResId;
    }

    public boolean isAnswer() {
        return mAnswer;
    }

    public void setAnswer(boolean answer) {
        mAnswer = answer;
    }

    public int getHintTextId() {
        return mHintTextId;
    }



}

