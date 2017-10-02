package com.jefersonsilva.contatos;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.room.Room;

import java.util.List;

public class ContatosViewModel extends AndroidViewModel {

    private final ContatoDao contatoDao;
    private MutableLiveData<Estado> estado;
    private LiveData<List<Contato>> contatos;

    public ContatosViewModel(Application application) {
        super(application);

        ContatoDatabase db =
                Room.databaseBuilder(this.getApplication(),
                        ContatoDatabase.class, "contatos-db").build();

        contatoDao = db.getContatoDao();
    }

    public LiveData<Estado> getEstado() {
        if (estado == null) {
            estado = new MutableLiveData<>();
            estado.setValue(Estado.LISTA);
        }
        return estado;
    }

    public void vaiProFormulario() {
        estado.setValue(Estado.FORMULARIO);
    }

    public LiveData<List<Contato>> getContatos() {
        if (contatos == null) {
            contatos = contatoDao.buscaTodos();
        }
        return contatos;
    }

    public void insere(final Contato contato) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                contatoDao.insere(contato);
            }
        }).start();

        estado.setValue(Estado.LISTA);
    }
}










