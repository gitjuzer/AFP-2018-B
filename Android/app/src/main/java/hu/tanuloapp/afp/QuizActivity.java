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
import android.widget.TextView;
import android.widget.Toast;

import java.util.Objects;

public class QuizActivity extends AppCompatActivity {
    long timeLong;
    private ActionBarDrawerToggle mToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        StartTimer();
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        DrawerLayout mDrawerLayout = findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nav_view);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                int id = menuItem.getItemId();
                menuItem.setChecked(true);
                if(id == R.id.profile){
                    GoToActivity(ProfilActivity.class);
                }else if(id == R.id.quiz){
                    GoToActivity(QuizActivity.class);
                }else if(id == R.id.logout){

                }

                DrawerLayout drawer = (DrawerLayout)findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
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

}
