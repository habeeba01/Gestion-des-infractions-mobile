package com.example.provincesafi;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText Name,Password;
    private TextView Info;
    private Button Login;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name = (EditText)findViewById(R.id.username);
        Password = (EditText)findViewById(R.id.pass);
        Info = (TextView)findViewById(R.id.info);
        Login = (Button)findViewById(R.id.btnLogin);

        Info.setText("No of attempts remaining: 5");

        Login.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                validate(Name.getText()ity.this, "u've been logged successfully", Toast.LENGTH_LONG).show();

            }
        });.toString(), Password.getText().toString());
        Toast.makeText(MainActiv
    }

    private void validate(String userName, String userPassword){
        if((userName.equals("login")) && (userPassword.equals("login"))){
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        }else{
            counter--;

            Info.setText("No of attempts remaining: " + String.valueOf(counter));

            if(counter == 0){
                Login.setEnabled(false);
            }
        }
    }

}