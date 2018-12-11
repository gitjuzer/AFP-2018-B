package hu.tanuloapp.afp;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.view.MenuItem;
import android.support.v4.view.GravityCompat;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.common.hash.Hashing;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

import hu.tanuloapp.afp.global.Authenticate;
import hu.tanuloapp.afp.global.User;

public class MainActivity extends AppCompatActivity {

    EditText email, pass;
    User user;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mToggle = new ActionBarDrawerToggle(this,mDrawerLayout, R.string.open, R.string.close);
        mDrawerLayout.addDrawerListener(mToggle);
        mToggle.syncState();
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Button login = findViewById(R.id.login);
        TextView newacc = findViewById(R.id.registration);
        Intent intent = getIntent();
        user = User.getInstance();
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        String strEmail = intent.getStringExtra("emailValue");
        String strPass = intent.getStringExtra("passValue");
        if (strEmail != null) {
            email.setText(strEmail);
            pass.setText(strPass);
        }

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });
        newacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToActivity(RegisterActivity.class);
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(mToggle.onOptionsItemSelected(item)){
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void GoToActivity(Class toActivity) {
        Intent intent = new Intent(this, toActivity);
        if (toActivity == RegisterActivity.class) {
            intent.putExtra("emailValue", email.getText().toString());
            intent.putExtra("passValue", pass.getText().toString());
        }
        finish();
        startActivity(intent);
    }

    private void Login() {
        String emailValue = email.getText().toString();
        String passValue = pass.getText().toString();
        if ("".equals(emailValue) || "".equals(passValue))
            Toast.makeText(this, R.string.fill_all_field, Toast.LENGTH_LONG).show();
        else if (!Authenticate.isEmailValid(emailValue))
            Toast.makeText(this, R.string.email_not_valid, Toast.LENGTH_LONG).show();
        else {
            passValue = Hashing.sha256().hashString(passValue, StandardCharsets.UTF_8).toString();
        }
        JSONObject login_json = new JSONObject();
        try {
            login_json.put("email", emailValue);
            login_json.put("password", passValue);
            if (Authenticate.isConnected(this)) {
				if (SendLoginData(emailValue, passValue)) {
					GoToActivity(QuizActivity.class);
                }
            } else
                Toast.makeText(this, R.string.check_connection, Toast.LENGTH_SHORT).show();

        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Hibás a dzsézön", Toast.LENGTH_SHORT).show();
        }

    }

    private boolean SendLoginData(final String email, final String pass) {
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "example.com/check/";
        final boolean[] success = {false};
        StringRequest postRequest = new StringRequest(Request.Method.POST, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        success[0] = true;
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // error
                        Log.d("Error.Response", error.getMessage());
                    }
                }
        ) {
            @Override
            protected Map<String, String> getParams() {
                Map<String, String> params = new HashMap<String, String>();
                params.put("username", email);
                params.put("password", pass);
                return params;
            }
        };
        queue.add(postRequest);
        return success[0];
    }
}
