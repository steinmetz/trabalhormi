/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.io.Serializable;

/**
 *
 * @author charles
 */
public class Estoque implements Serializable{
	public int id;
	public int loja_id;
	public int produto_id;
	public int quantidade;
	public int valor;
}