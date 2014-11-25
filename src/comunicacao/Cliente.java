/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacao;

import beans.Funcionario;
import frames.LoginFrame;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

 

/**
 *
 * @author charles
 */
public class Cliente extends UnicastRemoteObject implements ICliente{

    public LoginFrame c;
    
    public Cliente(LoginFrame c) throws RemoteException {
        this.c = c;
    }

    @Override
    public void recebeMensagemDoServidor(String msg) throws RemoteException {
        //c.adicionaMsg(msg);
    }

    @Override
    public void loginReceive(Funcionario f) throws RemoteException {
        System.out.println(""+f.getNome());
    
    }
}
