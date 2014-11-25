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
public interface IServidorProduto extends Remote {
    
    public void recebeCilente(IClienteProduto c) throws RemoteException;
    public void recebeMensagemDoCliente(String msg) throws RemoteException;
    
     
}
