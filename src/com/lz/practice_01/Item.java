package com.lz.practice_01;

/**
 * 商品类
 * @author zzz
 *
 */
public class Item {

	
	private String code;// 商品编号
	private String name;//// 商品名称
	private String type;// 商品编具体类别
	private double price;// 商品价格
	public static int totalNum;// 总商品数量
	public Item() {
		// TODO Auto-generated constructor stub
	}
	public Item(String code,String name) {
		// TODO Auto-generated constructor stub
		
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return "name=" + name + ", price=" + price ;
	}
}
