package com.example.cucumberex;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.button.MaterialButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView username = (TextView) findViewById(R.id.mail);
        TextView password = (TextView) findViewById(R.id.password);

        MaterialButton lgnbutton = (MaterialButton) findViewById(R.id.signinbtn);

        lgnbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(username.getText().toString().equals("root") && password.getText().toString().equals("12345"))
                {
                    Toast.makeText(MainActivity.this,"Giriş Yapıldı",Toast.LENGTH_SHORT).show();
                }
                else
                    Toast.makeText(MainActivity.this,"Şifre veya Mail adresiniz yanlış",Toast.LENGTH_SHORT).show();

            }
        });




    }


}