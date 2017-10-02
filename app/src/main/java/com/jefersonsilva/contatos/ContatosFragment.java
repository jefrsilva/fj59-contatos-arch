package com.jefersonsilva.contatos;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

public class ContatosFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contatos, container, false);

        final ListView listaContatos = view.findViewById(R.id.contatos_lista);

        final ContatosViewModel viewModel =
                ViewModelProviders.of(getActivity()).get(ContatosViewModel.class);

        FloatingActionButton fab = view.findViewById(R.id.novo_contato);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                viewModel.vaiProFormulario();
            }
        });

        viewModel.getContatos().observe(this, new Observer<List<Contato>>() {
            @Override
            public void onChanged(@Nullable List<Contato> contatos) {
                ArrayAdapter<Contato> adapter =
                        new ArrayAdapter<Contato>(getContext(),
                                android.R.layout.simple_list_item_1, contatos);
                listaContatos.setAdapter(adapter);
            }
        });

        return view;
    }
}
