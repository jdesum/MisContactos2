package com.example.yoso.miscontactos2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    // Declaración arrayLIst
   ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Instanciamos el arraylist
        contactos = new ArrayList<Contacto>();

        // Añadir contactos dummy
        contactos.add(new Contacto("Ana Gomez", "77779999", "ana@gmail.com"));
        contactos.add(new Contacto("Pedro Sanchez", "88882222", "pedro@gmail.com" ));
        contactos.add(new Contacto("Mireya Martinez", "33331111", "mireya@gmail.com" ));
        contactos.add(new Contacto("Juan Lopez", "44442222", "juan@gmail.com"));

        // Nuevo arreglo con los nombres de contacto
        ArrayList<String> nombresContacto = new ArrayList<>();

        for (Contacto contacto: contactos) {
            nombresContacto.add(contacto.getNombre());


        }


        // Generar el ListView
        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);

        // Adaptador para llenar la lista de contactos
        lstContactos.setAdapter(new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, nombresContacto));


        // Crear un listener
        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            // cacheando la position 0,1,2,3 del indice Arralylist
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                // Intent explicito para unir una pantalla a otra
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);

                // Enviar parametro que obtengo
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
                // Enviar un arreglo tambien
                // Inciar el intent
                startActivity(intent);

            }
        });



    }
}
