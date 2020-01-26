package utility;

import com.opensymphony.xwork2.ActionSupport;

import dao.UserDAO;

public class ExcludeAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private String cpf;
	
	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String exclude() {
		addActionMessage(getCpf() + getText("success.exclude"));
		UserDAO userDAO = new UserDAO();
		if(!userDAO.excludeUser(getCpf())) {
			return "failure";
		}
		return "success";
        
    }
}
