package hu.tanuloapp.afp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    EditText email, pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button login = findViewById(R.id.login);
        email = findViewById(R.id.email);
        pass = findViewById(R.id.pass);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Login();
            }
        });
    }

    private void Login() {
        String emailValue = email.getText().toString();
        String passValue = pass.getText().toString();
        if ("".equals(emailValue) || "".equals(passValue))
            Toast.makeText(this, R.string.fill_all_field, Toast.LENGTH_LONG).show();
        else {
            passValue = Hashing.sha256().hashString(passValue, StandardCharsets.UTF_8).toString();
        }

    }
}
