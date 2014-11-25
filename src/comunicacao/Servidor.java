/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacao;

import banco.Banco;
import beans.Funcionario;
import frames.LoginFrame;
import frames.ServidorFrame;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author charles
 */
public class Servidor extends UnicastRemoteObject implements IServidor {

    ICliente c;
    ServidorFrame s;

    public Servidor(ServidorFrame s) throws RemoteException {
        this.s = s;
    }

    @Override
    public void recebeCilente(ICliente c) throws RemoteException {
        this.c = c;
        System.out.println("Recebi um cliente");
    }

    @Override
    public void recebeMensagemDoCliente(String msg) throws RemoteException {
        System.out.println("" + msg);
        //s.adicionaMsg(msg);
    }

    public void enviaMsgProCliente(String msg) {
        try {
            c.recebeMensagemDoServidor(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void login(final String usuario, final String senha) {
        //buscar no banco aqui
        new Thread(new Runnable() {

            @Override
            public void run() {
                Funcionario f = null;
                try {
                    Banco b = new Banco();
                    f = b.login(usuario, senha);
                    b.desconecta();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
                try {
                    returnLogin(f);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }

    public void returnLogin(Funcionario func) {
        try {
            c.loginReceive(func);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
