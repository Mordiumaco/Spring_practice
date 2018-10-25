package myspring.di.xml.test;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import myspring.di.xml.Hello;
import myspring.di.xml.Printer;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:config/beans.xml")
public class HelloBeanJunitSpringTest {
	
	@Autowired
	ApplicationContext context;
	
	
	@Test
	public void javaBeanTest() {
		
		
		//2. Hello Bean 가져오기
		Hello hello = (Hello)context.getBean("hello3");
		assertEquals("Hello Spring", hello.sayHello());
		hello.print(); //Hello Spring
		
		//3. StringPrinter Bean 가져오기 
		Printer printer = (Printer)context.getBean("printer");
		System.out.println(printer.toString()); //Hello Spring
		assertEquals("Hello Spring", printer.toString());
		
		
		Hello hello2 = context.getBean("hello3", Hello.class);
		hello2.print(); //Hello Spring
		 
		//Spring 컨테이너는 객체를 싱글톤 형태로 만들어 주기 때문에 객체를 한개만 생성하는 싱글톤 형태라는 걸 알 수 있다.
		System.out.println(hello == hello2);
		
		assertEquals(3, hello.getNames().size());
		List<String> list = hello.getNames();
		
		
		for(String value: list){
			System.out.println(value);
		}
		
	}
	
	
	@Test @Ignore
	public void javaBeanTest2() {
		
		//2.getBean() 호출
		Hello hello = (Hello)context.getBean("hello");
		Hello hello2 = context.getBean("hello", Hello.class);
		
		assertSame(hello, hello2);
		
	}
	
	
	
}
