package com.example.manillas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Spinner material, dije, tipo, moneda;
    private EditText cantidad;
    private TextView resultado;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        moneda = findViewById(R.id.spnMoneda);
        material = findViewById(R.id.spnMaterial);
        dije = findViewById(R.id.spnDije);
        tipo = findViewById(R.id.spnTipo);
        cantidad = findViewById(R.id.txtCantidad);
        resultado = findViewById(R.id.lblResultado);

        ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.arrayMateriales, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.arrayDijes, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.arrayTipo, android.R.layout.simple_spinner_item);
        ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.arrayMonedas, android.R.layout.simple_spinner_item);
        material.setAdapter(adapter1);
        dije.setAdapter(adapter2);
        tipo.setAdapter(adapter3);
        moneda.setAdapter(adapter4);

    }

    public void comprar(View v){
        int cant, materiales, dijes, tipos, precio, res = 0, op;

        if(validar()){
        cant = Integer.parseInt(cantidad.getText().toString());

        materiales = material.getSelectedItemPosition();
        dijes = dije.getSelectedItemPosition();
        tipos = tipo.getSelectedItemPosition();

        if(materiales == 0 && dijes == 0 ){
            if (tipos != 2 &&   tipos != 3 ){
                precio = calcularPrecios(100);
                res = precio*cant;
            }
        }
        if(materiales == 0 && dijes == 0 && tipos == 2){
            precio = calcularPrecios(80);
            res = precio*cant;
        }
        if(materiales == 0 && dijes == 0 && tipos == 3){
            precio = calcularPrecios(70);
            res = precio*cant;
        }

        if(materiales == 0 && dijes == 1 ){
            if (tipos != 2 &&   tipos != 3 ){
                precio = calcularPrecios(120);
                res = precio*cant;
            }
        }

        if(materiales == 0 && dijes == 1 && tipos == 2){
            precio = calcularPrecios(100);
            res = precio*cant;
        }
        if(materiales == 0 && dijes == 1 && tipos == 3){
            precio = calcularPrecios(90);
            res = precio*cant;
        }



        if(materiales == 1 && dijes == 0 ){

            if (tipos != 2 &&   tipos != 3 ){
                precio = calcularPrecios(90);
                res = precio*cant;
            }

        }
        if(materiales == 1 && dijes == 0 && tipos == 2){
            precio = calcularPrecios(70);
            res = precio*cant;
        }
        if(materiales == 1 && dijes == 0 && tipos == 3){
            precio = calcularPrecios(50);
            res = precio*cant;
        }



        if(materiales == 1 && dijes == 1  ){
            if (tipos != 2 &&  tipos != 3){
                precio = calcularPrecios(110);
                res = precio*cant;
            }

        }
        if(materiales == 1 && dijes == 1 && tipos == 2){
            precio = calcularPrecios(90);
            res = precio*cant;
        }
        if(materiales == 1 && dijes == 1 && tipos == 3){
            precio = calcularPrecios(80);
            res = precio*cant;
        }

        }
        resultado.setText("Valor: "+String.valueOf(res));
    }


    private int calcularPrecios(int p){
        int op, precioDolar = 3200, precio = p;
        op = moneda.getSelectedItemPosition();

        switch (op){
            case 0:
                return precio;
            case 1:
                precio = precio*precioDolar;
                return  precio;
        }
        return precio;

    }

    public boolean validar(){

        if (cantidad.getText().toString().isEmpty()){
            cantidad.setError(getString(R.string.error_cantidad));
            cantidad.requestFocus();
            return false;
        }
        return true;
    }
}
