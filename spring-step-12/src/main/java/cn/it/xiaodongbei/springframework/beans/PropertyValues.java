package cn.it.xiaodongbei.springframework.beans;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-02  15:32
 * @Description: 属性集合
 * @Version: 1.0
 */
public class PropertyValues {
    private final List<PropertyValue>  propertyValueList=new ArrayList<>();

    public void addPropertyValue(PropertyValue pv){
        this.propertyValueList.add(pv);
    }
    public PropertyValue[] getPropertyValues(){
        return this.propertyValueList.toArray(new PropertyValue[0]);
    }

    public PropertyValue getPropertyValue(String propertyName){
        for (PropertyValue pv : propertyValueList) {
            if (pv.getName().equals(propertyName)){
                    return pv;
            }
        }
        return null;
    }
}
