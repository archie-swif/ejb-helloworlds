package com.ryabokon.helloworld;

import javax.ejb.Stateless;

@Stateless
public class HelloBean {

	public String hello() {
		System.out.println("YARRRRR!");
		return "Hello bean!";
	}

}
