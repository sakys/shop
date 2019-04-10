package com.shop.directive;

import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import freemarker.template.utility.DeepUnwrap;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Component
public class HelloDirective implements TemplateDirectiveModel {

    @Override
    public void execute(Environment environment, Map params, TemplateModel[] templateModels, TemplateDirectiveBody body) throws TemplateException, IOException {

        System.out.println("传入参数：" + params);
        TemplateModel model = (TemplateModel) params.get("content");
        String content = (String)DeepUnwrap.unwrap(model);
        System.out.println("传入参数：" + content);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("name","monkey");
        map.putAll(params);

        // 构建一个TemplateModel
        BeansWrapper wrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_25).build();
        TemplateModel templateModel = wrapper.wrap(map);

        // 设置输出的内容
        environment.setVariable("helloworld",templateModel);

        // 输出
        body.render(environment.getOut());
    }
}
