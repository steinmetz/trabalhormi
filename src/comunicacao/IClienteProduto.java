package comunicacao;

import beans.Funcionario;
import beans.Produto;
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
public interface IClienteProduto extends Remote {

    public void inserirProduto(Produto p) throws RemoteException;

    public Produto buscarProduto(int id) throws RemoteException;

}
