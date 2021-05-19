package com.example.fragmentstate;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Random;

public class FragmentoInicial extends Fragment implements View.OnClickListener{

    private static final String palabras="Hi:Bye:Hello:Cheese:Puppies";
    private static final String VALOR_GUARDADO = "valorGuardado";

    public FragmentoInicial() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmento_inicial, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = (Button) getView().findViewById(R.id.boton);
        button.setOnClickListener(this);

        if(savedInstanceState!=null){
            TextView textView = (TextView) getView().findViewById(R.id.cadena);
            textView.setText(savedInstanceState.getString(VALOR_GUARDADO));
        } else{
            TextView textView = (TextView) getView().findViewById(R.id.cadena);
            textView.setText(obtenerPalabraAleatoria());
        }
    }

    private String obtenerPalabraAleatoria(){
        String[] tablaPalabras = palabras.split(":");
        int indice = new Random().nextInt(tablaPalabras.length);
        return tablaPalabras[indice];
    }


    @Override
    public void onClick(View v) {
        String palabra = obtenerPalabraAleatoria();
        // Tienes que obtener la vista principal para poder modificarla
        TextView textView = (TextView) getView().findViewById(R.id.cadena);
        textView.setText(palabra);
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        TextView textView = (TextView) getView().findViewById(R.id.cadena);
        outState.putString(VALOR_GUARDADO,textView.getText().toString());

    }
}