package com.example.gonzalo.tiendamovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class BienvenidoInterno extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bienvenido_interno);
    }
    public void llamarMenuTienda(View view)
    {
        Intent intent=new Intent(this,MenuTienda.class);
        startActivity(intent);
    }
}
