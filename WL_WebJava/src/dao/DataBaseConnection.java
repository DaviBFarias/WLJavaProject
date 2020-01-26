package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// In�cio da classe de conex�o//

public class DataBaseConnection {

	public static String status = "N�o conectou...";

	private Connection conexao;
	
	// M�todo Construtor da Classe//
	public DataBaseConnection() {
	}

	// M�todo de Conex�o//

	public Connection getConexaoMySQL() {
	 
		try {
            String driver = "com.mysql.cj.jdbc.Driver";
            String user = "root";
            String pass = "";
            String urlPadrao = "jdbc:mysql://localhost:3306/wl_test?useTimezone=true&serverTimezone=UTC";
            Class.forName(driver);
            conexao = DriverManager.getConnection(urlPadrao,user,pass);
        }
        catch (ClassNotFoundException e){
            System.out.println("ERRO: " + e);
        }
        catch (SQLException e) {
            System.out.println("ERRO: " + e);
        }
		return conexao;
    }
	
	// M�todo que retorna o status da sua conex�o//
	public static String statusConection() {
		return status;
	}
	
	// M�todo que fecha sua conex�o//
	public boolean FecharConexao() {
		try {
			getConexaoMySQL().close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	// M�todo que reinicia sua conex�o//
	public Connection ReiniciarConexao() {
		FecharConexao();
		return getConexaoMySQL();
	}
}
