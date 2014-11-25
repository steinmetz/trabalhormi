/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package comunicacao;

import banco.Banco;
import beans.Funcionario;
import beans.Produto;
import frames.LoginFrame;
import frames.TelaProdutos;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

 

/**
 *
 * @author charles
 */
public class ClienteProduto extends UnicastRemoteObject implements IClienteProduto{

    public TelaProdutos c;
    
    public ClienteProduto(TelaProdutos c) throws RemoteException {
        this.c = c;
    }

    @Override
    public void inserirProduto(final Produto p) throws RemoteException {
        new Thread(new Runnable() {

            @Override
            public void run() {
                Banco b;
                try {
                    b = new Banco();
                    b.inserirProdutos(p);
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }).start();
    }

    @Override
    public Produto buscarProduto(final int id) throws RemoteException {
        Produto p = null;
        new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Banco b = new Banco();
                    Produto p = b.buscarProdutos(id);
                } catch (SQLException ex) {
                    Logger.getLogger(ClienteProduto.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        }).start();
        return p;
    }
 
    
}
