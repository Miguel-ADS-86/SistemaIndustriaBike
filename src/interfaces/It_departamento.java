package interfaces;

import java.util.ArrayList;
import model.Departamento;

public interface It_departamento {
    public void cadastrarDepartamento(Departamento departamento)throws Exception;
    public ArrayList<Departamento> listarDepartamento()throws Exception;
    public ArrayList<Departamento> pesquisarDepartamento(Departamento departamento)throws Exception;
    public void alterarDepartamento(Departamento departamento)throws Exception;
    public void removerDepartamento(Departamento departamento)throws Exception;
    
}
