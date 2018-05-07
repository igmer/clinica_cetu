package Modelos;

import java.io.Serializable;

/**
 * Created by Edwin on 03/05/2018.
 */

public class Usuarios implements Serializable {
    private String nombres, email, direccion, telefono,fechaNacimiento,usuario,password;
    private  int Activo,Id;
    // private byte [] password;

    public int getActivo() {
        return Activo;
    }

    public void setActivo(int Activo) {
        this.Activo=Activo;
    }

    public Usuarios(){

    }


    public Usuarios(String pcorreoElectronico, String pContrasenia){
        email = pcorreoElectronico;
        password = pContrasenia;
    }

    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }


    public String getCorreoElectronico() {
        return email;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.email = correoElectronico;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario  = usuario;
    }

    public int getID(){
        return Id;
    }
    public void setID(int id){
        this.Id= id;
    }
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}

