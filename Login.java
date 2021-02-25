package com.example.applogin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends AppCompatActivity {

    EditText username1, password1;
    Button btnsignin1;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username1 = (EditText) findViewById(R.id.username1);
        password1 = (EditText) findViewById(R.id.password1);

        DB = new DBHelper(this);

        btnsignin1 = (Button) findViewById(R.id.btnsignin1);

        btnsignin1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user1 = username1.getText().toString();
                String pass1 = password1.getText().toString();

                if (user1.equals("") || pass1.equals("")) {
                    Toast.makeText(Login.this, "Enter username & password", Toast.LENGTH_LONG).show();
                } else {
                    Boolean checkuserpass = DB.checkusernamepassword(user1, pass1);
                    if (checkuserpass == true) {
                        Toast.makeText(Login.this, "Sign in successfully", Toast.LENGTH_LONG).show();
                        Intent intent = new Intent(getApplicationContext(), MainPage.class);
                        startActivity(intent);
                    } else {
                        Toast.makeText(Login.this, "Sign in Failed ", Toast.LENGTH_LONG).show();

                    }
                }

            }
        });

    }
}