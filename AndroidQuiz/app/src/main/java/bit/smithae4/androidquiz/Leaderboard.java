package bit.smithae4.androidquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Leaderboard extends AppCompatActivity {
    MediaPlayer buttons;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_leaderboard);
        buttons = MediaPlayer.create(this, R.raw.buttons);
        Button button = (Button)findViewById(R.id.backHome);
        Intent mIntent = getIntent();
        String user1 = mIntent.getExtras().getString("user1");
        int highscore1 = mIntent.getIntExtra("highscore1", 0);
        String user2 = mIntent.getExtras().getString("user2");
        int highscore2 = mIntent.getIntExtra("highscore2", 0);
        String user3 = mIntent.getExtras().getString("user3");
        int highscore3 = mIntent.getIntExtra("highscore3", 0);
        String user4 = mIntent.getExtras().getString("user4");
        int highscore4 = mIntent.getIntExtra("highscore4", 0);
        String user5 = mIntent.getExtras().getString("user5");
        int highscore5 = mIntent.getIntExtra("highscore5", 0);
        TextView textView10 = (TextView)findViewById(R.id.textView10);
        TextView textView11 = (TextView)findViewById(R.id.textView11);
        TextView textView12 = (TextView)findViewById(R.id.textView12);
        TextView textView13 = (TextView)findViewById(R.id.textView13);
        TextView textView14 = (TextView)findViewById(R.id.textView14);
        textView10.setText("1. " + user1 + " " + highscore1 + "%");
        textView11.setText("2. " + user2 + " " + highscore2 + "%");
        textView12.setText("3. " + user3 + " " + highscore3 + "%");
        textView13.setText("4. " + user4 + " " + highscore4 + "%");
        textView14.setText("5. " + user5 + " " + highscore5 + "%");

        button.setOnClickListener(
                new Button.OnClickListener() {

                    public void onClick(View v) {
                        buttons.start();
                        Intent intent = new Intent(Leaderboard.this, MainActivity.class);
                        startActivity(intent);
                    }
                }

        );
    }
}
