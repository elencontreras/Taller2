package com.example.android.taller2;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;

public class Principal extends AppCompatActivity {
    private EditText cajaCantidad;
    private TextView resultado;
    private Spinner material, dije, tipo;
    private RadioButton r1,r2;
    private ArrayAdapter<String> adapter;
    private String[] opcMaterial, opcDije,opcTipo;
    private Resources res;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);


        cajaCantidad=(EditText)findViewById(R.id.txtCantidad);
        resultado =(TextView)findViewById(R.id.txtResultado);
        material = (Spinner)findViewById(R.id.cmbMaterial);
        dije = (Spinner)findViewById(R.id.cmbDije);
        tipo = (Spinner)findViewById(R.id.cmbTipo);
        r1 = (RadioButton)findViewById(R.id.radio1);
        r2 = (RadioButton)findViewById(R.id.radio2);

        opcMaterial = this.getResources().getStringArray(R.array.materiales);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opcMaterial);
        material.setAdapter(adapter);

        opcDije = this.getResources().getStringArray(R.array.dije);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opcDije);
        dije.setAdapter(adapter);

        opcTipo = this.getResources().getStringArray(R.array.tipo);
        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, opcTipo);
        tipo.setAdapter(adapter);


    }


    public void calcular(View v) {
        String mat, di, tip, mon;
        int cant, result=0;
        int valorUni=0;

        cant = Integer.parseInt(cajaCantidad.getText().toString());
        mat = material.getSelectedItem().toString();
        di = dije.getSelectedItem().toString();
        tip = tipo.getSelectedItem().toString();


        res = this.getResources();

        if (mat.equals(res.getString(R.string.cuero)) && di.equals(res.getString(R.string.martillo)) && (tip.equals(res.getString(R.string.oro)) || tip.equals(res.getString(R.string.oroRosado)))) {
            valorUni = 100;
        }
        if (mat.equals(res.getString(R.string.cuero)) && di.equals(res.getString(R.string.martillo)) && tip.equals(res.getString(R.string.plata))) {
            valorUni = 80;
        }
        if (mat.equals(res.getString(R.string.cuero)) && di.equals(res.getString(R.string.martillo)) && tip.equals(res.getString(R.string.niquel))) {
            valorUni = 70;
        }
        if (mat.equals(res.getString(R.string.cuero)) && di.equals(res.getString(R.string.ancla)) && (tip.equals(res.getString(R.string.oro)) || tip.equals(res.getString(R.string.oroRosado)))) {
            valorUni = 120;
        }
        if (mat.equals(res.getString(R.string.cuero)) && di.equals(res.getString(R.string.ancla)) && tip.equals(res.getString(R.string.plata))) {
            valorUni = 100;
        }
       if(mat.equals(res.getString(R.string.cuero)) && di.equals(res.getString(R.string.ancla)) && tip.equals(res.getString(R.string.niquel))) {
           valorUni = 90;
       }
       if (mat.equals(res.getString(R.string.cuerda)) && di.equals(res.getString(R.string.martillo)) && (tip.equals(res.getString(R.string.oro))||tip.equals(res.getString(R.string.oroRosado)))) {
           valorUni = 90;
       }
       if (mat.equals(res.getString(R.string.cuerda)) && di.equals(res.getString(R.string.martillo)) && tip.equals(res.getString(R.string.plata))) {
           valorUni = 70;
       }
       if (mat.equals(res.getString(R.string.cuerda)) && di.equals(res.getString(R.string.martillo)) && tip.equals(res.getString(R.string.niquel))) {
           valorUni = 50;
       }
       if (mat.equals(res.getString(R.string.cuerda)) && di.equals(res.getString(R.string.ancla)) && (tip.equals(res.getString(R.string.oro))||tip.equals(res.getString(R.string.oroRosado)))) {
           valorUni = 110;
       }
       if (mat.equals(res.getString(R.string.cuerda)) && di.equals(res.getString(R.string.ancla)) && tip.equals(res.getString(R.string.plata))) {
           valorUni = 90;
       }
       if (mat.equals(res.getString(R.string.cuerda)) && di.equals(res.getString(R.string.ancla)) && tip.equals(res.getString(R.string.niquel))) {
           valorUni = 80;
       }

        if (r1.isChecked())
            result = valorUni*cant*3200;
        if (r2.isChecked())
            result = valorUni*cant;

        resultado.setText(result+"");


    }
}
