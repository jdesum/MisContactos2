package com.example.yoso.miscontactos2;

/**
 * POJO
 * Created by yoso on 27/05/16.
 */
public class Contacto {

    private String nombre;
    private String telefono;
    private String email;

    // Constructor para instanciar

    public Contacto(String nombre, String telefono, String email) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.email = email;
    }


    // Métodos getters and setters

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



}