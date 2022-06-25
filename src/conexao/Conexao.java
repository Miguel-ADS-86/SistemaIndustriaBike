package conexao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
public class Conexao {
    private final String DRIVER="com.microsoft.sqlserver.jdbc.SQLServerDriver";
    private final String URL="jdbc:sqlserver://localhost\\SQLEXPRESS:1433;databaseName=industria_bike";
    private final String USUARIO="miguel";
    private final String SENHA="123";
    
    private Connection conn;
    
    public Connection conectar(){
     try{
     Class.forName(DRIVER);
     conn = DriverManager.getConnection(URL,USUARIO,SENHA);
     return conn;
     }catch(Exception e){
         JOptionPane.showMessageDialog(null,"Erro na conexão com o banco");
         e.printStackTrace();
     }
     return conn;
    }  
    
    public void desconectar() throws SQLException{
       conn.close();
    }
    
}
