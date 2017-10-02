package com.jefersonsilva.contatos;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FormularioFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_form, container, false);

        final ContatosViewModel viewModel =
                ViewModelProviders.of(getActivity()).get(ContatosViewModel.class);

        final EditText campoNome = view.findViewById(R.id.form_nome);
        final EditText campoEmail = view.findViewById(R.id.form_email);
        final Button salvar = view.findViewById(R.id.form_salvar);
        salvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Contato contato = new Contato();
                contato.setNome(campoNome.getText().toString());
                contato.setEmail(campoEmail.getText().toString());

                viewModel.insere(contato);
            }
        });

        return view;
    }
}
