package com.lz.io.practice05;

import java.io.*;

/**
 * @ClassName SerializableDemo
 * @Description:
 * @Author: zzz
 **/
public class SerializableDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        String file = "user.txt";
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(file));
        User user =new User("1","xxx","123.a456");
        User user1 =new User("2","ZSDfW ET","1537FGHJ");
        User user2 =new User("3","!@#$%^%^","kj)*&%^(");
        User user3 =new User("4","xF1585    ","12!!~^^    ");
        out.writeObject(user);
        out.writeObject(user1);
        out.writeObject(user2);
        out.writeObject(user3);
        out.close();
        //----------------------------------------
        ObjectInputStream in = new ObjectInputStream(new FileInputStream(file));
        Object object = in.readObject();
        Object object1 = in.readObject();
        Object object2 = in.readObject();
        Object object3 = in.readObject();
        in.close();
        System.out.println(object);
        System.out.println(object1);
        System.out.println(object2);
        System.out.println(object3);
    }
}
