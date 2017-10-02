package com.jefersonsilva.contatos;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface ContatoDao {

    @Insert
    public void insere(Contato... contato);

    @Update
    public void altera(Contato contato);

    @Delete
    public void deleta(Contato contato);

    @Query("SELECT * FROM contato")
    public LiveData<List<Contato>> buscaTodos();

    @Query("SELECT * FROM contato WHERE id=:id")
    public Contato busca(Integer id);

}
