package com.spring.junit;

import com.spring.anno.Bean;
import com.spring.anno.Di;

import java.io.File;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.net.URL;
import java.net.URLDecoder;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * ClassName:AnnotationApplicationContext
 * Description:
 *
 * @Author Sixty-three
 * @Create 2024/2/25 22:39
 * @Version 1.0
 */
public class AnnotationApplicationContext implements ApplicationContext {

    // 创建map集合，放bean对象
    private Map<Class, Object> beanFactory = new HashMap<>();
    private String rootPath;

    // 返回对象
    @Override
    public Object getBean(Class clazz) {
        return beanFactory.get(clazz);
    }

    // 创建有参数构造，传递包路径，设置包扫描规则
    // 当前包及其子包，哪个类有@Bean注解，把这个类通过反射实例化
    public AnnotationApplicationContext(String basePackage) {
        // com.spring

        try {
            // 1 把.替换成\
            String packagePath = basePackage.replaceAll("\\.", "\\\\");
            // 2 获取包绝对路径
            Enumeration<URL> urls = Thread.currentThread().getContextClassLoader().getResources(packagePath);
            while (urls.hasMoreElements()){
                URL url = urls.nextElement();
                String filePath = URLDecoder.decode(url.getFile(), "utf-8");

                // 获取包前面路径部分，字符串截取
                rootPath = filePath.substring(0,filePath.length()-packagePath.length());
                //包扫描
                loadBean(new File(filePath));
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        // 属性注入
        loadDi();

    }
    // 包扫描过程，用于进行实例化
    public void loadBean(File file) throws Exception {
        // 1 判断当前路径是否是文件夹
        if(file.isDirectory()){
            // 2 获取文件夹所有内容
            File[] childrenFiles = file.listFiles();
            // 3 判断文件夹里面为空，直接返回
            if(childrenFiles == null || childrenFiles.length == 0){
                return;
            }
            // 4 如果文件夹里面不为空，遍历文件夹所有内容
            for (File childFile : childrenFiles) {
                // 4.1 遍历得到每个File对象，继续判断，如果还是文件夹，递归
                loadBean(childFile);
            }
        }
        // 4.2 遍历得到File对象不是文件夹，是文件，
        // 4.3 得到包路径+类名称部分-字符串截取
        String pathWithClass = file.getAbsolutePath().substring(rootPath.length() - 1);
        // 4.4 判断当前文件类型是否.class
        if(pathWithClass.contains(".class")){
            // 4.5 如果是.class类型，把路径\替换成. 把.class去掉
            String allName = pathWithClass.replaceAll("\\\\", ".").replace(".class", "");
            // 4.6 判断类上面是否有注解@Bean,如果有实例化过程
            // 4.6.1 获取类的class
            Class<?> clazz = Class.forName(allName);
            // 4.6.2 判断不是接口
            if(!clazz.isInterface()){
                // 4.6.3 判断类上面是否有注解@Bean
                Bean annotation = clazz.getAnnotation(Bean.class);
                if(annotation != null){
                    // 4.6.4 实例化
                    Object ins = clazz.getConstructor().newInstance();
                    // 4.7 把对象实例化之后，放到map集合beanFactory
                    // 4.7.1 判断当前类有接口，让接口class作为map的key
                    if(clazz.getInterfaces().length>0){
                        beanFactory.put(clazz.getInterfaces()[0],ins);
                    }else{
                        beanFactory.put(clazz,ins);
                    }
                }
            }
        }
    }

    // 属性注入
    private void loadDi() {
        // 实例化对象在beanFactory的map集合里面
        //1 遍历beanFactory 的map集合
        for (Map.Entry<Class, Object> classObjectEntry : beanFactory.entrySet()) {
            //2 获取map集合每个对象（value）,每个对象属性获取到
            Object obj = classObjectEntry.getValue();
            //3 遍历得到每个对象属性数组，得到每个属性
            Class<?> clazz = obj.getClass();
            Field[] fields = clazz.getDeclaredFields();
            for (Field field : fields) {
                //4 判断属性上面是否有@Di注解
                Annotation annotation = field.getAnnotation(Di.class);
                //5 如果有@Di注解，把时象进行设置（注入）
                if(annotation != null){
                    field.setAccessible(true);
                    try {
                        field.set(obj,beanFactory.get(field.getType()));
                    } catch (IllegalAccessException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }
    }}
