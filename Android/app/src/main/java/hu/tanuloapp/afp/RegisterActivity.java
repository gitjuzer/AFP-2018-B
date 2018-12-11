package hu.tanuloapp.afp;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.common.hash.Hashing;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;

import hu.tanuloapp.afp.global.Authenticate;

public class RegisterActivity extends AppCompatActivity {

    EditText username, email, pass, confirmpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        Intent intent = getIntent();
        Button backtologin = findViewById(R.id.back);
        Button registration = findViewById(R.id.registration);

        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        confirmpass = findViewById(R.id.confirmpass);
        String strEmail = intent.getStringExtra("emailValue");
        String strPass = intent.getStringExtra("passValue");
        if (strEmail != null) {
            email.setText(strEmail);
            pass.setText(strPass);
            confirmpass.setText(strPass);
        }
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
        backtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackToLogin(null);
            }
        });

    }

    public void BackToLogin(String email) {
        Intent intent = new Intent(this, MainActivity.class);
        if (!"".equals(email)) {
            intent.putExtra("emailValue", email);
            intent.putExtra("passValue", pass.getText().toString());
        }
        finish();
        startActivity(intent);
    }

    private void Register() {
        String usernameValue = username.getText().toString();
        String emailValue = email.getText().toString();
        String passValue = pass.getText().toString();
        String confirmpassValue = confirmpass.getText().toString();
        if ("".equals(usernameValue) || "".equals(emailValue) || "".equals(passValue) || "".equals(confirmpassValue))
            Toast.makeText(this, R.string.fill_all_field, Toast.LENGTH_LONG).show();
        else if (!passValue.equals(confirmpassValue)) {
            Toast.makeText(this, R.string.pass_dont_match, Toast.LENGTH_LONG).show();
        } else {
            JSONObject jsonObject = new JSONObject();
            passValue = Hashing.sha256().hashString(passValue, StandardCharsets.UTF_8).toString();
            try {
                jsonObject.put("Username", usernameValue);
                jsonObject.put("Email", emailValue);
                jsonObject.put("Password", passValue);
                jsonObject.put("RePassword", passValue);
            } catch (JSONException e) {
                Log.d("REGISTER", e.getMessage());
            }
            if (Authenticate.isConnected(this)) {
                Toast.makeText(this, String.valueOf(jsonObject), Toast.LENGTH_LONG).show();
                BackToLogin(emailValue);
            }else
                Toast.makeText(this, R.string.check_connection, Toast.LENGTH_SHORT).show();
        }
    }
}
