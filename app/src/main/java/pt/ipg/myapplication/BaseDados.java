package pt.ipg.myapplication;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BaseDados extends SQLiteOpenHelper {

    static String a="";

    public BaseDados(Context context){

        super(context,"Bd_veiculos",null,1);
    }




    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(creat_tbl_carros());
        db.execSQL(creat_tbl_motas());
        db.execSQL(creat_tbl_utilizadores());


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        this.onCreate(db);
    }

    public static String creat_tbl_carros(){
        a="Create table if not exists TBL_Carros (" +
                "Id_Carros Integer Primary Key Autoincrement,  "   +
                "Marca Text, " +
                "Modelo text, " +
                "Lotacao real, " +
                "Tracao text, " +
                "Peso real " +
                ") ";
        return a;
    }


    public static String creat_tbl_motas(){
        a="Create table if not exists TBL_Motas (" +
                "Id_Motas Integer Primary Key Autoincrement,  "   +
                "Marca Text, " +
                "Modelo text, " +
                "Tração text, " +
                "Peso real " +
                ") ";
        return a;
    }

    public static String creat_tbl_utilizadores(){
        a="Create table if not exists TBL_Utilizadores (" +
                "Id_Utilizador Integer Primary Key Autoincrement,  "   +
                "Nome Text, " +
                "Email text, " +
                "Data de Nascimento text, " +
                "Morada text " +
                ") ";
        return a;
    }

}
