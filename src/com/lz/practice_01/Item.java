package com.lz.practice_01;

/**
 * ��Ʒ��
 * @author zzz
 *
 */
public class Item {

	
	private String code;// ��Ʒ���
	private String name;//// ��Ʒ����
	private String type;// ��Ʒ��������
	private double price;// ��Ʒ�۸�
	public static int totalNum;// ����Ʒ����
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
