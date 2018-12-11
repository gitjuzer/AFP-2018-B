package hu.tanuloapp.afp;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class QuizActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener {
    long timeLong;
    private ActionBarDrawerToggle mToggle;
    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        final Button ans1, ans2, ans3, ans4;
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        StartTimer();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nav_view);
        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }

        ans1 = findViewById(R.id.answer1);
        ans2 = findViewById(R.id.answer2);
        ans3 = findViewById(R.id.answer3);
        ans4 = findViewById(R.id.answer4);
        ans1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(ans1, true);
            }
        });
        ans2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(ans2, false);
            }
        });
        ans3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(ans3, true);
            }
        });
        ans4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CheckAnswer(ans4, false);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    private void CheckAnswer(Button sender, boolean correct) {
        if (correct)
            sender.setBackground(getDrawable(R.drawable.correct_btn_background));
        else
            sender.setBackground(getDrawable(R.drawable.wrong_btn_background));
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

    public void GoToActivity(Class toActivity) {
        Intent intent = new Intent(this, toActivity);
        finish();
        startActivity(intent);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if (id == R.id.profile) {
            GoToActivity(ProfilActivity.class);
        } else if (id == R.id.quiz) {
            GoToActivity(QuizActivity.class);
        } else if (id == R.id.logout) {
            GoToActivity(MainActivity.class);
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}
