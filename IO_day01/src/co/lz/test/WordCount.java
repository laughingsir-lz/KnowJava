package co.lz.test;

import javax.xml.transform.Result;
import java.io.*;

/**
 * @ClassName WordCount
 * @Description:
 * @Author: zzz
 **/
public class WordCount {
    public static void main(String[] args) throws IOException {
        //创建目标源文件
        File file = new File("D:\\ABA\\wolfCode\\IO_day01\\src\\co\\lz\\test\\article.txt");
        //创建 输入流对象
        FileReader reader = new FileReader(file);
        StringBuilder stringBuilder = new StringBuilder();
        //循环读
        int count= reader.read();
        while (count!=-1){
            stringBuilder.append((char)count);
            count = reader.read();
        }
        reader.close();
        //创建输出流
        FileWriter writer= new FileWriter("D:\\ABA\\wolfCode\\IO_day01\\src\\co\\lz\\test\\result.txt");
        writer.write(stringBuilder.toString());
        writer.close();
        System.out.println(stringBuilder.length());
    }
}
