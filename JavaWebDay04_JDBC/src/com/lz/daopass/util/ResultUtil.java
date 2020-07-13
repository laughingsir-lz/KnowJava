package cn.lz.bank.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @ClassName ResultUtil
 * @Description:
 * @Author: zzz
 **/
public class ResultUtil {
    public static <T> T resultToBean(Map<String, Object> map, Class<T> clz) {
        T obj = null;
        try {
            obj = clz.newInstance();
            BeanInfo beanInfo = Introspector.getBeanInfo(clz, Object.class);
            PropertyDescriptor[] pds = beanInfo.getPropertyDescriptors();
            for (PropertyDescriptor pd : pds) {
                String name = pd.getName();
                Object value = map.get(name);
                pd.getWriteMethod().invoke(obj, value);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return obj;
    }
}
