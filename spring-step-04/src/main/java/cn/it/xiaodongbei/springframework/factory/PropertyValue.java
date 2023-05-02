package cn.it.xiaodongbei.springframework.factory;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-02  15:31
 * @Description: PropertyValue(属性值)、
 * @Version: 1.0
 */
public class PropertyValue {
    private final String name;
    private final Object value;

    public PropertyValue(String name, Object value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Object getValue() {
        return value;
    }

}
