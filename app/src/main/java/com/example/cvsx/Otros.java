package com.example.cvsx;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Otros extends AppCompatActivity {

    Button btnActivarCamara;
    Button btnCreditos;
    ImageView imagenFoto;
    private Camera camera = new Camera();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otros);
        btnActivarCamara = findViewById(R.id.btnOVActivarCamara);
        btnCreditos = findViewById(R.id.btnOCreditos);
        imagenFoto = findViewById(R.id.iVFotoTR);

        btnActivarCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirCamara();
            }
        });

        btnCreditos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getCreditos();
            }
        });
    }

    private void getCreditos() {
        new AlertDialog.Builder(this)
                .setTitle("Acerca de")
                .setMessage(""+
                 "KingGnomo115\n"
                + "Profesora: Rocio Elizabeth Alba\n"
                + "Movil 2022B\n"
                + "vrs 1")
                .setPositiveButton("Aceptar",null)
                .show();
    }

    private void abrirCamara(){
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(intent.resolveActivity(getPackageManager()) != null)
        {
            startActivityForResult(intent,1);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imgBitMap = (Bitmap) extras.get("data");
            imagenFoto.setImageBitmap(imgBitMap);
        }
    }

}
