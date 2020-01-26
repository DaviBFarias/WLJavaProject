package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// Início da classe de conexão//

public class DataBaseConnection {

	public static String status = "Não conectou...";

	private Connection conexao;
	
	// Método Construtor da Classe//
	public DataBaseConnection() {
	}

	// Método de Conexão//

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
	
	// Método que retorna o status da sua conexão//
	public static String statusConection() {
		return status;
	}
	
	// Método que fecha sua conexão//
	public boolean FecharConexao() {
		try {
			getConexaoMySQL().close();
			return true;
		} catch (SQLException e) {
			return false;
		}
	}
	
	// Método que reinicia sua conexão//
	public Connection ReiniciarConexao() {
		FecharConexao();
		return getConexaoMySQL();
	}
}
