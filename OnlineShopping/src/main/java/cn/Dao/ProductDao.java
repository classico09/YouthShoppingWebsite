package cn.Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;
import cn.Controller.*;

public class ProductDao {
	private Connection con;
	private String query;
	private PreparedStatement pst;
	private ResultSet rs;
	
	//connect database
	public ProductDao(Connection con) {
		this.con = con;
	}
	
	
	//list product on homepage
	public List<Product> getAllProduct(){
		List<Product> products = new ArrayList<Product>();
		
		try {
			query = "select * from Product";
			pst = this.con.prepareStatement(query);
			rs = pst.executeQuery();
			while(rs.next()) {
				Product row = new Product();
				row.setId(rs.getInt("ProductID"));
				row.setName(rs.getString("Name"));
				row.setPrice(rs.getDouble("Price"));
				row.setImage(rs.getString("Image"));
				row.setDetail(rs.getString("Detail"));
				
				products.add(row);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return products;
	}
	
	
	//list product on cart
	public List<Cart> getCartProducts(ArrayList<Cart> cartList){
		List<Cart> products = new ArrayList<Cart>();
		
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					query = "select * from Product where ProductID=?";
					pst = this.con.prepareStatement(query);
					pst.setInt(1,  item.getId());
					rs = pst.executeQuery();
					
					while(rs.next()) {
						Cart row = new Cart();
						row.setId(rs.getInt("ProductID"));
						row.setName(rs.getString("Name"));
						row.setPrice(rs.getDouble("Price")*item.getQuantity());
						row.setImage(rs.getString("Image"));
						row.setDetail(rs.getString("Detail"));
						row.setQuantity(item.getQuantity());
						products.add(row);
					}
					
				}
			}
			
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
		
		return products;
	}
	
	//get total price from cart
	public double getTotalCartPrice(ArrayList<Cart> cartList) {

		double sum = 0;
		
		try {
			if(cartList.size()>0) {
				for(Cart item:cartList) {
					query = "select Price from Product where ProductID=?";
					pst = this.con.prepareStatement(query);
					pst.setInt(1, item.getId());
					rs = pst.executeQuery();
					
					while(rs.next()) {
						sum += rs.getDouble("Price")*item.getQuantity();
					}
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return sum;
	}
	
	//new product
	public boolean productNew(String name, double price, String image, String detail) {
		User user = null;
		boolean flag = false;
		try {
			query = "insert into Product(Name, Price, Image, Detail) values(?, ?, ?, ?)";
			pst = this.con.prepareStatement(query);
			
			pst.setString(1, name);
			pst.setDouble(2, price);
			pst.setString(3, image);
			pst.setString(4, detail);
			
			int count = pst.executeUpdate();
			
			if(count != 0) {
				flag = true;
			}

			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}
		
		return flag;
	}
}








