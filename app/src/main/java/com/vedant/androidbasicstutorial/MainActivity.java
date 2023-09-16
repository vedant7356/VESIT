package com.vedant.androidbasicstutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etName, etEmail, etPassword;
    RadioGroup rgGender;
    CheckBox cbTerms;
    Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        rgGender = findViewById(R.id.rgGender);
        cbTerms = findViewById(R.id.cbTerms);
        btnRegister = findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Get user input
                String name = etName.getText().toString();
                String email = etEmail.getText().toString();
                String password = etPassword.getText().toString();
                int selectedGenderId = rgGender.getCheckedRadioButtonId();
                RadioButton selectedGender = findViewById(selectedGenderId);
                boolean termsAccepted = cbTerms.isChecked();

                // Check if any field is empty
                if (name.isEmpty() || email.isEmpty() || password.isEmpty() || selectedGenderId == -1 || !termsAccepted) {
                    Toast.makeText(MainActivity.this, "Please fill in all fields and accept the terms.", Toast.LENGTH_SHORT).show();
                } else {
                    // Registration logic (you can save the data to a database or perform any required action)
                    // For now, we'll just display a Toast message
                    String gender = selectedGender.getText().toString();
                    String message = "Registration Successful\nName: " + name + "\nEmail: " + email + "\nGender: " + gender;
                    Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}