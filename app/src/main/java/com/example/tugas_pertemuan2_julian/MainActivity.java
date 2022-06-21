package com.example.tugas_pertemuan2_julian;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

boolean isValid = false;

public class MainActivity extends AppCompatActivity {

    private EditText eEmail;
    private EditText ePassword;
    private Button bLogin;
    private TextView tView;

    private String Username = "Admin";
    private String Password = "Admin";

    boolean isValid = false;
    private int counter = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eEmail = findViewById(R.id.editEmail);
        ePassword = findViewById(R.id.editPassword);
        bLogin = findViewById(R.id.buttonLogin);
        tView = findViewById(R.id.textView);


        bLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String inputEmail = eEmail.getText().toString();
                String inputPassword = ePassword.getText().toString();

                if(inputEmail.isEmpty() || inputPassword.isEmpty())
                {
                    Toast.makeText(MainActivity.this, "Please input all the required details.",Toast.LENGTH_LONG).show();
                }else{

                    isValid = validate(inputEmail, inputPassword);

                    if(!isValid){
                        counter--;
                        Toast.makeText(MainActivity.this, "Incorrect Email or Password.",Toast.LENGTH_LONG).show();

                        if(counter == 0){
                            bLogin.setEnabled(false);
                        }
                    }else{
                        Toast.makeText(MainActivity.this, "Logged In Sucessfuly",Toast.LENGTH_LONG).show();

                    }
                }
            }
        });
    }

    private boolean  validate(String name, String password){

        if(name.equals(Username) && password.equals(Password)){
            return true;
        }

        return false;
    }
}