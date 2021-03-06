package com.example.edwin.clinicacetu;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


/**
 * Created by Edwin on 29/04/2018.
 */

public class ClinicaDB extends SQLiteOpenHelper{
    public static final String DATABASE_NAME = "DBClinicaCETU";
    public static final int DATABASE_VERSION = 2;

    // Definición de DDL'S para crear las tablas de paises y continentes
    String sqlCreateTableUsuarios = "Create Table Usuarios (id INTEGER PRIMARY KEY AUTOINCREMENT,"
            + "nombre TEXT, direccion TEXT, telefono TEXT,FechaNac DATETIME DEFAULT CURRENT_TIMESTAM, email TEXT, usuario TEXT, password TEXT, activo INTEGER)";

    String sqlCretaeConsultaMedica="create table consultaMedica (id INTEGER PRIMARY KEY AUTOINCREMENT, idCita integer NOT NULL, peso DOUBLE, talla DOUBLE, diagnostico TEXT, tratamiento TEXT)";


    public ClinicaDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Método ejecutado automáticamente si la base de datos no existe
        db.execSQL(sqlCreateTableUsuarios);
        db.execSQL(sqlCretaeConsultaMedica);
        poblarDB(db);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        // Método ejecutado si el numero de newVersion es SUPERIOR a oldVersion
        db.execSQL("DROP TABLE IF EXISTS Usuarios");
        db.execSQL("DROP TABLE IF EXISTS consultaMedica");
        this.onCreate(db);

    }
    public void poblarDB(SQLiteDatabase db)
    {
        // Procedimiento para inicializar con algunos registros la DB
        // Tabla de continenetes
        db.execSQL("INSERT INTO Usuarios VALUES (1,'','','','1998-01-01 10:00:00','albertolemus87@gmai.com','elemus','123',1)");
        db.execSQL("INSERT INTO Usuarios VALUES (2,'','','','1998-01-01 10:00:00','arcana_87@hotmail.com','juan','1234x',1)");
        db.execSQL("INSERT INTO Usuarios VALUES (4,'','','','1998-01-01 10:00:00','aguardado@nexuserp.coom','carlos','456',1)");
        db.execSQL("INSERT INTO consultaMedica VALUES (1,1,3.1,10.3,'Diarrea','tapacul')");
        db.execSQL("INSERT INTO consultaMedica VALUES (2,1,3.1,10.3,'Diarrea','tapacul')");



    }

    public Integer validaIngresousuario(String elUsuario, String laClave){
        //Se obtiene referencia a base de datos para relizar consultas
        SQLiteDatabase db = getReadableDatabase();
        //Se realiza consulta y el resultado es almacenado en un objeto cursor
       String sqlQUERY="select usuario,password from Usuarios where usuario='"+elUsuario+"'";
        sqlQUERY+=" and password ='"+laClave +"'";


        Cursor cursor = db.rawQuery(sqlQUERY,null);

        int i=0,i2=0;
        i2= cursor.getCount();
        if (cursor.moveToFirst())
        {
            do
            {
                //Recorremos el cursor para llenar los arreglos que contienen
                //el codigo y el nombre de los continentes
                cursor.getInt(0);
                i++;
            } while (cursor.moveToNext());
        }
        db.close();
        return i;
    }
}
