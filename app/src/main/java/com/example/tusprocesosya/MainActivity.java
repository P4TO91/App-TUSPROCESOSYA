package com.example.tusprocesosya;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {
    private EditText username;
    private EditText password;
    private Button login;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.name);
        password = (EditText) findViewById(R.id.password);
        login = (Button) findViewById(R.id.login);
        registerButton = (Button) findViewById(R.id.registerButton);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                validate(username.getText().toString(), password.getText().toString());
            }
        });

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, RegistryActivity.class);
                startActivity(intent);
            }
        });
    }

    private void validate(String userName, String userPassword){
        // Recuperar los datos del usuario y la contraseña del registro
        SharedPreferences preferences = getSharedPreferences("MisPreferencias", MODE_PRIVATE);
        String registeredUser = preferences.getString("userName", "");
        String registeredPassword = preferences.getString("contraseña", "");

        if(userName.equals(registeredUser) && userPassword.equals(registeredPassword)){
            Toast.makeText(getApplicationContext(), "Inicio de sesión exitoso", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity.this, Main_page.class);
            startActivity(intent);
        }else{
            Toast.makeText(getApplicationContext(), "Datos incorrectos", Toast.LENGTH_SHORT).show();
        }
    }
}
