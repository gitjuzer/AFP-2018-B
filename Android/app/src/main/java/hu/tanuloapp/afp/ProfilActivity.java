package hu.tanuloapp.afp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Objects;

public class ProfilActivity extends AppCompatActivity implements
        NavigationView.OnNavigationItemSelectedListener{

    private ActionBarDrawerToggle mToggle;
    private DrawerLayout mDrawerLayout;
    private  ListView results;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profil);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        results = findViewById(R.id.results);
        mToggle = new ActionBarDrawerToggle(this, mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        NavigationView navigationView = findViewById(R.id.nav_view);

        if (navigationView != null) {
            navigationView.setNavigationItemSelectedListener(this);
        }
        initList();
    }

    private void initList() {
        ArrayList<String> listItems=new ArrayList<>();
        ArrayAdapter<String> adapter;

        for (int i=0; i<10; i++)
            listItems.add(i+1+". Játékban elért pontok: 0");


        adapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listItems);
        results.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return mToggle.onOptionsItemSelected(item) || super.onOptionsItemSelected(item);
    }

    public void GoToActivity(Class toActivity) {
        Intent intent = new Intent(this, toActivity);
        finish();
        startActivity(intent);
    }


    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
        int id = menuItem.getItemId();
        if(id == R.id.profile){
            GoToActivity(ProfilActivity.class);
        }else if(id == R.id.quiz){
            GoToActivity(QuizActivity.class);
        }else if(id == R.id.logout){
            GoToActivity(MainActivity.class);
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return false;
    }
}
