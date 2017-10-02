package com.jefersonsilva.contatos;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities={Contato.class}, version=1)
public abstract class ContatoDatabase extends RoomDatabase {

    public abstract ContatoDao getContatoDao();

}
