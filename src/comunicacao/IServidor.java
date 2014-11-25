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
public interface IServidor extends Remote {
    
    public void recebeCilente(ICliente c) throws RemoteException;
    public void recebeMensagemDoCliente(String msg) throws RemoteException;
    
    
    public void login(String usuario, String senha) throws RemoteException;
    public void returnLogin(Funcionario func) throws RemoteException;
}
