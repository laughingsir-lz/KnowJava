package com.lz.practice_01;

/**
 * ��Ʒ�����
 * @author zzz
 *
 */
public class ItemDemo {

	public static void main(String[] args) {
		//����computer����
		Item computer1 = new Item();
		computer1.setCode("666");
		computer1.setName(" ����(DELL) ��Ϸ�ʼǱ�");
		computer1.setType("��Ϸ");
		computer1.setPrice(5499.00);
		//����Ʒ������1
		Item.totalNum++;
		Item computer2 = new Item();
		computer2.setCode("007");
		computer2.setName(" ƻ����Macbook pro���ʼǱ�");
		computer2.setType("����,�칫");
		computer2.setPrice(18000.00);
		Item.totalNum++;
		//���computer������Ϣ
		System.out.println(computer1);
		System.out.println(computer2);
		//�������Ʒ����
		System.out.println(Item.totalNum);
		
	}

}
