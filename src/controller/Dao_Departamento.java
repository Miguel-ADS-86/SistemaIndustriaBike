package controller;

import conexao.Conexao;
import interfaces.It_departamento;
import java.util.List;
import java.util.ArrayList;
import model.Departamento;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

public class Dao_Departamento extends Conexao implements It_departamento {

    @Override
    public void cadastrarDepartamento(Departamento departamento) throws Exception {
        String sql="insert into dbo_departamento(nome_departamento,setor_departamento)"
                + "values(?,?)";
        PreparedStatement stm = super.conectar().prepareStatement(sql);
        stm.setString(1,departamento.getNome());
        stm.setString(2,departamento.getSetor());
        stm.executeUpdate();
        super.desconectar();
        JOptionPane.showMessageDialog(null,"Cadastrado com sucesso");
        
    }

    @Override
    public ArrayList<Departamento> ListarDepartamento() throws Exception {
        ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
        String sql= "select * from dbo_departamento";
        PreparedStatement stm = super.conectar().prepareStatement(sql);
        ResultSet res = stm.executeQuery();
        
        while(res.next()){
          Departamento departamento = new Departamento();
          departamento.setNome(res.getString("nome_departamento"));
          departamento.setSetor(res.getString("setor_departamento"));
          departamentos.add(departamento);
        }
        super.desconectar();
        return departamentos;
    
    }

    @Override
    public void alterarDepartamento(Departamento departamento) throws Exception {
    
    }

    @Override
    public void removerDepartamento(Departamento departamento) throws Exception {
        
    }
    
}
