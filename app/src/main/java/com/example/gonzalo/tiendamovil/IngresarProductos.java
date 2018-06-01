package com.example.gonzalo.tiendamovil;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class IngresarProductos extends AppCompatActivity {

    public ArrayList<Productos> ListaProductos=new ArrayList<>();
    EditText nombreP,codigoP,marcaP,descripcionP,linkP,precioP;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_productos);
        codigoP= (EditText)findViewById(R.id.edCodigoP);
        marcaP=(EditText)findViewById(R.id.edMarcaP);
        descripcionP=(EditText)findViewById(R.id.edDescripcionP);
        linkP=(EditText)findViewById(R.id.edLinkP);
        precioP=(EditText)findViewById(R.id.edPrecio);
        //comentario
    }
    public void AñadirProductos()
    {
        ListaProductos.add(new Productos(Integer.parseInt(codigoP.getText().toString()),nombreP.getText().toString(),marcaP.getText().toString(),descripcionP.getText().toString(),linkP.getText().toString(),precioP.getText().toString()));

    }
    public  void borrarProductos()
    {
        ListaProductos.remove(1);
    }
    public void EditarProductos()
    {
        ListaProductos.set(Integer.parseInt(codigoP.getText().toString()),new Productos(Integer.parseInt(codigoP.getText().toString()),nombreP.getText().toString(),marcaP.getText().toString(),descripcionP.getText().toString(),linkP.getText().toString(),precioP.getText().toString()));
    }
    public void IngresarOActualizar()
    {

        for(int i=0;i<ListaProductos.size();i++)
        {
            Toast.makeText(getApplicationContext(),"entro metodo for",Toast.LENGTH_LONG).show();
            if(Integer.parseInt(codigoP.getText().toString())==ListaProductos.get(i).getCodigo())
            {
                EditarProductos();
                Toast.makeText(getApplicationContext(),"ACTUALIZADO CON EXITO",Toast.LENGTH_LONG).show();
            }else{

            }
        }

        AñadirProductos();
        Toast.makeText(getApplicationContext(),"INGRESADO CON EXITO",Toast.LENGTH_LONG).show();

    }
    public void llamarIngresarOActualizar(View view)
    {

        IngresarOActualizar();

    }

    public ArrayList<Productos> getListaProductos() {
        return ListaProductos;
    }

    public void setListaProductos(ArrayList<Productos> listaProductos) {
        ListaProductos = listaProductos;
    }
}
