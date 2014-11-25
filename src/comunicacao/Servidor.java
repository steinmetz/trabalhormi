/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacao;

import beans.Funcionario;
import frames.ServidorFrame;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
        System.out.println(""+msg);
        //s.adicionaMsg(msg);
    }

    public void enviaMsgProCliente(String msg) {
        try {
            c.recebeMensagemDoServidor(msg);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void login(String usuario, String senha) {
        try {
            //buscar no banco aqui
            Funcionario f = new Funcionario(1, usuario, "adm", usuario, senha, 1);
            returnLogin(f);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
    
    public void returnLogin(Funcionario func) {
        try {
            c.loginReceive(func);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}