package hu.tanuloapp.afp;

import android.annotation.SuppressLint;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

public class QuizActivity extends AppCompatActivity {
    long timeLong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        StartTimer();
    }

    private void StartTimer() {
        new CountDownTimer(30000, 1000) {
            @SuppressLint("SetTextI18n")
            public void onTick(long millisUntilFinished) {
                TextView timer = findViewById(R.id.timer);
                timeLong = millisUntilFinished;
                String time = getResources().getString(R.string.time) + " ";
                timer.setText(time + ((timeLong / 1000) < 10 ?
                        "0" + String.valueOf(timeLong / 1000) : String.valueOf(timeLong / 1000)));
            }
            public void onFinish() {
                StopTimer();
            }
        }.start();
    }

    private void StopTimer() {
        Toast.makeText(this, "Következő kérdés", Toast.LENGTH_LONG).show();
        StartTimer();
    }

}
