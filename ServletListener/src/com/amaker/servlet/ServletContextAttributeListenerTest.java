package com.amaker.servlet;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;

public class ServletContextAttributeListenerTest implements ServletContextAttributeListener{

	public void attributeAdded(ServletContextAttributeEvent arg0) {
		
		System.out.println("attributeAdded ..........");
	}

	public void attributeRemoved(ServletContextAttributeEvent arg0) {
		
		System.out.println("attributeRemoved ...............");
	}

	public void attributeReplaced(ServletContextAttributeEvent arg0) {
		
		System.out.println(" attributeReplaced .............");
	}

}
