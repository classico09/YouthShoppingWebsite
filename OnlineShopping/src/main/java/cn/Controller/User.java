package cn.Controller;

public class User {
	private int id;
	private String name;
	private String email;
	private String pass;
	private String phone;
	
	public User() {
		super();
	}

	public User(int id, String name, String email, String pass, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.pass = pass;
		this.phone = phone;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", email=" + email + ", pass=" + pass + ", phone=" + phone + "]";
	}
	
	
}
