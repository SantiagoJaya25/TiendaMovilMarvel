package com.example.gonzalo.tiendamovil;
import com.example.gonzalo.tiendamovil.IngresarProductos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MostrarProductos extends AppCompatActivity {
    String detalle;
    TextView descripcion;

    IngresarProductos ingresarProductos=new IngresarProductos();
    private ListView listUser;
    String[] arrProduct;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mostrar_productos);
        listUser= (ListView)findViewById(R.id.idProductosLista);

        mostrarLista();
        onItemParaConsultar();
    }
    public void mostrarLista() {
        ingresarProductos.ListaProductos.add(new Productos(1,"MUÑECO DE IRON MAN","MARVEL","MUÑECO DE LA PELICULA DE IRON MAN 3","https://http2.mlstatic.com/ironman-muneco-articulado-gigante-30cm-avengers-orig-hasbro-D_NQ_NP_707201-MLA20294751892_052015-F.jpg","22.5"));
        ingresarProductos.ListaProductos.add(new Productos(2,"MUÑECO DE THOR","MARVEL","MUÑECO DE LA PELICULA THOR RACKNARO","http://fusion-freak.es/wp-content/uploads/2017/06/MARVEL-THOR-RAGNAROK-LEGENDS-SERIES-6-INCH-Figure-2-Pack-Thor-Valkyrie-oop.png","25.2"));

        arrProduct = new String[ingresarProductos.getListaProductos().size()];
        for (int i = 0; i < arrProduct.length; i++) {
            arrProduct[i] = ingresarProductos.getListaProductos().get(i).getNombre();
        }
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrProduct);
        listUser.setAdapter(adaptador);

    }
    public void onItemParaConsultar() {

        listUser.setClickable(true);
        listUser.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                Intent intent = new Intent(MostrarProductos.this, DetalleProductos.class);
                startActivity(intent);

                detalle="Codigo:"+ingresarProductos.ListaProductos.get(position).getCodigo()+"\n"
                        +"Nombre: "+ingresarProductos.ListaProductos.get(position).getNombre()+"\n"
                        +"Marca: "+ingresarProductos.ListaProductos.get(position).getMarca()+"\n"
                        +"Descripcion: "+ingresarProductos.ListaProductos.get(position).getDescripcion()+"\n"
                        +"Precio: "+ingresarProductos.ListaProductos.get(position).getPrecio()+"\n";

                descripcion=(TextView)findViewById(R.id.teDetalleP);
                descripcion.setText(detalle);


            }
        });
    }
}
