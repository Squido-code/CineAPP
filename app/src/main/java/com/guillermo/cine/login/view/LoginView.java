package com.guillermo.cine.login.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;


import com.guillermo.cine.R;

import com.guillermo.cine.beans.Pelicula;
import com.guillermo.cine.login.contract.ContratoLogin;
import com.guillermo.cine.login.presenter.PresenterLogin;

import java.util.ArrayList;

public class LoginView extends AppCompatActivity implements ContratoLogin.View {
    private PresenterLogin presenterLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_view);
        presenterLogin = new PresenterLogin(this);
    }

    public void aceptar(View view){

    }


    @Override
    public void success(ArrayList<Pelicula> peliculas) {

    }

    @Override
    public void error(String mensage) {

    }
}