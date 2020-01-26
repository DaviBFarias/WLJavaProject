package utility;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import basic.User;
import dao.UserDAO;

public class ListAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	
	List<User> list;
	
	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}

	@Override
	public String execute() {
		try {
			UserDAO userDAO = new UserDAO();
			setList(userDAO.listUsers());
		} catch (Exception e) {
			return "error";
		}
		return "success";
    }
}
