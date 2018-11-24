package hu.tanuloapp.afp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

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
    }
}
