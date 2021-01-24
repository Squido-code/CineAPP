package com.guillermo.cine.login.contract;

public interface ContratoLogin {
    interface View {
        void success();

        void error(String mensage);

    }

    interface Presenter {
        void getUser(String user,String pass);


    }
    interface Model{
        void checkUser(LoginListener loginListener);


        /*Reactivo*/
        interface LoginListener {
            void onResolve(boolean existe);

            void onReject(String error);
        }
    }
}
