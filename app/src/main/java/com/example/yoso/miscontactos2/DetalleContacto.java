package com.example.yoso.miscontactos2;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class DetalleContacto extends AppCompatActivity {

    // 5. Declaración de variable globales
    private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_contacto);

        // 1. Recibe los parametros mediante un objeto Bundle
        Bundle parametros = getIntent().getExtras(); // los parametros se llaman extra
        String nombre = parametros.getString(getResources().getString(R.string.pnombre)); //nombre
        String telefono = parametros.getString(getResources().getString(R.string.ptelefono)); //telefono
        String email = parametros.getString(getResources().getString(R.string.pemail)); //email

        // 2.  Mostrar los datos
        // TextView tvNombre = (TextView) findViewById(R.id.tvNombre);
        //  TextView tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        //  TextView tvEmail = (TextView) findViewById(R.id.tvEmail);

        // 6. Mostrar datos
        tvNombre = (TextView) findViewById(R.id.tvNombre);
        tvTelefono = (TextView) findViewById(R.id.tvTelefono);
        tvEmail = (TextView) findViewById(R.id.tvEmail);

        tvNombre.setText(nombre);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);


    }

    // 3- Método para ejecutar una llamada intent implicito
    public void llamar(View v) {
        String telefono = tvTelefono.getText().toString();
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }

        startActivity(new Intent(Intent.ACTION_CALL, Uri.parse("tel:" + telefono)));


    }

    // 4.  Método para enviar un email
    public void enviarMail (View v){
        String email = tvEmail.getText().toString();
        // 6 Ejecutar el intent
        Intent emailIntent = new Intent((Intent.ACTION_SEND));
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.putExtra(Intent.EXTRA_EMAIL, email);
        // 8 Activar app email
        emailIntent.setType("message/rfc822");

        // 7 Elegir la aplicación de email para elegir
        startActivity(Intent.createChooser(emailIntent, "Email"));

    }

}
