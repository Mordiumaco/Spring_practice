package myspring.di.xml.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanTest {
	public static void main(String[] args) {
		
		//1. IOC 컨테이너 생성
		ApplicationContext context = new GenericXmlApplicationContext("config/beans.xml");
		
		//2. Hello Bean 가져오기
		Hello hello = (Hello)context.getBean("hello");
		System.out.println(hello.sayHello());  
		hello.print(); //Hello Spring
		
		//3. StringPrinter Bean 가져오기 
		Printer printer = (Printer)context.getBean("printer");
		System.out.println(printer.toString()); //Hello Spring
		
		Hello hello2 = context.getBean("hello", Hello.class);
		hello2.print(); //Hello Spring
		 
		//Spring 컨테이너는 객체를 싱글톤 형태로 만들어 주기 때문에 객체를 한개만 생성하는 싱글톤 형태라는 걸 알 수 있다.
		System.out.println(hello == hello2);
		  
		
	}
}
