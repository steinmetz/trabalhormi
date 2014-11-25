package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Caio
 */
public class Funcionario {
    
    private int id;
    private String nome;
    private String tipo;
    private String login;
    private String senha;
    private int loja_id;

    public Funcionario(int id, String nome, String tipo, String login, String senha, int loja_id) {
        this.id = id;
        this.nome = nome;
        this.tipo = tipo;
        this.login = login;
        this.senha = senha;
        this.loja_id = loja_id;
    }
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }
    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }
    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }
    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }
    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }
    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    /**
     * @return the loja_id
     */
    public int getLoja_id() {
        return loja_id;
    }
    /**
     * @param loja_id the loja_id to set
     */
    public void setLoja_id(int loja_id) {
        this.loja_id = loja_id;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
