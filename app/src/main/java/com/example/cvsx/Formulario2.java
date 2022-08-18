package com.example.cvsx;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.Calendar;

public class Formulario2 extends AppCompatActivity {

    Button btnSalir;
    Button btnMostrar;

    EditText txtNombre, txtTelefono, txtFecha;
    RadioButton mMujer, hHombre;
    CheckBox color1, color2, color3, color4;
    boolean c1,c2,c3,c4,c5;

    public final Calendar c = Calendar.getInstance();
    final int mes = c.get(Calendar.MONTH);
    final int dia = c.get(Calendar.DAY_OF_MONTH);
    final int anio = c.get(Calendar.YEAR);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_formulario2);

        txtNombre = findViewById(R.id.etxtFNombre);
        txtTelefono = findViewById(R.id.etxtFPhone);
        txtFecha = findViewById(R.id.etxtFBirthday);

        mMujer = findViewById(R.id.rbtFMujer);
        hHombre = findViewById(R.id.rbtFHombre);

        color1 = findViewById(R.id.chkbFAmarillo);
        color2 = findViewById(R.id.chkbFAzul);
        color3 = findViewById(R.id.chkbFRojo);
        color4 = findViewById(R.id.chkbFVerde);

        txtFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                obtenerFecha();
            }
        });

        btnSalir = findViewById(R.id.btnFSalir);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Formulario2.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnMostrar = findViewById(R.id.btnFMostrar);
        btnMostrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Formulario2.this,Datos.class);
                intent.putExtra("Nombre",txtNombre.getText().toString());
                intent.putExtra("Telefono",txtTelefono.getText().toString());
                intent.putExtra("Fecha",txtFecha.getText().toString());
                intent.putExtra("Sexo",getGenero());
                intent.putExtra("Colores",getColores());

                startActivity(intent);
            }
        });
    }

    private void obtenerFecha() {
        DatePickerDialog recogerFecha = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                final int mesActual = month +1;
                String diaFormateado = (day<10) ? "0" + String.valueOf(day) : String.valueOf(day);
                String mesFormateado = (mes<10) ? "0" + String.valueOf(month) : String.valueOf(month);
                txtFecha.setText(diaFormateado+"/"+mesFormateado+"/"+year);
            }
        }, anio, mes, dia);
        recogerFecha.show();
    }

    private String getGenero(){
        return (mMujer.isChecked()) ? "Femenino" : "Masculino";
    }

    private String getColores(){
        c1 = color1.isChecked();
        c2 = color2.isChecked();
        c3 = color3.isChecked();
        c4 = color4.isChecked();
        String colores = "";
        if(c1){colores += "Amarillo ";}
        if(c2){colores += "Azul ";}
        if(c3){colores += "Rojo ";}
        if(c4){colores += "Verde ";}
        return colores;

    }

}