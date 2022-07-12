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
    public ArrayList<Departamento> listarDepartamento() throws Exception {
        ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
        String sql= "select * from dbo_departamento";
        PreparedStatement stm = super.conectar().prepareStatement(sql);
        ResultSet res = stm.executeQuery();
        
        while(res.next()){
          Departamento departamento = new Departamento();
          departamento.setCodigo(res.getInt("codigo_departamento"));
          departamento.setNome(res.getString("nome_departamento"));
          departamento.setSetor(res.getString("setor_departamento"));
          departamentos.add(departamento);
        }
        super.desconectar();
        return departamentos;
    
    }

    @Override
    public void alterarDepartamento(Departamento departamento) throws Exception {
       String sql="update dbo_departamento set nome_departamento=?,"
               + "setor_departamento=? where codigo_departamento = ?";
       PreparedStatement stm = super.conectar().prepareStatement(sql);
       stm.setString(1, departamento.getNome());
       stm.setString(2,departamento.getSetor());
       stm.setInt(3,departamento.getCodigo());
       stm.executeUpdate();
       super.desconectar();
       JOptionPane.showMessageDialog(null,"Alterado com sucesso");
    }

    @Override
    public void removerDepartamento(Departamento departamento) throws Exception {
        String sql="delete from dbo_departamento where codigo_departamento=?";
        PreparedStatement stm = super.conectar().prepareStatement(sql);
        stm.setInt(1, departamento.getCodigo());
        stm.executeUpdate();
        super.conectar();
        JOptionPane.showMessageDialog(null,"Excluido com sucesso");
        super.desconectar();
    }


    @Override
    public ArrayList<Departamento> pesquisarDepartamento(Departamento departamento) throws Exception {
        ArrayList<Departamento> departamentos = new ArrayList<Departamento>();
        String sql = "select * from dbo_departamento where nome_departamento like ?";
        PreparedStatement stm = super.conectar().prepareStatement(sql);
        stm.setString(1, departamento.getNome());
        ResultSet res = stm.executeQuery();
        while(res.next()){
          Departamento d = new Departamento();
           d.setCodigo(res.getInt("codigo_departamento"));
           d.setNome(res.getString("nome_departamento"));
           d.setSetor(res.getString("setor_departamento"));
           departamentos.add(d);
        }
        super.desconectar();
        return departamentos;
          
    }
    
    //metodo para listar o setor pelo departamento
    public ArrayList<Departamento> listarSetor(int codigo)throws Exception{
       
       ArrayList<Departamento> listas = new ArrayList<Departamento>();
       String sql="select * from dbo_departamento where codigo_departamento = ?";
       PreparedStatement stm = super.conectar().prepareStatement(sql);
       stm.setInt(1,codigo );
       ResultSet rs = stm.executeQuery();
       while(rs.next()){
        Departamento dep = new Departamento();
        dep.setNome(rs.getString("nome_departamento"));
        dep.setSetor(rs.getString("setor_departamento"));
        listas.add(dep);
       }
        super.desconectar();
        return listas;
    }
    
    
}
