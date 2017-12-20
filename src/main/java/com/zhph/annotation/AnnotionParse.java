package com.zhph.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotionParse {
	
	public static void main(String[] args) {
		
		try {
			for(Method method : AnnotionParse.class.getClassLoader()
					.loadClass("com.zhph.spring.springboot.lesson1.aop.AnnotationExample").getMethods()){
				//checks if MethodInfo annotation is present for method 
				if(method.isAnnotationPresent(MethodInfo.class)){
					for(Annotation anno : method.getDeclaredAnnotations()){
						System.out.println(" Annotion in Method ["+ method +"] :" + anno );
					}
					MethodInfo methodAnno = method.getAnnotation(MethodInfo.class);
					if(methodAnno.revsion() == 1){
						System.out.println("获取注解上版本为1的方法 ：" + method.getName() +" :" +method);
					}
				}
				
			}
		} catch (SecurityException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
