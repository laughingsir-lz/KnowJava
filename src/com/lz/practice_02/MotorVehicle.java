package com.lz.practice_02;
/**
 * 机动车类
 */
public class MotorVehicle {
    private String number_plate; //车牌号
    private int speed;//速度
    private double weight;//载重
    /**
     * 无参构造器
     */
   public  MotorVehicle(){
        this.number_plate = "XX1234";
        this.speed = 100;
        this.weight = 100.0;
    }
    /**
     * 有参构造器
     * @param number_plate
     * @param speed
     * @param weight
     */
   public MotorVehicle(String number_plate,int speed,double weight){
       this.number_plate = number_plate;
       this.speed = speed;
       this.weight = weight;
   }

    /**
     * 加速
     */
    public void addSpeed() {
        this.speed++;
    }

    /**
     * 减速
     */
    public void lessSpeed() {
       this.speed--;
    }

    /**
     * 修改车牌号
     * @param number_plate
     */
    public void updateNum(String number_plate) {
        this.number_plate = number_plate;
    }

    /**
     * 返回当前载重
     * @return
     */
    public double findWeight() {
        return  this.weight;
    }

    public String getNumber_plate() {
        return number_plate;
    }

    public void setNumber_plate(String number_plate) {
        this.number_plate = number_plate;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "机动车信息{" +
                "车牌号='" + number_plate + '\'' +
                ", 车速=" + speed +
                ", 载重=" + weight +
                '}';
    }
}
