
package model;

import java.util.ArrayList;

public class Funcionario {
    private int codigo;
    private Departamento codigo_departamento;
    private String nome;
    private String telefone;
    private String login;
    private String senha;
  
    public int getCodigo() {
        return codigo;
    }

  
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

   
    public String getNome() {
        return nome;
    }

  
    public void setNome(String nome) {
        this.nome = nome;
    }

  
    public String getTelefone() {
        return telefone;
    }


    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

   
    public String getLogin() {
        return login;
    }

  
    public void setLogin(String login) {
        this.login = login;
    }

  
    public String getSenha() {
        return senha;
    }

  
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public Departamento getCodigo_Departamento() {
        return codigo_departamento;
    }

  
    public void setCodigo_Departamento(Departamento codigo_departamento) {
        this.codigo_departamento = codigo_departamento;
    }
    
    
    
}
