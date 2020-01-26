package basic;

public class User {
	//Parameters
	private String name;
	private String dateBirthday;
	private String cpf;
	private String password;
	
	//Empty constructor
	public User () {};
	
	//Full constructor
	public User(String name, String cpf, String dateBirthday, String password) {
		super();
		this.setName(name);
		this.setDateBirthday(dateBirthday);
		this.setCpf(cpf);
		this.setPassword(password);
	}
	
	//Methods
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDateBirthday() {
		return dateBirthday;
	}
	public void setDateBirthday(String dateBirthday) {
		this.dateBirthday = dateBirthday;
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
}
