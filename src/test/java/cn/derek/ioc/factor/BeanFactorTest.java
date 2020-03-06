package cn.derek.ioc.factor;

import cn.derek.entity.News;
import org.junit.Assert;
import org.junit.Test;

public class BeanFactorTest {

    @Test
    public void shouldGetBean() throws Exception {
        BeanFactor beanFactor=new BeanFactor();
        News news= beanFactor.getBean("news");
        String className=news.getClass().getName();
        String result="cn.derek.entity.News";
        Assert.assertEquals(className,result);
    }
}
