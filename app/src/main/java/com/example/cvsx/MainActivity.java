package com.example.cvsx;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnAcceso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(this, "En OnStart", Toast.LENGTH_SHORT).show();
        btnAcceso = findViewById(R.id.btnMMostrar);
        btnAcceso.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, Formulario2.class);
                startActivity(intent);
            }
        });


    }

    @Override
    protected void onStart(){ //Al momento de iniciar
        super.onStart();
        Toast.makeText(this, "En OnStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onResume() //Al momento de regresar a la aplicacion
    {
        super.onResume();
        Toast.makeText(this, "En OnResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onPause() //Cuando pasa a segundo plano
    {
        super.onPause();
        Toast.makeText(this, "En OnPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onStop() //Cuando se detiene
    {
        super.onStop();
        Toast.makeText(this, "En OnStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected  void onDestroy() //Cuando se mata
    {
        super.onDestroy();
        Toast.makeText(this, "En OnDestroy", Toast.LENGTH_SHORT).show();
    }
}