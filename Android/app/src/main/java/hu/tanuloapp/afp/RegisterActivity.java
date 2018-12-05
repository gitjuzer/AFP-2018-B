package hu.tanuloapp.afp;

import android.content.Intent;
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

public class RegisterActivity extends AppCompatActivity {

    EditText username,email,pass, confirmpass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        Button backtologin = findViewById(R.id.back);
        Button registration = findViewById(R.id.registration);
        username = findViewById(R.id.username);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        confirmpass = findViewById(R.id.confirmpass);
        registration.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Register();
            }
        });
        backtologin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BackToLogin();
            }
        });

    }

    public void BackToLogin(){
        Intent intent = new Intent(this,MainActivity.class);
        finish();
        startActivity(intent);
    }

    private void Register(){
        String usernameValue = username.getText().toString();
        String emailValue = email.getText().toString();
        String passValue = pass.getText().toString();
        String confirmpassValue = confirmpass.getText().toString();
        if ("".equals(usernameValue) || "".equals(emailValue) || "".equals(passValue) || "".equals(confirmpassValue))
            Toast.makeText(this, R.string.fill_all_field, Toast.LENGTH_LONG).show();
        else if(!passValue.equals(confirmpassValue)){
            Toast.makeText(this, R.string.pass_dont_match, Toast.LENGTH_LONG).show();
        }
        else {
            JSONObject jsonObject = new JSONObject();
            passValue = Hashing.sha256().hashString(passValue, StandardCharsets.UTF_8).toString();
            try{
            jsonObject.put("Username",usernameValue);
            jsonObject.put("Email",emailValue);
            jsonObject.put("Password",passValue);
            jsonObject.put("RePassword",passValue);
            }catch(JSONException e){
                Log.d("REGISTER",e.getMessage());
            }
            Toast.makeText(this,String.valueOf(jsonObject),Toast.LENGTH_LONG).show();
        }
    }
}
