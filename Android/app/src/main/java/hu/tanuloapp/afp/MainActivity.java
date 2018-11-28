package hu.tanuloapp.afp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.common.hash.Hashing;

import org.json.JSONException;
import org.json.JSONObject;

import java.nio.charset.StandardCharsets;
import hu.tanuloapp.afp.global.Authenticate;

public class MainActivity extends AppCompatActivity {

    EditText email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = findViewById(R.id.login);
        TextView newacc = findViewById(R.id.registration);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });
        newacc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToRegister();
            }
        });
    }

    public void GoToRegister(){
        Intent intent = new Intent(this, RegisterActivity.class);
        intent.putExtra("emailValue",email.getText().toString());
        intent.putExtra("passValue",pass.getText().toString());
        finish();
        startActivity(intent);
    }

    private void Login() {
        String emailValue = email.getText().toString();
        String passValue = pass.getText().toString();
        if ("".equals(emailValue) || "".equals(passValue))
            Toast.makeText(this, R.string.fill_all_field, Toast.LENGTH_LONG).show();
        else if(!Authenticate.isEmailValid(emailValue) )
            Toast.makeText(this, R.string.email_not_valid, Toast.LENGTH_LONG).show();
        else {
            passValue = Hashing.sha256().hashString(passValue, StandardCharsets.UTF_8).toString();
        }
        JSONObject login_json = new JSONObject();
        try {
            login_json.put("email", emailValue);
            login_json.put("password", passValue);
            Toast.makeText(this, "Kész a dzsézön", Toast.LENGTH_SHORT).show();
        } catch (JSONException e) {
            e.printStackTrace();
            Toast.makeText(this, "Hibás a dzsézön", Toast.LENGTH_SHORT).show();
        }

    }
}
