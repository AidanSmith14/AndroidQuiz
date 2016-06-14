package bit.smithae4.androidquiz;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    MediaPlayer startgame, wrong;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startgame = MediaPlayer.create(this, R.raw.startgame);
        wrong = MediaPlayer.create(this, R.raw.wrong);
        Button button = (Button)findViewById(R.id.buttonStartQuiz);

        button.setOnClickListener(
                new Button.OnClickListener() {

                    public void onClick(View v) {
                        EditText editText = (EditText)findViewById(R.id.editText);
                        String username = "";
                        username = editText.getText().toString();
                        if(username.matches("")) {
                            wrong.start();
                            TextView textView2 = (TextView)findViewById(R.id.textView2);
                            textView2.setVisibility(View.VISIBLE);
                        }
                        else {
                            startgame.start();
                            Intent intent = new Intent (MainActivity.this, QuizQuestions.class);
                            intent.putExtra("username", username);
                            startActivity(intent);
                        }

                    }
                }
        );
    }
}



