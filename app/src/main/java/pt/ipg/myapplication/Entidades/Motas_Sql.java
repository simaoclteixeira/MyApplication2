package pt.ipg.myapplication.Entidades;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

public class Motas_Sql {
    SQLiteDatabase connection;

    public Motas_Sql(SQLiteDatabase conn){
        connection=conn;

    }

    public void inserir(Mota novo){


        ContentValues dados = new ContentValues();

        dados.put("Marca",novo.getMarca());
        dados.put("Modelo",novo.getModelo());
        dados.put("Cilindrada",novo.getCilindrada());
        dados.put("Peso",(Float) novo.getPeso());

        connection.insertOrThrow("TBL_Motas",null,dados);


    }

    public void eliminar(int id_mota){


        connection.delete("TBL_Motas","Id_Motas=" + id_mota,null);


    }

    public void editar(Mota mota){


        ContentValues dados = new ContentValues();

        dados.put("Marca",mota.getMarca());
        dados.put("Modelo",mota.getModelo());
        dados.put("Cilindrada",mota.getCilindrada());
        dados.put("Peso",(Float) mota.getPeso());

        connection.update("TBL_Motas",dados,"Id_Motas="+mota.getId_Motas(),null);


    }

    public ArrayAdapter<Mota> listar (Context context){
        ArrayAdapter<Mota> lista = new ArrayAdapter<Mota>(context,android.R.layout.simple_list_item_1);

        Cursor cursor=connection.query("TBL_Motas",null,null,null,null,null,null);
        cursor.moveToFirst();

        do {
            Mota mota=new Mota();
            mota.setId_Motas(cursor.getInt(0));
            mota.setMarca(cursor.getString(1));
            mota.setModelo(cursor.getString(2));
            mota.setCilindrada(cursor.getString(3));
            mota.setPeso(cursor.getFloat(4));

            lista.add(mota);

        }
        while (cursor.moveToNext());

        return lista;

    }
}
