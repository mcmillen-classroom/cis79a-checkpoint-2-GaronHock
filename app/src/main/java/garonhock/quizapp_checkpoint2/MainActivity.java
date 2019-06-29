package garonhock.quizapp_checkpoint2;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private TextView mTextView;
    private TextView mHintTextView;
    private TextView mScoreTextView;

    private boolean mIsHintShown = false;




    private Button mHintButton;
    private Button mTrueButton;
    private Button mFalseButton;
    private ImageButton mNextButton;
    private ImageButton mPreviousButton;


    private int mIndex; //Will store what question we are on
    private Question[] mQuestions;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTrueButton = (Button) findViewById(R.id.true_Button);
        mFalseButton = (Button) findViewById(R.id.false_Button);
        mNextButton = (ImageButton) findViewById(R.id.next_button);// The (Button) is a cast in java.
        mPreviousButton = (ImageButton) findViewById(R.id.previous_button);
        mHintButton = (Button) findViewById(R.id.hint_button);


        mTrueButton.setOnClickListener(this); //All of these (this) calls the onClickFunction
        mFalseButton.setOnClickListener(this);
        mNextButton.setOnClickListener(this);
        mPreviousButton.setOnClickListener(this);
        mHintButton.setOnClickListener(this);


        mTextView = (TextView) findViewById(R.id.text_view);
        mHintTextView = (TextView) findViewById(R.id.hint_text_view);


        //Initialize an array of questions
        mQuestions = new Question[5];
        mIndex = 0; //Will start at 0
        mQuestions[0] = new Question(R.string.question_1, true, R.string.Hint1);
        mQuestions[1] = new Question(R.string.question_2, false, R.string.Hint2);
        mQuestions[2] = new Question(R.string.question_3, true, R.string.Hint3);
        mQuestions[3] = new Question(R.string.question_4, true, R.string.Hint4);
        mQuestions[4] = new Question(R.string.question_5, false, R.string.Hint5);


        Scanner input = new Scanner(System.in);
        mTextView.setText(mQuestions[mIndex].getTextResId());
        mHintTextView.setText(mQuestions[mIndex].getHintTextId());
        mHintTextView.setVisibility(View.GONE);

    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.true_Button) {
            checkAnswer(true);
            mIndex++;


        }
        else if (view.getId() == R.id.false_Button){
            checkAnswer(false);
            mIndex++;
        }
        else if (view.getId() == R.id.next_button){
            //must increment array to show text of next button
            mIndex++;
            if (mIndex >= mQuestions.length){
                mIndex = 0;
            }

            mTextView.setText(mQuestions[mIndex].getTextResId());
            mHintTextView.setText(mQuestions[mIndex].getHintTextId());
        }
        else if (view.getId() == R.id.previous_button){
            mIndex--;
            if (mIndex < 1){
                mIndex = 0;
            }
            mTextView.setText(mQuestions[mIndex].getTextResId());
            mHintTextView.setText(mQuestions[mIndex].getHintTextId());

        }
        else if (view.getId() == R.id.hint_button)
        {
            mIsHintShown = !mIsHintShown;
            if (mIsHintShown)
            {
                mHintTextView.setVisibility(View.VISIBLE);



            }
            else
            {
                mHintTextView.setVisibility(View.GONE);
            }
        }

    }

    public boolean checkAnswer(boolean userInput){
        if (mQuestions[mIndex].isAnswer() == userInput){
            Toast myToast = Toast.makeText(this, "You are correct", Toast.LENGTH_SHORT);
            myToast.setGravity(Gravity.TOP, 0, 0);
            myToast.show();
//            score++;
//            Toast anotherToast = Toast.makeText(this, "Score: " + score, Toast.LENGTH_SHORT);
//            anotherToast.setGravity(Gravity.BOTTOM, 0, 0);
//            anotherToast.show();
//            return true;
            return true;

        }
        else {
            Toast myToast = Toast.makeText(this, "You are incorrect", Toast.LENGTH_SHORT);
            myToast.setGravity(Gravity.TOP, 0, 0);
            myToast.show();
//            score--;
//            Toast anotherToast = Toast.makeText(this, "Score: " + score, Toast.LENGTH_SHORT);
//            anotherToast.setGravity(Gravity.BOTTOM, 0, 0);
//            anotherToast.show();
//            return false;
            return false;
        }
    }
}
