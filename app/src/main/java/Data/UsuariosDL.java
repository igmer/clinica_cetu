package Data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.edwin.clinicacetu.ClinicaDB;

import java.util.LinkedList;

import Modelos.Usuarios;

/**
 * Created by Edwin on 03/05/2018.
 */

public class UsuariosDL {
    private ClinicaDB openHelper;
    private SQLiteDatabase database;

    public UsuariosDL(Context cont){
        openHelper = new ClinicaDB(cont);
        database = openHelper.getWritableDatabase();
    }

    public int insertUsuario(Usuarios pUsuario){
        int idUsuario =0;


        ContentValues objParam;
        objParam= new ContentValues();
        //objParam.put("Id",pUsuario.getNombres());
        objParam.put("Nombre",pUsuario.getNombres().toUpperCase());
        objParam.put("Direccion",pUsuario.getDireccion());
        objParam.put("Telefono",pUsuario.getTelefono());
        objParam.put("FechaNac",pUsuario.getFechaNacimiento());
        objParam.put("email",pUsuario.getCorreoElectronico().toLowerCase());
        objParam.put("usuario",pUsuario.getUsuario().toLowerCase());
        objParam.put("password",pUsuario.getPassword().toLowerCase());
        objParam.put("activo",pUsuario.getActivo());

        idUsuario =(int) database.insert("Usuarios",null,objParam);

        // database.execSQL("INSERT INTO Usuario VALUES (null, '" + pUsuario.getNombres() + "','" + pUsuario.getApellidos() + "','" + pUsuario.getCorreoElectronico() + "','" + pUsuario.getDireccion() + "','" + pUsuario.getTelefono() + "','" + pUsuario.getCelular() + "','" + pUsuario.getPassword() + "')");
        database.close();
        return idUsuario;
    }

    public LinkedList getAll(){
        Cursor lCur = database.rawQuery("SELECT id, nombre, direccion, telefono, FechaNac, email, usuario, password, activo FROM Usuarios",null);

        LinkedList objListUsuarios = new LinkedList();
        Usuarios objUsuario;

        while(lCur.moveToNext()){
            objUsuario = new Usuarios();
            objUsuario.setID(lCur.getInt(0));
            objUsuario.setNombres(lCur.getString(1));
            objUsuario.setDireccion(lCur.getString(2));
            objUsuario.setTelefono(lCur.getString(3));
            objUsuario.setFechaNacimiento(lCur.getString(4));
            objUsuario.setCorreoElectronico(lCur.getString(5));
            objUsuario.setUsuario(lCur.getString(6));
            objUsuario.setPassword(lCur.getString(7));
            objUsuario.setActivo(lCur.getInt(8));
            objListUsuarios.add(objUsuario);
        }
        database.close();
        return objListUsuarios;
    }

    public LinkedList getByID(Usuarios pUsuario){
        Cursor lCur = database.rawQuery("SELECT id, nombre, direccion, telefono, FechaNac, email, usuario, password, activo FROM Usuarios where email='" + pUsuario.getCorreoElectronico() + "'" ,null);

        LinkedList objListUsuarios = new LinkedList();
        Usuarios objUsuario;

        while(lCur.moveToNext()){
            objUsuario = new Usuarios();
            objUsuario.setID(lCur.getInt(0));
            objUsuario.setNombres(lCur.getString(1));
            objUsuario.setDireccion(lCur.getString(2));
            objUsuario.setTelefono(lCur.getString(3));
            objUsuario.setFechaNacimiento(lCur.getString(4));
            objUsuario.setCorreoElectronico(lCur.getString(5));
            objUsuario.setUsuario(lCur.getString(6));
            objUsuario.setPassword(lCur.getString(7));
            objUsuario.setActivo(lCur.getInt(8));
            objListUsuarios.add(objUsuario);
        }
        database.close();
        return objListUsuarios;
    }





 /*   public int actualizarPassword(String password,Usuarios pUsuario){
        database = openHelper.getWritableDatabase();
        database.execSQL("DELETE FROM Usuario WHERE CorreoElectronico='"+ pUsuario.getCorreoElectronico() +"'");

        int idUsuario;
        ContentValues objParam;
        objParam= new ContentValues();
        objParam.put("CorreoElectronico",pUsuario.getCorreoElectronico());
        objParam.put("TipoUsuario",pUsuario.getTipoUsuario());
        objParam.put("Password",password);
        objParam.put("Estado","ACT");
        idUsuario =(int) database.insert("Usuario",null,objParam);

        database.close();
        return  idUsuario;
    }*/

}
