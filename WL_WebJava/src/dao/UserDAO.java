package dao;

import java.util.ArrayList;
import java.util.List;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import basic.User;

public class UserDAO {
	
	public List<User> listUsers() {
        
        List<User> lista = new ArrayList<User>();
     
        try{
        	DataBaseConnection db = new DataBaseConnection();
            Connection con = db.getConexaoMySQL();
            Statement stm = con.createStatement();
            String sql = "SELECT * FROM TB_USUARIOS";
            ResultSet rs = stm.executeQuery(sql);

            while (rs.next())
            {
            	User us= new User();
            	us.setName(rs.getString("nome"));
            	us.setCpf(rs.getString("cpf"));
            	us.setDateBirthday(rs.getString("nascimento"));
            	us.setPassword(rs.getString("senha"));
                lista.add(us);
            }
            
            stm.close();
            con.close();
            
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
        return lista;
    }  
	
	public boolean insertUpdateTbUsuarios(User user) {
//		String sql = "CREATE PROCEDURE UPD_INS_USERS (\r\n" + 
//				"  NOME VARCHAR(200),\r\n" + 
//				"  CPF VARCHAR(11),\r\n" + 
//				"  NASCIMENTO VARCHAR(10),\r\n" + 
//				"  SENHA LONGTEXT)\r\n" + 
//				"AS\r\n" + 
//				"BEGIN\r\n" + 
//				"  IF (EXISTS(SELECT CPF FROM TB_USUARIOS WHERE (CPF = ?))) THEN\r\n" + 
//				"    UPDATE TB_USUARIOS\r\n" + 
//				"    SET NOME = ?,\r\n" + 
//				"		 CPF = ?,\r\n" + 
//				"        NASCIMENTO = ?,\r\n" + 
//				"        SENHA = ?\r\n" + 
//				"    WHERE (CPF = ?);\r\n" + 
//				"  ELSE\r\n" + 
//				"    INSERT INTO TB_USUARIOS (\r\n" + 
//				"        NOME,\r\n" + 
//				"		 CPF,\r\n" + 
//				"        NASCIMENTO,\r\n" + 
//				"        SENHA)\r\n" + 
//				"    VALUES (\r\n" + 
//				"        ?,\r\n" + 
//				"        ?,\r\n" + 
//				"        ?,\r\n" + 
//				"        ?);\r\n" + 
//				"END";
//		 try{
//	        	DataBaseConnection db = new DataBaseConnection();
//	            Connection con = db.getConexaoMySQL();
//	            PreparedStatement pstmt = con.prepareStatement(sql);
//	            pstmt.setString(1, user.getCpf());
//	            pstmt.setString(2, user.getName());
//	            pstmt.setString(3, user.getCpf());
//	            pstmt.setString(4, user.getDateBirthday());
//	            pstmt.setString(5, user.getPassword());
//	            pstmt.setString(6, user.getCpf());
//	            pstmt.setString(7, user.getName());
//	            pstmt.setString(8, user.getCpf());
//	            pstmt.setString(9, user.getDateBirthday());
//	            pstmt.setString(10, user.getPassword());
//	            
//	    		System.out.println("Used procedure = "+ pstmt.toString());
//	    		pstmt.execute();
//	    		pstmt.close();
//	            con.close();
//	        }catch(Exception e){
//	            e.printStackTrace();
//	            return false;
//	        }
		 
		 String sql = "INSERT INTO TB_USUARIOS (\r\n" +
		 		" NOME,\r\n" +
		 		" CPF,\r\n" +
		 		" NASCIMENTO,\r\n" +
		 		" SENHA)\r\n" +
		 		" VALUES (\r\n" +
		 		" ?,\r\n" +
		 		" ?,\r\n" +
		 		" ?,\r\n" +
		 		" ?);";
			 try{
		        	DataBaseConnection db = new DataBaseConnection();
		            Connection con = db.getConexaoMySQL();
		            PreparedStatement pstmt = con.prepareStatement(sql);
		            pstmt.setString(1, user.getName());
		            pstmt.setString(2, user.getCpf());
		            pstmt.setString(3, user.getDateBirthday());
		            pstmt.setString(4, user.getPassword());
		            
		    		System.out.println("Used procedure = "+ pstmt.toString());
		    		pstmt.execute();
		    		pstmt.close();
		            con.close();
		        }catch(Exception e){
		            e.printStackTrace();
		            return false;
		        }
		return true;
	}

	public boolean excludeUser(String cpf) {
		String sql = "DELETE FROM TB_USUARIOS\r\n" + 
				"		 WHERE CPF = ?;";
		 try{
	        	DataBaseConnection db = new DataBaseConnection();
	            Connection con = db.getConexaoMySQL();
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, cpf);
	            
	    		System.out.println("Used procedure = "+ pstmt.toString());
	    		pstmt.execute();
	    		pstmt.close();
	            con.close();
	        }catch(Exception e){
	            e.printStackTrace();
	            return false;
	        }
	return true;
	}
	
	public boolean updateTbUsuarios(User user) {
		 
		 String sql = "UPDATE TB_USUARIOS \r\n" + 
					" SET NOME = ?,\r\n" + 
					" CPF = ?,\r\n" + 
					" NASCIMENTO = ?,\r\n" + 
					" SENHA = ?\r\n" + 
					" WHERE (CPF = ?);";
			 try{
		        	DataBaseConnection db = new DataBaseConnection();
		            Connection con = db.getConexaoMySQL();
		            PreparedStatement pstmt = con.prepareStatement(sql);
		            pstmt.setString(1, user.getName());
		            pstmt.setString(2, user.getCpf());
		            pstmt.setString(3, user.getDateBirthday());
		            pstmt.setString(4, user.getPassword());
		            pstmt.setString(5, user.getCpf());
		            
		    		System.out.println("Used procedure = "+ pstmt.toString());
		    		pstmt.executeUpdate();
		    		pstmt.close();
		            con.close();
		        }catch(Exception e){
		            e.printStackTrace();
		            return false;
		        }
		return true;
	}

	public boolean verifyCpfExists(String cpf) {
		 String sql = "SELECT count(*) as QTD FROM TB_USUARIOS \r\n" +
					" WHERE (CPF = ?);";
		 try{
	        	DataBaseConnection db = new DataBaseConnection();
	            Connection con = db.getConexaoMySQL();
	            PreparedStatement pstmt = con.prepareStatement(sql);
	            pstmt.setString(1, cpf);
	            
	    		System.out.println("Used procedure = "+ pstmt.toString());
	    		ResultSet rs = pstmt.executeQuery();
	            
	    		if(rs != null && rs.next()) {
	    			if(Integer.parseInt(rs.getString("QTD")) > 0) {
		            	return true;
		            }
	    		}    

	    		pstmt.close();
	            con.close();
	        }catch(Exception e){
	            e.printStackTrace();
	            return true;
	        }
		return false;
	}
}
