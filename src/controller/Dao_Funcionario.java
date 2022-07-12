package controller;

import conexao.Conexao;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import interfaces.It_funcionario;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Departamento;
import model.Funcionario;
import view.TelaLogin;
import view.TelaPrincipal;

public class Dao_Funcionario extends Conexao implements It_funcionario {

    @Override
    public void cadastrarFuncionario(Funcionario funcionario) throws Exception {
        String sql = "insert into dbo_funcionario"
                + "(nome_funcionario,telefone,loginn,senha,codigo_departamento )"
                + "values(?,?,?,?,?)";
        PreparedStatement stm = super.conectar().prepareStatement(sql);
        stm.setString(1, funcionario.getNome());
        stm.setString(2, funcionario.getTelefone());
        stm.setString(3, funcionario.getLogin());
        stm.setString(4, funcionario.getSenha());
        stm.setInt(5, funcionario.getCodigo_Departamento().getCodigo());
        stm.executeUpdate();
        super.conectar();
        JOptionPane.showMessageDialog(null, "Funcionario inserido com sucesso");
    }

    @Override
    public ArrayList<Funcionario> listarFuncionario() throws Exception {
        ArrayList<Funcionario> funcionarios = new ArrayList<Funcionario>();
        String sql = "select * from dbo_funcionario as f inner join dbo_departamento"
                + " as d on f.codigo_departamento = d.codigo_departamento";
        PreparedStatement stm = super.conectar().prepareStatement(sql);
        ResultSet rs = stm.executeQuery();
        while (rs.next()) {
            Funcionario funcionario = new Funcionario();
            Departamento departamento = new Departamento();
            funcionario.setCodigo(rs.getInt("codigo_funcionario"));
            funcionario.setNome(rs.getString("nome_funcionario"));
            funcionario.setTelefone(rs.getString("telefone"));
            funcionario.setLogin(rs.getString("loginn"));
            funcionario.setSenha(rs.getString("senha"));
            departamento.setCodigo(rs.getInt("codigo_departamento"));
            departamento.setNome(rs.getString("nome_departamento"));
            departamento.setSetor(rs.getString("setor_departamento"));
            funcionario.setCodigo_Departamento(departamento);
            
            funcionarios.add(funcionario);

        }
        return funcionarios;
    }

    @Override
    public ArrayList<Funcionario> pesquisarFuncionario(Funcionario funcionario) throws Exception {
        return null;
    }

    @Override
    public void alterarFuncionario(Funcionario funcionario) throws Exception {
        String sql = "update dbo_funcionario set nome=?,telefone=?,loginn=?,"
                + "senha=?,codigo_departamento=? where codigo_funcionario=?";
        PreparedStatement stm = super.conectar().prepareStatement(sql);
        stm.setString(1, funcionario.getNome());
        stm.setString(2,funcionario.getTelefone());
        stm.setString(3, funcionario.getLogin());
        stm.setString(4,funcionario.getSenha());
        stm.setInt(5,funcionario.getCodigo_Departamento().getCodigo());
        stm.setInt(6,funcionario.getCodigo());
        stm.executeUpdate();
        super.desconectar();
        JOptionPane.showMessageDialog(null,"alterado com  sucesso!");
        
    }

    @Override
    public void removerFuncionario(Funcionario funcionario) throws Exception {

    }
    
    public void verificarLogin(String login,String senha){
        try {
           String sql="select * from dbo_funcionario where loginn =? and senha=?"; 
           PreparedStatement stm = super.conectar().prepareStatement(sql);
           stm.setString(1, login);
           stm.setString(2, senha);
           ResultSet rs = stm.executeQuery();
           if(rs.next()){// esse re.nex() ele alem de retorna os registros ele retorna verdadeiro ou falso
               TelaPrincipal obj = new TelaPrincipal();
               TelaLogin t = new TelaLogin();
               t.dispose();
               obj.setVisible(true);
           }else{
           
           JOptionPane.showMessageDialog(null, "login e senha invalidos");
            
           }
           
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
