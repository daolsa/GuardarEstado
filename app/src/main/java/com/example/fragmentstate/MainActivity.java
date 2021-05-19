package com.example.fragmentstate;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
/**
 * Ejemplo para ver cómo guardar datos de un estado en caso de cambio de orientación.
 * */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(getSupportFragmentManager().findFragmentByTag("TAG") == null){
            FragmentoInicial fragmentoInicial = new FragmentoInicial();
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.fragment,fragmentoInicial,"TAG");
            ft.commit();
        }
    }

}