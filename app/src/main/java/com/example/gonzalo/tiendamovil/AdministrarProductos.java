package com.example.gonzalo.tiendamovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.ArrayList;

public class AdministrarProductos extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_administrar_productos);
    }
    public void llamarIngresarProductos(View view)
    {
        Intent intent=new Intent(this,IngresarProductos.class);
        startActivity(intent);
    }


}
