package myspring.di.xml.annotation;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Controller
public class Hello {
	
	@Value("${myname}")
	private String name;
	
	//-- properties를 이용한 값을 받을 경우에는
	//Autowired와 Qualifier를 쓰지 못한다.
	//@Autowired
	//@Qualifier("stringPrinter")
	
	@Resource(name="${printer1}")
	private Printer printer;
	
	private List<String> names;
	
	
	public List<String> getNames() {
		return names;
	}

	public void setNames(List<String> names) {
		this.names = names;
	}

	public Hello(){};
	
	public Hello(String name, Printer printer) {
		this.name = name;
		this.printer = printer;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Printer getPrinter() {
		return printer;
	}
	public void setPrinter(Printer printer) {
		this.printer = printer;
	}
	
	public String sayHello(){
		return "Hello " + name;
	}
	
	public void print(){
		this.printer.print(sayHello());
	}
	
}

