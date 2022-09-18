package cn.Controller;

public class Mess {
	private int id;
	private String name;
	private String email;
	private String mess;
	private String phone;
	
	public Mess() {
		super();
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
	public String getMess() {
		return mess;
	}
	public void setMess(String mess) {
		this.mess = mess;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Mess(int id, String name, String email, String mess, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.mess = mess;
		this.phone = phone;
	}

	@Override
	public String toString() {
		return "Mess [id=" + id + ", name=" + name + ", email=" + email + ", mess=" + mess + ", phone=" + phone + "]";
	}
	
	
}
