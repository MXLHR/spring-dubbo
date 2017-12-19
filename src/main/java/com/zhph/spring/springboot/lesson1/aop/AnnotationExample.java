package com.zhph.spring.springboot.lesson1.aop;

import java.util.ArrayList;
import java.util.List;

public class AnnotationExample {
	
	public static void main(String[] args) {
		
	}
	
	@Override
	@MethodInfo(comments = "重写方法", date = "2017年12月19日22:13:25")
	public String toString() {
		return "覆盖的toString()方法";
	}
	
	public static void oldMethod(){
		System.out.println("old method ");
	}
	@SuppressWarnings({"unchecked","deprecation" })
	@MethodInfo(author = "Pankaj", comments = "Main method", date = "Nov 17 2012", revsion = 10)
	public static void genericsTest() {
		
		List list = new ArrayList();
		list.add("abc");
		oldMethod();
	}

}
