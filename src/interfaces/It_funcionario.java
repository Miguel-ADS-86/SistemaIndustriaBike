package interfaces;

import java.util.ArrayList;
import model.Funcionario;

public interface It_funcionario {
    
    public void cadastrarFuncionario(Funcionario funcionario)throws Exception;
    public ArrayList<Funcionario> listarFuncionario()throws Exception;
    public ArrayList<Funcionario> pesquisarFuncionario(Funcionario funcionario)throws Exception;
    public void alterarFuncionario(Funcionario funcionario)throws Exception;
    public void removerFuncionario(Funcionario funcionario)throws Exception;
    
}
