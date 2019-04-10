package com.shop.base;

import freemarker.core.Environment;
import freemarker.ext.beans.BeansWrapper;
import freemarker.ext.beans.BeansWrapperBuilder;
import freemarker.template.*;
import freemarker.template.utility.DeepUnwrap;

import java.util.Map;

public abstract class BaseDirective implements TemplateDirectiveModel {

    /**
     * 获取参数值
     *
     * @param params
     * @param paramName
     * @return
     * @throws TemplateModelException
     */
    protected Object getParameter(Map params, String paramName) throws TemplateModelException {
        TemplateModel model = (TemplateModel) params.get(paramName);
        Object position = DeepUnwrap.unwrap(model);
        return position;
    }


    /**
     *把数据进行输出
     * @param env
     * @param body
     * @param name
     * @param value
     * @throws Exception
     */
    protected void setVariable(Environment env, TemplateDirectiveBody body,
                               String name, Object value) throws Exception{
        // 构建一个TemplateModel
        BeansWrapper wrapper = new BeansWrapperBuilder(Configuration.VERSION_2_3_25).build();
        TemplateModel templateModel = wrapper.wrap(value);
        // 设置输出的内容
        env.setVariable(name, templateModel);
        // 输出
        body.render(env.getOut());
    }
}
