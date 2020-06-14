package com.lz.practice_02;


/**
 * 枪 类
 */
public class Gun {
    int[] clip = new int[5]; //弹夹
    /**
     * 装子弹方法
     */
    public void push() {
        for (int i = 0; i < clip.length; i++) {
            if (clip[i] == 0) {
                clip[i] = 1;
                System.out.println("装填第" + i + "发子弹");
            }
            if (clip[clip.length - 1] == 1) {
                System.out.println("弹夹已满，请还击！");
            }
        }
    }

    /**
     * 打出子弹方法
     */
    public void pop() {
        for (int i = 0; i < clip.length; i++) {
            if (clip[i] == 1) {
                clip[i] = 0;
                System.out.println("击发第" + i + "发子弹");
            }
            if (clip[clip.length - 1] == 0) {
                System.out.println("弹夹已空，请装弹！");
            }
        }
    }
}
