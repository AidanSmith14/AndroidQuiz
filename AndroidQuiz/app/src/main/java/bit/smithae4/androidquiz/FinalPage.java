package bit.smithae4.androidquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.nfc.Tag;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class FinalPage extends AppCompatActivity {
    MediaPlayer buttons;
    String user1, user2, user3, user4, user5;
    int highscore1, highscore2, highscore3, highscore4, highscore5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);
        buttons = MediaPlayer.create(this, R.raw.buttons);
        Button button = (Button)findViewById(R.id.buttonHome);
        Button button2 = (Button)findViewById(R.id.leaderboard);
        Intent mIntent = getIntent();
        String username = mIntent.getExtras().getString("username");
        double finalScore = (double) mIntent.getDoubleExtra("score", 0);
        finalScore = (finalScore / 5) * 100;
        int finalPercent = (int)finalScore;
        TextView textView7 = (TextView)findViewById(R.id.textView7);
        textView7.setText(finalPercent + "%");
        TextView textView8 = (TextView)findViewById(R.id.textView8);
        textView8.setText(username);
        SharedPreferences prefs1 = this.getSharedPreferences("highscore1", Context.MODE_PRIVATE);
        SharedPreferences prefs11 = this.getSharedPreferences("user1", Context.MODE_PRIVATE);
        SharedPreferences prefs2 = this.getSharedPreferences("highscore2", Context.MODE_PRIVATE);
        SharedPreferences prefs22 = this.getSharedPreferences("user2", Context.MODE_PRIVATE);
        SharedPreferences prefs3 = this.getSharedPreferences("highscore3", Context.MODE_PRIVATE);
        SharedPreferences prefs33 = this.getSharedPreferences("user3", Context.MODE_PRIVATE);
        SharedPreferences prefs4 = this.getSharedPreferences("highscore4", Context.MODE_PRIVATE);
        SharedPreferences prefs44 = this.getSharedPreferences("user4", Context.MODE_PRIVATE);
        SharedPreferences prefs5 = this.getSharedPreferences("highscore5", Context.MODE_PRIVATE);
        SharedPreferences prefs55 = this.getSharedPreferences("user5", Context.MODE_PRIVATE);
        highscore1 = prefs1.getInt("highscore1", 0);
        user1 = prefs11.getString("user1", "Empty");
        highscore2 = prefs2.getInt("highscore2", 0);
        user2 = prefs22.getString("user2", "Empty");
        highscore3 = prefs3.getInt("highscore3", 0);
        user3 = prefs33.getString("user3", "Empty");
        highscore4 = prefs4.getInt("highscore4", 0);
        user4 = prefs44.getString("user4", "Empty");
        highscore5 = prefs5.getInt("highscore5", 0);
        user5 = prefs55.getString("user5", "Empty");
        SharedPreferences.Editor editor1 = prefs1.edit();
        SharedPreferences.Editor editor11 = prefs11.edit();
        SharedPreferences.Editor editor2 = prefs2.edit();
        SharedPreferences.Editor editor22 = prefs22.edit();
        SharedPreferences.Editor editor3 = prefs3.edit();
        SharedPreferences.Editor editor33 = prefs33.edit();
        SharedPreferences.Editor editor4 = prefs4.edit();
        SharedPreferences.Editor editor44 = prefs44.edit();
        SharedPreferences.Editor editor5 = prefs5.edit();
        SharedPreferences.Editor editor55 = prefs55.edit();
        if(finalPercent > highscore5)
        {
            if(finalPercent > highscore4)
            {
                if(finalPercent > highscore3)
                {
                    if(finalPercent > highscore2)
                    {
                        if(finalPercent > highscore1)
                        {
                            highscore5 = highscore4;
                            user5 = user4;
                            highscore4 = highscore3;
                            user4 = user3;
                            highscore3 = highscore2;
                            user3 = user2;
                            highscore2 = highscore1;
                            user2 = user1;
                            highscore1 = finalPercent;
                            user1 = username;
                        }
                        else
                        {
                            highscore5 = highscore4;
                            user5 = user4;
                            highscore4 = highscore3;
                            user4 = user3;
                            highscore3 = highscore2;
                            user3 = user2;
                            highscore2 = finalPercent;
                            user2 = username;
                        }
                    }
                    else
                    {
                        highscore5 = highscore4;
                        user5 = user4;
                        highscore4 = highscore3;
                        user4 = user3;
                        highscore3 = finalPercent;
                        user3 = username;
                    }
                }
                else
                {
                    highscore5 = highscore4;
                    user5 = user4;
                    highscore4 = finalPercent;
                    user4 = username;
                }
            }
            else
            {
                highscore5 = finalPercent;
                user5 = username;
            }
        }

        editor1.putInt("highscore1", highscore1);
        editor11.putString("user1", user1);
        editor1.commit();
        editor11.commit();
        editor2.putInt("highscore2", highscore2);
        editor22.putString("user2", user2);
        editor2.commit();
        editor22.commit();
        editor3.putInt("highscore3", highscore3);
        editor33.putString("user3", user3);
        editor3.commit();
        editor33.commit();
        editor4.putInt("highscore4", highscore4);
        editor44.putString("user4", user4);
        editor4.commit();
        editor44.commit();
        editor5.putInt("highscore5", highscore5);
        editor55.putString("user5", user5);
        editor5.commit();
        editor55.commit();

        button.setOnClickListener(
                new Button.OnClickListener() {

                    public void onClick(View v) {
                        buttons.start();
                        Intent intent = new Intent(FinalPage.this, MainActivity.class);
                        startActivity(intent);
                    }
                }

        );

        button2.setOnClickListener(
                new Button.OnClickListener() {

                    public void onClick(View v) {
                        buttons.start();
                        Intent intent = new Intent(FinalPage.this, Leaderboard.class);
                        intent.putExtra("user1", user1);
                        intent.putExtra("highscore1", highscore1);
                        intent.putExtra("user2", user2);
                        intent.putExtra("highscore2", highscore2);
                        intent.putExtra("user3", user3);
                        intent.putExtra("highscore3", highscore3);
                        intent.putExtra("user4", user4);
                        intent.putExtra("highscore4", highscore4);
                        intent.putExtra("user5", user5);
                        intent.putExtra("highscore5", highscore5);
                        startActivity(intent);
                    }
                }

        );

    }

}
