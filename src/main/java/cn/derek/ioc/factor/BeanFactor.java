package cn.derek.ioc.factor;

import cn.derek.entity.News;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BeanFactor {

    private Map<String,Object> beans;

    public BeanFactor() throws Exception {
        beans=new HashMap<>();
        initBeans();
    }

    void initBeans() throws Exception {
        SAXReader saxReader=new SAXReader();
        Document document=saxReader.read("src/main/resources/app.xml");
        Element element=document.getRootElement();
        List<Element> elements=element.elements();
        for(Element ele:elements){
            if("bean".equals(ele.getName())){
                String id=ele.attributeValue("id");
                String className=ele.attributeValue("class");
                Object object= Class.forName(className).newInstance();
                beans.put(id,object);
            }
        }
    }



    public <T>T getBean(String id) {
        return (T)this.beans.get(id);
    }
}
