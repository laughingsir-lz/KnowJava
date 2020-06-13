package com.lz.practice_01;

/**
 * 商品类测试
 * @author zzz
 *
 */
public class ItemDemo {

	public static void main(String[] args) {
		//创建computer对象
		Item computer1 = new Item();
		computer1.setCode("666");
		computer1.setName(" 戴尔(DELL) 游戏笔记本");
		computer1.setType("游戏");
		computer1.setPrice(5499.00);
		//总商品数量加1
		Item.totalNum++;
		Item computer2 = new Item();
		computer2.setCode("007");
		computer2.setName(" 苹果（Macbook pro）笔记本");
		computer2.setType("电脑,办公");
		computer2.setPrice(18000.00);
		Item.totalNum++;
		//输出computer对象信息
		System.out.println(computer1);
		System.out.println(computer2);
		//输出总商品数量
		System.out.println(Item.totalNum);
		
	}

}
