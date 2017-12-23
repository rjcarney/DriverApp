package com.example.rjcar.driverapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginPage extends AppCompatActivity {

    Button login, cancel;
    EditText username, password;
    TextView displayCounter;

    int counter = 3;
    String attemptsLeft = Integer.toString(counter);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        login = findViewById(R.id.login);
        cancel = findViewById(R.id.cancel);

        username = findViewById(R.id.username);
        password = findViewById(R.id.password);

        displayCounter = findViewById(R.id.displayCounter);
        displayCounter.setText(attemptsLeft);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Check if username and password are correct
                if (username.getText().toString().equals("admin")
                        && password.getText().toString().equals("admin")) {

                    Toast.makeText(getApplicationContext(),
                            "Redirecting...",Toast.LENGTH_SHORT).show();        //Next step redirect to home screen

                    Intent verifiedAccount = new Intent(LoginPage.this,
                            DriverHome.class);
                    startActivity(verifiedAccount);
                    finish();
                }
                //If invalid login
                else {

                    Toast.makeText(getApplicationContext(),
                            "Wrong Credentials",Toast.LENGTH_SHORT).show();

                    counter--;
                    attemptsLeft = Integer.toString(counter);
                    displayCounter.setText(attemptsLeft);

                    if (counter == 0){
                        login.setEnabled(false);
                    }
                }
            }
        });

        cancel.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                finish();
            }
        });
    }
}
