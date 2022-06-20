package com.yinsw.common.core.utils.bean;

import com.yinsw.common.core.exception.ServiceException;
import com.yinsw.common.core.utils.StringUtils;
import org.apache.poi.ss.formula.functions.T;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Bean 工具类
 *
 * @author yinsw
 */
public class BeanUtils extends org.springframework.beans.BeanUtils
{
    /**
     * 日志
     */
    private static final Logger log = LoggerFactory.getLogger(BeanUtils.class);
    /** Bean方法名中属性名开始的下标 */
    private static final int BEAN_METHOD_PROP_INDEX = 3;

    /** * 匹配getter方法的正则表达式 */
    private static final Pattern GET_PATTERN = Pattern.compile("get(\\p{javaUpperCase}\\w*)");

    /** * 匹配setter方法的正则表达式 */
    private static final Pattern SET_PATTERN = Pattern.compile("set(\\p{javaUpperCase}\\w*)");

    /**
     * set前缀
     */
    public static final String SET_PRE = "set";

    /**
     * get前缀
     */
    public static final String GET_PRE = "get";

    /**
     * 驼峰
     */
    private static Pattern humpPattern = Pattern.compile("[A-Z]");

    /**
     * 下划线
     */
    private static Pattern linePattern = Pattern.compile("_(\\w)");

    /**
     * 下划线转驼峰 create_time -> createTime
     */
    public static String lineToHump(String str) {
        str = str.toLowerCase();
        Matcher matcher = linePattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, matcher.group(1).toUpperCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 驼峰转下划线 createTime -> create_time
     */
    public static String humpToLine(String str) {
        Matcher matcher = humpPattern.matcher(str);
        StringBuffer sb = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(sb, "_" + matcher.group(0).toLowerCase());
        }
        matcher.appendTail(sb);
        return sb.toString();
    }

    /**
     * 首字母小写 SysUser -> sysUser
     *
     * @param name
     * @return
     */
    public static String captureName(String name) {
        name = name.substring(0, 1).toLowerCase() + name.substring(1);
        return name;
    }

    /**
     * 首字母大写 sysUser -> SysUser
     *
     * @param name
     * @return
     */
    public static String upperName(String name) {
        return name.substring(0, 1).toUpperCase() + name.substring(1);
    }

    /**
     * 获取get方法 name -> getName
     * @param name
     * @return
     */
    public static String getMethodName(String name){
        return GET_PRE + upperName(name);
    }

    /**
     * 获取set方法 name -> setName
     * @param name
     * @return
     */
    public static String setMethodName(String name){
        return SET_PRE + upperName(name);
    }

    /**
     * Bean属性复制工具方法。
     *
     * @param dest 目标对象
     * @param src 源对象
     */
    public static void copyBeanProp(Object dest, Object src)
    {
        try
        {
            copyProperties(src, dest);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    /**
     * 获取类的getter方法
     * @param clazz
     * @param name
     * @return
     */
    public static Method getGetterMethod(Class<?> clazz, String name){
        String methodName = getMethodName(name);
        try {
            Method method = clazz.getDeclaredMethod(methodName);
            return method;
        } catch (NoSuchMethodException e) {
            log.error("获取方法执行对象失败:类:[{}],方法名:[{}]",clazz.getName(),methodName,e);
            throw new RuntimeException(e);
        }
    }

    /**
     * 通过当前对象 进行强转
     * @param object 当前对象
     * @param clazz 强转类型
     * @param
     * @return <T> 返回类型
     */
    public static <T> T valueToT(Object object, Class<T> clazz) {
        try {
            if (!StringUtils.isEmpty(object)) {
                return (T) object;
            }
            return null;
        }catch (Exception e) {
            throw new ServiceException("程序类型转换异常Object -> "+clazz.getName());
        }
    }

    /**
     * 通过 类获取对应属性的值
     * @param clazz
     * @param name
     * @param obj
     * @return
     */
    public static Object getGetterMethodValue(Class<?> clazz, String name, Object obj){
        Method method = getGetterMethod(clazz, name);
        try {
            Object value = method.invoke(obj);
            if (value != null && value.toString() != "") {
                return value;
            }
        } catch (IllegalAccessException | InvocationTargetException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
    /**
     * 获取对象的setter方法。
     *
     * @param obj 对象
     * @return 对象的setter方法列表
     */
    public static List<Method> getSetterMethods(Object obj)
    {
        // setter方法列表
        List<Method> setterMethods = new ArrayList<Method>();

        // 获取所有方法
        Method[] methods = obj.getClass().getMethods();

        // 查找setter方法

        for (Method method : methods)
        {
            Matcher m = SET_PATTERN.matcher(method.getName());
            if (m.matches() && (method.getParameterTypes().length == 1))
            {
                setterMethods.add(method);
            }
        }
        // 返回setter方法列表
        return setterMethods;
    }

    /**
     * 获取对象的getter方法。
     *
     * @param obj 对象
     * @return 对象的getter方法列表
     */

    public static List<Method> getGetterMethods(Object obj)
    {
        // getter方法列表
        List<Method> getterMethods = new ArrayList<Method>();
        // 获取所有方法
        Method[] methods = obj.getClass().getMethods();
        // 查找getter方法
        for (Method method : methods)
        {
            Matcher m = GET_PATTERN.matcher(method.getName());
            if (m.matches() && (method.getParameterTypes().length == 0))
            {
                getterMethods.add(method);
            }
        }
        // 返回getter方法列表
        return getterMethods;
    }

    /**
     * 检查Bean方法名中的属性名是否相等。<br>
     * 如getName()和setName()属性名一样，getName()和setAge()属性名不一样。
     *
     * @param m1 方法名1
     * @param m2 方法名2
     * @return 属性名一样返回true，否则返回false
     */

    public static boolean isMethodPropEquals(String m1, String m2)
    {
        return m1.substring(BEAN_METHOD_PROP_INDEX).equals(m2.substring(BEAN_METHOD_PROP_INDEX));
    }
}
