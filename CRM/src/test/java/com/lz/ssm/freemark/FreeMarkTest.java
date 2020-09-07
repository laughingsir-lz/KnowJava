package com.lz.ssm.freemark;

import freemarker.template.Configuration;
import freemarker.template.Template;


import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.Map;

public class FreeMarkTest {
    public static void main(String[] args) throws Exception {
        Configuration cfg = new Configuration(Configuration.VERSION_2_3_23);
        // 指定模板文件从何处加载的数据源，这里设置文件目录位置。
        cfg.setDirectoryForTemplateLoading(new File("templates"));
        // 设置默认编码类型
        cfg.setDefaultEncoding("utf-8");
        // 提供数据
        Map root = new HashMap();
        root.put("user", "Big Joe");
        // 获取模板文件
        Template temp = cfg.getTemplate("test.ftl");
        // 设置输出为新的文件
        Writer out = new OutputStreamWriter(new FileOutputStream("test.html"));
        // 执行输出
        temp.process(root, out);
        out.flush();
        out.close();
    }
}
