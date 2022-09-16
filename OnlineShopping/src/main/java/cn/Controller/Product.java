package cn.Controller;

public class Product {
	private int id;
	private String name;
	private double price;
	private String image;
	private String detail;
	
	
	
	public Product() {
	}



	public Product(int id, String name, double price, String image, String detail) {
		super();
		this.id = id;
		this.name = name;
		this.price = price;
		this.image = image;
		this.detail = detail;
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



	public double getPrice() {
		return price;
	}



	public void setPrice(double price) {
		this.price = price;
	}



	public String getImage() {
		return image;
	}



	public void setImage(String image) {
		this.image = image;
	}



	public String getDetail() {
		return detail;
	}



	public void setDetail(String detail) {
		this.detail = detail;
	}



	@Override
	public String toString() {
		return "Product [id=" + id + ", name=" + name + ", price=" + price + ", image=" + image + ", detail=" + detail
				+ "]";
	}
	
	
	
}
