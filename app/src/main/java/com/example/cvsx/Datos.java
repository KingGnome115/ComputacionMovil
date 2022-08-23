package com.example.cvsx;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

import java.util.Calendar;
import java.util.GregorianCalendar;

public class Datos extends AppCompatActivity {

    TextView tNombre, tTelefono, tEdad, tSexo, tColor;
    Button btnTomarFoto;
    private AdView mAdView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(@NonNull InitializationStatus initializationStatus) {

            }
        });

        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        tNombre = findViewById(R.id.etxtDNombre);
        tTelefono = findViewById(R.id.etxtDPhone);
        tEdad = findViewById(R.id.etxtDEdad);
        tSexo = findViewById(R.id.tvDSexo);
        tColor = findViewById(R.id.tvDColor);

        Bundle extras = getIntent().getExtras();
        tNombre.setText("Nombre: "+extras.get("Nombre"));
        tTelefono.setText("Telefono: "+extras.get("Telefono"));
        tEdad.setText("Edad: "+getEdad(extras.getString("Fecha")));
        tSexo.setText("Sexo: "+extras.get("Sexo"));
        tColor.setText("Colores: "+extras.get("Colores"));



        btnTomarFoto = findViewById(R.id.btnDTomarFoto);
        btnTomarFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Datos.this, Otros.class);
                startActivity(intent);
            }
        });
    }

    public int getEdad(String fecha)
    {
        String[] fecha_nacimiento = fecha.toString().split("/");
        int dia = Integer.parseInt(fecha_nacimiento[0]);
        int mes = Integer.parseInt(fecha_nacimiento[1]);
        int anio = Integer.parseInt(fecha_nacimiento[2]);
        Calendar edad_1 = new GregorianCalendar(anio,mes,dia);
        Calendar hoy = Calendar.getInstance();
        return hoy.get(Calendar.YEAR) - edad_1.get(Calendar.YEAR);
    }

}