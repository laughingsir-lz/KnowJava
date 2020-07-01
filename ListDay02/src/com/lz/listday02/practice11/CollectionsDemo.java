package com.lz.listday02.practice11;

import java.util.*;

/**
 * @ClassName CollectionsDemo
 * @Description: Collections工具类中的常用方法 斗地主案例
 * @Author: zzz
 **/
public class CollectionsDemo {
    public static void main(String[] args) {
        //花色集合
        List<String> colors = new ArrayList<>();
        colors.add("♠");
        colors.add("♥");
        colors.add("♦");
        colors.add("♧");
        //数字集合 3,4,5,6,7,8,9,10,J,Q,K,A,2
        List<String> numbers = new ArrayList<>();
        //将元素添加到指定的集合numbers中  13张牌
        Collections.addAll(numbers,"3","4","5","6","7","8","9","10","J","Q","K","A","2");
        //集合本身的add方法，把指定集合中的元素添加到当前集合
        //26张牌
        numbers.addAll(numbers);
        //52张牌
        numbers.addAll(numbers);
        //用map 记录每张牌
        Map<Integer,String> map = new HashMap<>(54);
        //牌的顺序记录器
        Integer squence = 0;
        for (String number : numbers) {
            for (String  color : colors) {
                if (squence<=51){
                    map.put(squence,"["+color+number+"]");
                    squence++;
                }
            }
        }
        //单独添加大小王
        map.put(squence,"小♕");
        squence++;
        map.put(squence,"大♕");
        //将牌记录下来
        List<Integer> cards = new ArrayList<>(map.keySet());
        //洗牌
        Collections.shuffle(cards);
        System.out.println(cards);

        //三个玩家的牌 和 底牌
        List<Integer> player1 = new ArrayList<>();
        List<Integer> player2 = new ArrayList<>();
        List<Integer> player3 = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        //发牌
        for (int i = 0; i <cards.size() ; i++) {
            if (i<51){
                //用求余数 来为3个玩家发牌
                int mod = i % 3;
                int card = cards.get(i);
                if (mod ==2){
                    player2.add(card);
                }
                else if (mod ==1){
                    player1.add(card);
                }
                else {
                    player3.add(card);
                }
            }
            //剩下的底牌
            else {
                end.add(cards.get(i));
            }
        }
        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(end);
        //将牌进行排序
        Collections.sort(player1);
        Collections.sort(player2);
        Collections.sort(player3);
        Collections.sort(end);

        System.out.println(player1);
        System.out.println(player2);
        System.out.println(player3);
        System.out.println(end);

        //根据牌的记号拿到各自玩家的牌
        List<String> player1Cards = new ArrayList<>();
        List<String> player2Cards = new ArrayList<>();
        List<String> player3Cards = new ArrayList<>();
        List<String> endCards = new ArrayList<>();
        for (Integer key : player1) {
            player1Cards.add(map.get(key));
        }
        for (Integer key : player2) {
            player2Cards.add(map.get(key));
        }
        for (Integer key : player3) {
            player3Cards.add(map.get(key));
        }
        for (Integer key : end) {
            endCards.add(map.get(key));
        }
        //看牌
        System.out.println("玩家1："+(player1Cards));
        System.out.println("玩家2："+player2Cards);
        System.out.println("玩家3："+player3Cards);
        System.out.println("底牌 ："+endCards);

    }
}
