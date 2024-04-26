package com.example.tusprocesosya;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class RegistryActivity extends AppCompatActivity {

    private EditText name, lastname, id, idNumber, cityBorn, cityLive, userName, contraseña;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register);

        name = findViewById(R.id.name);
        lastname = findViewById(R.id.lastname);
        id = findViewById(R.id.id);
        idNumber = findViewById(R.id.idNumber);
        cityBorn = findViewById(R.id.cityBorn);
        cityLive = findViewById(R.id.cityLive);
        userName = findViewById(R.id.userName);
        contraseña = findViewById(R.id.contraseña);
        registerButton = findViewById(R.id.registerButton);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences preferences = getSharedPreferences("MisPreferencias", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();

                editor.putString("name", name.getText().toString());
                editor.putString("lastName", lastname.getText().toString());
                editor.putString("id", id.getText().toString());
                editor.putString("idNumber", idNumber.getText().toString());
                editor.putString("cityBorn", cityBorn.getText().toString());
                editor.putString("cityLive", cityLive.getText().toString());
                editor.putString("userName", userName.getText().toString());
                editor.putString("contraseña", contraseña.getText().toString());

                editor.apply();

                Toast.makeText(RegistryActivity.this, "Registrado", Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(RegistryActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
