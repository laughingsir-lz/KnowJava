package com.lz.practice_03;

/**
 * 商品类
 */
public class Item {
    private String name;
    private double price;
    public Item(){
    }
    public Item(String n,double p){
        this.name = n;
        this.price = p;
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

    @Override
    public String toString() {
        return "商品[" +
                "名称=" + name  +
                ",  价格=" + price +
                ']';
    }
}
