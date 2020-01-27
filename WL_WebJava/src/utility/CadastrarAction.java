package utility;

import com.opensymphony.xwork2.ActionSupport;

import basic.User;
import dao.UserDAO;

public class CadastrarAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	
	//Parameters
	private String username;
	private String datebirthday;
	private String cpf;
	private String password;

	//Getters and setters
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDatebirthday() {
		return datebirthday;
	}
	public void setDatebirthday(String datebirthday) {
		this.datebirthday = datebirthday;
	}
	public String getCpf() {
		return cpf;
	}
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	//Methods
	public String register() {
		Functions check = new Functions();
		User us = new User(getUsername(), getCpf(), getDatebirthday(), null);
		//validate Name
		if(!check.validateName(us.getName())) {
			addActionMessage(getText("error.validationName"));
			return "failure";
		}
		//validate CPF
		if(!check.validateCPF(us.getCpf())) {
			addActionMessage(getText("error.validationCpf"));
			return "failure";
		}
		
		//validate birthday
		if(!check.validateBirthday(us.getDateBirthday())) {
			addActionMessage(getText("error.validationBirthday"));
			return "failure";
		}
		//generating password
		us.setPassword(check.generatePassword(us.getCpf(), us.getDateBirthday()));
		if(us.getPassword().equals("")) {
			addActionMessage(getText("error.generatePassword"));
			return "failure";
		}
		
		//saving into database
		UserDAO userDAO = new UserDAO();
		if(userDAO.verifyCpfExists(us.getCpf())) {
			addActionMessage(getText("error.insertDuplicado"));
			return "failure";
		}
		if(!userDAO.insertUpdateTbUsuarios(us)) {
			addActionMessage(getText("error.insert"));
			return "failure";
		}
		
		addActionMessage(getText("success.register"));
		return "success";
        
    }
	
	@Override
	public String execute() {
		return "success";
        
    }
	
	public String update() {
		return "success";
        
    }
	
	public String updateRegister() {
		Functions check = new Functions();
		User us = new User(getUsername(), getCpf(), getDatebirthday(), null);
		//validate Name
		if(!check.validateName(us.getName())) {
			addActionMessage(getText("error.validationName"));
			return "failure";
		}
		//validate CPF
		if(!check.validateCPF(us.getCpf())) {
			addActionMessage(getText("error.validationCpf"));
			return "failure";
		}
		
		//validate birthday
		if(!check.validateBirthday(us.getDateBirthday())) {
			addActionMessage(getText("error.validationBirthday"));
			return "failure";
		}
		//generating password
		us.setPassword(check.generatePassword(us.getCpf(), us.getDateBirthday()));
		if(us.getPassword().equals("")) {
			addActionMessage(getText("error.generatePassword"));
			return "failure";
		}
		
		//saving into database
		UserDAO userDAO = new UserDAO();
		if(!userDAO.insertUpdateTbUsuarios(us)) {
			addActionMessage(getText("error.insert"));
			return "failure";
		}
		
		addActionMessage(getText("success.update"));
		return "success";
        
    }
}
