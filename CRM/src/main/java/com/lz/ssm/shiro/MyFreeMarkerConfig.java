package com.lz.ssm.shiro;

import com.jagregory.shiro.freemarker.ShiroTags;
import freemarker.template.Configuration;
import freemarker.template.TemplateException;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;

import java.io.IOException;

/**
 * @author zzz
 * @date 2020/8/27  10:38
 */
public class MyFreeMarkerConfig extends FreeMarkerConfigurer {
    @Override
    public void afterPropertiesSet() throws IOException, TemplateException {
        //继承之前的属性配置，这不不能省
        super.afterPropertiesSet();
        Configuration cfg = this.getConfiguration();
        //注册shiro 标签
        cfg.setSharedVariable("shiro", new ShiroTags());
    }
}
