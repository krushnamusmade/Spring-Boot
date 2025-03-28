package com.krushna.SpringBeanCompmentConfiguration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MyApp {
	
	@Autowired
	private MyComponent myComponent;
	
//	public MyApp(MyComponent myComponent) {
//		// TODO Auto-generated constructor stub
//		this.myComponent = myComponent;
//	}
	
	public void run() {
		myComponent.getMessage();
	}

}
