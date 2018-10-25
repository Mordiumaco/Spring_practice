package myspring.di.xml.test;
import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

public class HelloBeanJunitTest {
	ApplicationContext context;
	
	@Before
	public void init(){
		//IOC 컨테이너 생성
		//1.ApplicationContext 객체 설정
		context = new GenericXmlApplicationContext("config/beans.xml");
	}
	
	
	@Test @Ignore
	public void javaBeanTest() {
		
		
		//2. Hello Bean 가져오기
		Hello hello = (Hello)context.getBean("hello");
		assertEquals("Hello Spring", hello.sayHello());
		hello.print(); //Hello Spring
		
		//3. StringPrinter Bean 가져오기 
		Printer printer = (Printer)context.getBean("printer");
		System.out.println(printer.toString()); //Hello Spring
		assertEquals("Hello Spring", printer.toString());
		
		
		Hello hello2 = context.getBean("hello", Hello.class);
		hello2.print(); //Hello Spring
		 
		//Spring 컨테이너는 객체를 싱글톤 형태로 만들어 주기 때문에 객체를 한개만 생성하는 싱글톤 형태라는 걸 알 수 있다.
		System.out.println(hello == hello2);
		
	}
	
	
	@Test @Ignore
	public void javaBeanTest2() {
		
		//2.getBean() 호출
		Hello hello = (Hello)context.getBean("hello");
		Hello hello2 = context.getBean("hello", Hello.class);
		
		assertSame(hello, hello2);
		
	}
	
	
	
}
