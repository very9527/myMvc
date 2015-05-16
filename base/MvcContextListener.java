package myMvc.base;

import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import myMvc.controller.TestController;

/**
 * 先将Controller里的url和method以key-value(Map)的形式映射起来。
 * @author zhangzhiyun
 *
 */
public class MvcContextListener {
	
	public static void main(String[] args){
		//扫描指定类，或者指定包，这里先不做。
		Class<?> clazz = TestController.class;
		
		Method[] methods = clazz.getDeclaredMethods(); // 获取类里面的方法
		for (Method controllerMethod : methods) {
			RequestMapping requestMapping = null;
			if(controllerMethod.isAnnotationPresent(RequestMapping.class)) {
				requestMapping = controllerMethod.getAnnotation(RequestMapping.class); // 取得此method的@注解实例
			} else {
				System.out.println("获取RequestMapping注解出错");
			}
			String requestMappingUrl = requestMapping.value();
			
			Map<String, Method> map = new HashMap<String, Method>();
			map.put(requestMappingUrl, controllerMethod);
		}
	}
}
