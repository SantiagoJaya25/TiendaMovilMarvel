package com.example.gonzalo.tiendamovil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MenuTienda extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_tienda);
    }
    public void llamarQR(View view)
    {
        Intent intent=new Intent(this,QR.class);
        startActivity(intent);
    }
    public void llamarAdministracion(View view)
    {
        Intent intent=new Intent(this, AdministrarProductos.class);
        startActivity(intent);
    }
    public  void llamarMostrarListas(View view)
    {
        Intent intent=new Intent(this, MostrarProductos.class);
        startActivity(intent);
    }
}
