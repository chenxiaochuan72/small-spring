package cn.it.xiaodongbei.springframework.util;

/**
 * @Author: cxc
 * @CreateTime: 2023-05-02  18:46
 * @Description: TODO
 * @Version: 1.0
 */
public class ClassUtils {
    public static ClassLoader getDefaultClassLoader(){
        ClassLoader cl=null;
        try {
            cl=Thread.currentThread().getContextClassLoader();
        } catch (Exception e) {
            // Cannot access thread context ClassLoader - falling back to system class loader...
        }
        if (cl==null){
            cl=ClassUtils.class.getClassLoader();
        }
        return cl;

    }
    /**
     * Check whether the specified class is a CGLIB-generated class.
     * @param clazz the class to check
     */
    public static boolean isCglibProxyClass(Class<?> clazz) {
        return (clazz != null && isCglibProxyClassName(clazz.getName()));
    }

    /**
     * Check whether the specified class name is a CGLIB-generated class.
     * @param className the class name to check
     */
    public static boolean isCglibProxyClassName(String className) {
        return (className != null && className.contains("$$"));
    }
}
