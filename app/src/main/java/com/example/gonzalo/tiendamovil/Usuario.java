package com.example.gonzalo.tiendamovil;

/**
 * Created by Gonzalo on 31/05/2018.
 */

public class Usuario {
    private int idUsuario;
    private String nombreUsuario;
    private String edad;
    private String correoElectronico;
    private String password;
    private String confPassword;

    public Usuario(int idUsuario, String nombreUsuario, String edad, String correoElectronico, String password, String confPassword) {
        this.idUsuario = idUsuario;
        this.nombreUsuario = nombreUsuario;
        this.edad = edad;
        this.correoElectronico = correoElectronico;
        this.password = password;
        this.confPassword = confPassword;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getEdad() {
        return edad;
    }

    public void setEdad(String edad) {
        this.edad = edad;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConfPassword() {
        return confPassword;
    }

    public void setConfPassword(String confPassword) {
        this.confPassword = confPassword;
    }
}
