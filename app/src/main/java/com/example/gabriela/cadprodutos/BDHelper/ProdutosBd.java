package com.example.gabriela.cadprodutos.BDHelper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.gabriela.cadprodutos.model.Produtos;

import java.util.ArrayList;

public class ProdutosBd extends SQLiteOpenHelper {
    //abaixo definimos o nosso banco de dados
    private static final String DATABASE = "bdprodutos";
    private static final int VERSION = 1;

    //aqui definimos o metodo construtor
    public ProdutosBd(Context context) {
        super(context, DATABASE, null, VERSION);

    }

    //aqui oncreate criar a parte das tabelas do banco-definimos uma string chamada produto para criar a tabela a tabela produto ou seja o comando create
    @Override
    public void onCreate(SQLiteDatabase db) {
        String produto = "CREATE TABLE produtos(id INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,nomeproduto TEXT NOT NULL,descricao TEXT NOT NULL,quantidade INTEGER);";

        db.execSQL(produto);

    }

    //abaixo checa se tem uma nova nova versao e substitui para a nova versao
    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        String produto = "DROP TABLE IF EXISTS produtos";
        db.execSQL(produto);
    }

    //metodo salvar aqui salva fizemos variaveis c/ o valor definido uma compactacao passado por values os metodos
    public void salvarProduto(Produtos produto) {
        ContentValues values = new ContentValues();

        values.put("nomeproduto", produto.getNomeProduto());
        values.put("descricao", produto.getDescricao());
        values.put("quantidade", produto.getQuantidade());

        getWritableDatabase().insert("produtos", null, values);
    }

    // Metodo listar
    //criamos um array publico e chamar a classe q criamos no java "Produtos"
    public ArrayList<Produtos> getLista() {
        String[] columns = {"id", "nomeproduto", "descricao", "quantidade"}; //criada a lista e salvar nocursor
        //aqui abaixo é a parte de cursos responsavel para salvar nossa lista
        Cursor cursor = getWritableDatabase().query("produtos", columns, null, null, null, null, null, null);
        ArrayList<Produtos> produtos = new ArrayList<Produtos>();

//criado o while p q toda vez fique passando repetindo para passar p o proximo registro e vai passando pelo arraylist-por isso inicia no zero
        while (cursor.moveToNext()) {
            Produtos produto = new Produtos();
            produto.setId(cursor.getLong(0));
            produto.setNomeProduto(cursor.getString(1));
            produto.setDescricao(cursor.getString(2));
            produto.setQuantidade(cursor.getInt(3));

            //abaixo o add serve p poder estar inserindo dentro do array
            produtos.add(produto);
        }
        return produtos;
    }

}
