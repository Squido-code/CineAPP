package com.guillermo.cine.login.presenter;

import com.guillermo.cine.login.contract.ContratoLogin;
import com.guillermo.cine.login.model.ModelLogin;
import com.guillermo.cine.login.view.LoginView;

public class PresenterLogin implements ContratoLogin.Presenter {
    private final LoginView loginView;
    private final ModelLogin modelLogin;

    public PresenterLogin(LoginView loginView) {
        this.loginView = loginView;
        modelLogin = new ModelLogin();
    }

    @Override
    public void getUser(String user, String pass) {
        modelLogin.checkUser(new ContratoLogin.Model.LoginListener() {
            @Override
            public void onResolve(boolean existe) {
                loginView.success();
            }

            @Override
            public void onReject(String error) {
                System.out.println("Error al recibir los datos");
            }
        });
        
    }
}
