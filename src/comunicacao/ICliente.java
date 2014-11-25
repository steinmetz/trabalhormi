package comunicacao;


import beans.Funcionario;
import java.rmi.Remote;
import java.rmi.RemoteException;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author usrlab25
 */
public interface ICliente extends Remote{
    public void recebeMensagemDoServidor(String msg) throws RemoteException;
    
    
    public void loginReceive(Funcionario f) throws RemoteException;
    
}

