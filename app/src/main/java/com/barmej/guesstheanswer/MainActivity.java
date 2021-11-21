package com.barmej.guesstheanswer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
 private TextView mTextViewQuestion;


    private static final String[] QUESTIONS = {
            "العملة الرسمية لدولة الكويت هي الريال الكويتي؟",
            "توبقال هي أعلى قمة جبلية في العالم العربي؟",
            "الجزائر هي أكبر دولة عربية من حيث المساحة؟",
            "الدار البيضاء هي عاصمة المغرب؟",
            "كابول هى عاصمة افغانستان؟",
            "اضخم الحيوانات اللافقرية هو القنديل؟",
            "الدولة العربية التي يمر بها خط الاستواء هى السودان؟",
            "القلب هو أكبر عضو في جسم الإنسان؟",
            "أول مسجد في الإسلام هو المسجد النبوي؟",
            "الخال الوحيد لأولاد عمتك هو والدك؟",
            "اولى دول العالم انتاجا للموز هى الاكوادور؟",
            "الأرجنتين عاصمتها باكو؟",
            "عملة فيتنام هى دونج؟"
    };

    private static final boolean[] ANSWERS = {
            false,
            true,
            true,
            false,
            true,
            false,
            false,
            false,
            false,
            true,
            true,
            false,
            true
    };

    private static final String[] ANSWERS_DETAILS = {
            "العملة الرسمية لدولة الكويت هي الدينار الكويتي",
            "توبقال هي أعلى قمة جبلية في العالم العربي و تقع في المغرب",
            "الجزائر هي أكبر دولة عربية و إفريقية من حيث المساحة",
            "الرباط هي عاصمة المغرب",
            "كابول هى عاصمة افغانستان",
            "اضخم الحيوانات اللافقرية هو الحبار",
            "الدولة العربية التي يمر بها خط الاستواء هى الصومال",
            "الكبد هو أكبر عضو في جسم الإنسان",
            "أول مسجد في الإسلام هو مسجد قباء",
            "الخال الوحيد لأولاد عمتك هو والدك",
            "اولى دول العالم انتاجا للموز هى الاكوادور",
            "الأرجنتين عاصمتها بونس إيرس",
            "عملة فيتنام هى دونج"
    };


          int index=0;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTextViewQuestion=findViewById(R.id.textViewQuestion);
        showNewQuestion();


       }


    private  String mCurrentQuestion,mCurrentDetails ,mTextViewAnswer;
    private boolean mCurrentAnswer;


private void showNewQuestion(){
    Random random=new Random();
    int randomQuestionIndex=random.nextInt(QUESTIONS.length);
    mCurrentQuestion=QUESTIONS[randomQuestionIndex];
    mCurrentAnswer=ANSWERS[randomQuestionIndex];
    mCurrentDetails = ANSWERS_DETAILS[randomQuestionIndex];
    mTextViewQuestion.setText(mCurrentQuestion);

};
    public void onChangQuestion(View view) {
           showNewQuestion();
    }


    public void onTrueQuestion(View view) {
        if (mCurrentAnswer == true) {
            Toast.makeText(this, "اجابه صحيحة", Toast.LENGTH_SHORT).show();
            showNewQuestion();

        } else {
            Toast.makeText(this, "اجابة خاطئة", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this,AnswerActivity.class);
            intent.putExtra("question_answer",mCurrentDetails);
            startActivity(intent);


        }
    }

    public void onFalseQuestion(View view) {
        if (mCurrentAnswer == false) {
            Toast.makeText(this, "اجابه صحيحة", Toast.LENGTH_SHORT).show();
            showNewQuestion();

        } else {
            Toast.makeText(this, "اجابة خاطئة", Toast.LENGTH_SHORT).show();
            Intent intent=new Intent(MainActivity.this,AnswerActivity.class);
            intent.putExtra("question_answer",mCurrentDetails);
            startActivity(intent);
        }



    }

    public void onShareQuestionActivity(View view) {
        Intent intent=new Intent(MainActivity.this,ShareActivity.class);
        intent.putExtra("shareQuestion",mCurrentQuestion);
        startActivity(intent);
    }
}
