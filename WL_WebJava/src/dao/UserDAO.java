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
		
		/*
		    Procedure code ===================================
		 
		    DELIMITER $$
			DROP PROCEDURE IF EXISTS UPD_INS_USERS;
			CREATE PROCEDURE UPD_INS_USERS(in nomein varchar(200),
				 in cpfin varchar(11),
				 in nascimentoin varchar(10),
				 in senhain LONGTEXT)
			BEGIN
			 
			    IF EXISTS(SELECT CPF FROM TB_USUARIOS WHERE (CPF = cpfin)) THEN
			    UPDATE `TB_USUARIOS`
			    SET NOME = nomein,
					  CPF = cpfin,
			        NASCIMENTO = nascimentoin,
			        SENHA = senhain
			    WHERE (CPF = cpfin);
			  ELSE
			    INSERT INTO TB_USUARIOS (
			        NOME,
					  CPF,
			        NASCIMENTO,
			        SENHA)
			    VALUES (
			        nomein,
			        cpfin,
			        nascimentoin,
			        senhain);
			  END IF;
			END$$
			 
			DELIMITER ;
		 */
		
		String sql = "{call UPD_INS_USERS(?, ?, ?, ?)}";
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
