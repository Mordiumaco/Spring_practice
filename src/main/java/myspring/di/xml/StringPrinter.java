package myspring.di.xml;

import org.springframework.stereotype.Component;


public class StringPrinter implements Printer {
	
	private StringBuffer buffer = new StringBuffer();
	

	@Override
	public void print(String message) {
		buffer.append(message);
	}
	
	@Override
	public String toString(){
		return buffer.toString();
	}
	
	 
}
