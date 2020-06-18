package com.lz.practice_05;

/**
 * 自定义异常LogicException
 * 使用自定义异常模仿用户注册（register）功能
 */
public class RegisterDemo {
    public static boolean isExist(User user) throws Exception {
        String[] data = {"will", "lucy", "xxx"};
        if (user.name != null && user.name.length() > 0) {
            for (String string : data) {
                if (string.equals(user.name)) {
                    //抛出具体的异常对象
                    throw new LogicException("对不起，用户名：" + user.name + "已注册！");
                }
            }
        }
        return false;
    }
    public static void main(String[] args) {
        User user = new User("xxx");
        try {
            isExist(user);
        } catch (Exception e) {
            if (e instanceof LogicException){
                LogicException logicException = (LogicException)e;
                System.out.println(logicException);
            }
        }
    }
}
