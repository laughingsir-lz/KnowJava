package com.lz.generalpractice.practice_2;

/**
 * 打印接口实现类
 */
public class PrintImpl implements ILowercaseLetter, IUppercaseLetter {
    private String str = "t 65";
    private String string = "THis is LOWer";

    /**
     * 字母小写打印方法具体实现
     */
    @Override
    public void printLowercaseLetter() {
        char[] ch = string.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] > 64 && ch[i] < 91) {
                ch[i] = (char) (ch[i] + 32);
            }
            sb.append(ch[i]);
        }
        System.out.println(sb);
    }

    /**
     * 字母大写打印方法具体实现
     */
    @Override
    public void printUppercaseLetter() {
        char[] ch = str.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] > 96 && ch[i] < 123) {
                ch[i] = (char) (ch[i] - 32);
            }
            sb.append(ch[i]);
        }
        System.out.println(sb);
    }
}
