package com.krushna.SpringBeanCompmentConfiguration;

import org.springframework.stereotype.Component;


public class MyComponent {
	
	public MyComponent() {
		System.out.println("Message from my component");
	}
	
	public void getMessage() {
		System.out.println("Message from get meassage");
	}

}
