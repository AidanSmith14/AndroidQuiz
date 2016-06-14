package bit.smithae4.androidquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;


public class QuizQuestions extends AppCompatActivity {
    int count;
    double score;
    String[] question, answer;
    String username;
    MediaPlayer correct, wrong, wronganswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_questions);
        correct = MediaPlayer.create(this, R.raw.correct);
        wrong = MediaPlayer.create(this, R.raw.wrong);
        wronganswer = MediaPlayer.create(this, R.raw.wronganswer);
        Intent intent = getIntent();
        username = intent.getExtras().getString("username");
        Button button = (Button)findViewById(R.id.button);
        question = new String[25];
        question[0] = "Who won the 1987 Rugby World Cup?";
        question[1] = "Australia";
        question[2] = "New Zealand";
        question[3] = "France";
        question[4] = "England";
        question[5] = "What Super Rugby team did Tony Brown play for?";
        question[6] = "Crusaders";
        question[7] = "Waratahs";
        question[8] = "Bulls";
        question[9] = "Highlanders";
        question[10] = "How many players are there on a team?";
        question[11] = "15";
        question[12] = "13";
        question[13] = "11";
        question[14] = "7";
        question[15] = "Australia is also known as the:";
        question[16] = "All Blacks";
        question[17] = "Springbok";
        question[18] = "Wallabies";
        question[19] = "Underarm Bowlers";
        question[20] = "What position does a number 9 play?";
        question[21] = "Half Back";
        question[22] = "Prop";
        question[23] = "Winger";
        question[24] = "Center";
        answer = new String[5];
        answer[0] = "New Zealand";
        answer[1] = "Highlanders";
        answer[2] = "15";
        answer[3] = "Wallabies";
        answer[4] = "Half Back";
        count = 1;
        score = 0;
        setQuestion();

        button.setOnClickListener(
                new Button.OnClickListener() {

                    public void onClick(View v) {
                        RadioButton rb1, rb2, rb3, rb4, rb5;
                        rb1 = (RadioButton) findViewById(R.id.radioButton);
                        rb2 = (RadioButton) findViewById(R.id.radioButton2);
                        rb3 = (RadioButton) findViewById(R.id.radioButton3);
                        rb4 = (RadioButton) findViewById(R.id.radioButton4);
                        rb5 = (RadioButton) findViewById(R.id.radioButton5);
                        TextView textView5 = (TextView)findViewById(R.id.textView5);

                        if(rb1.isChecked() | rb2.isChecked() | rb3.isChecked() | rb4.isChecked()) {
                            if (count == 1 & rb2.isChecked() | count == 2 & rb4.isChecked() | count == 3 & rb1.isChecked() | count == 4 & rb3.isChecked() | count == 5 & rb1.isChecked()){
                                score++;
                                correct.start();
                            }
                            else
                            {
                                wronganswer.start();
                            }
                            textView5.setVisibility(View.INVISIBLE);
                            rb1.setChecked(false);
                            rb2.setChecked(false);
                            rb3.setChecked(false);
                            rb4.setChecked(false);
                            rb5.setChecked(true);
                            count++;
                            if (count > 5) {
                                Intent intent = new Intent(QuizQuestions.this, FinalPage.class);
                                intent.putExtra("username", username);
                                intent.putExtra("score", score);
                                startActivity(intent);
                            }
                            else{
                                setQuestion();
                            }
                        }
                        else {
                            textView5.setVisibility(View.VISIBLE);
                            wrong.start();
                        }

                    }
                }
        );
    }

    public void setQuestion() {
        if (count == 1) {
            ((TextView) findViewById(R.id.textView3)).setText("Question " + count);
            ((TextView) findViewById(R.id.textView4)).setText(question[(count - 1) * 5]);
            ((RadioButton) findViewById(R.id.radioButton)).setText(question[(count - 1) * 5 + 1]);
            ((RadioButton) findViewById(R.id.radioButton2)).setText(question[(count - 1) * 5 + 2]);
            ((RadioButton) findViewById(R.id.radioButton3)).setText(question[(count - 1) * 5 + 3]);
            ((RadioButton) findViewById(R.id.radioButton4)).setText(question[(count - 1) * 5 + 4]);

        }
        if (count == 2) {
            ((TextView) findViewById(R.id.textView3)).setText("Question " + count);
            ((TextView) findViewById(R.id.textView4)).setText(question[(count - 1) * 5]);
            ((RadioButton) findViewById(R.id.radioButton)).setText(question[(count - 1) * 5 + 1]);
            ((RadioButton) findViewById(R.id.radioButton2)).setText(question[(count - 1) * 5 + 2]);
            ((RadioButton) findViewById(R.id.radioButton3)).setText(question[(count - 1) * 5 + 3]);
            ((RadioButton) findViewById(R.id.radioButton4)).setText(question[(count - 1) * 5 + 4]);

        }
        if (count == 3) {
            ((TextView) findViewById(R.id.textView3)).setText("Question " + count);
            ((TextView) findViewById(R.id.textView4)).setText(question[(count - 1) * 5]);
            ((RadioButton) findViewById(R.id.radioButton)).setText(question[(count - 1) * 5 + 1]);
            ((RadioButton) findViewById(R.id.radioButton2)).setText(question[(count - 1) * 5 + 2]);
            ((RadioButton) findViewById(R.id.radioButton3)).setText(question[(count - 1) * 5 + 3]);
            ((RadioButton) findViewById(R.id.radioButton4)).setText(question[(count - 1) * 5 + 4]);

        }
        if (count == 4) {
            ((TextView) findViewById(R.id.textView3)).setText("Question " + count);
            ((TextView) findViewById(R.id.textView4)).setText(question[(count - 1) * 5]);
            ((RadioButton) findViewById(R.id.radioButton)).setText(question[(count - 1) * 5 + 1]);
            ((RadioButton) findViewById(R.id.radioButton2)).setText(question[(count - 1) * 5 + 2]);
            ((RadioButton) findViewById(R.id.radioButton3)).setText(question[(count - 1) * 5 + 3]);
            ((RadioButton) findViewById(R.id.radioButton4)).setText(question[(count - 1) * 5 + 4]);

        }
        if (count == 5) {
            ((TextView) findViewById(R.id.textView3)).setText("Question " + count);
            ((TextView) findViewById(R.id.textView4)).setText(question[(count - 1) * 5]);
            ((RadioButton) findViewById(R.id.radioButton)).setText(question[(count - 1) * 5 + 1]);
            ((RadioButton) findViewById(R.id.radioButton2)).setText(question[(count - 1) * 5 + 2]);
            ((RadioButton) findViewById(R.id.radioButton3)).setText(question[(count - 1) * 5 + 3]);
            ((RadioButton) findViewById(R.id.radioButton4)).setText(question[(count - 1) * 5 + 4]);

        }
    }




}


