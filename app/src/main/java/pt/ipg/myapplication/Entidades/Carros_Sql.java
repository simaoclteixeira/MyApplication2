package pt.ipg.myapplication.Entidades;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.ArrayAdapter;

public class Carros_Sql {
    SQLiteDatabase connection;

    public Carros_Sql(SQLiteDatabase conn){
        connection=conn;

    }

    public void inserir(Carro novo){


        ContentValues dados = new ContentValues();

        dados.put("Marca",novo.getMarca());
        dados.put("Modelo",novo.getModelo());
        dados.put("Lotacao",(Float) novo.getLotacao());
        dados.put("Tracao",novo.getTracao());
        dados.put("Peso",(Float) novo.getPeso());

        connection.insertOrThrow("TBL_Carros",null,dados);


    }

    public void eliminar(int id_carro){


        connection.delete("TBL_Carros","Id_Carros=" + id_carro,null);


    }

    public void editar(Carro carro){


        ContentValues dados = new ContentValues();

        dados.put("Marca",carro.getMarca());
        dados.put("Modelo",carro.getModelo());
        dados.put("Lotacao",(Float) carro.getLotacao());
        dados.put("Tracao",carro.getTracao());
        dados.put("Peso",(Float) carro.getPeso());

        connection.update("TBL_Carros",dados,"Id_Carros="+carro.getId_Carros(),null);


    }

    public ArrayAdapter<Carro> listar (Context context){
        ArrayAdapter<Carro> lista = new ArrayAdapter<Carro>(context,android.R.layout.simple_list_item_1);

        Cursor cursor=connection.query("TBL_Carros",null,null,null,null,null,null);
        cursor.moveToFirst();

        do {
            Carro carro=new Carro();
            carro.setId_Carros(cursor.getInt(0));
            carro.setMarca(cursor.getString(1));
            carro.setModelo(cursor.getString(2));
            carro.setLotacao(cursor.getFloat(3));
            carro.setTracao(cursor.getString(4));
            carro.setPeso(cursor.getFloat(5));

            lista.add(carro);

        }
        while (cursor.moveToNext());

        return lista;

    }


}
