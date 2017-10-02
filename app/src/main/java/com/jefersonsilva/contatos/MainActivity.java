package com.jefersonsilva.contatos;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ContatosViewModel viewModel =
                ViewModelProviders.of(this).get(ContatosViewModel.class);

        viewModel.getEstado().observe(this, new Observer<Estado>() {
                    @Override
                    public void onChanged(@Nullable Estado estado) {
                        FragmentManager manager = getSupportFragmentManager();
                        FragmentTransaction tx = manager.beginTransaction();
                        switch(estado) {
                            case LISTA:
                                tx.replace(R.id.frame_main, new ContatosFragment());
                                break;

                            case FORMULARIO:
                                tx.replace(R.id.frame_main, new FormularioFragment());
                                break;
                        }
                        tx.commit();
                    }
                });
    }
}
