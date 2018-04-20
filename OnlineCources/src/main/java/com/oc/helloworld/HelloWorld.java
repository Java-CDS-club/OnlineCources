package com.oc.helloworld;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.oc.OCUility;

@RestController
public class HelloWorld {
	@Autowired
	OCUility ocu;
	
	@GetMapping("/hello-world")
	public String getHello() {
		return "Hello World";
	}
	
	@GetMapping("/hello-world-bean")
	public MessageBean getHelloWorldBean() {
		return new MessageBean("Hello World");
	}
	
	@GetMapping("/hello-world-bean/{name}")
	public MessageBean getHelloWorldBeanPath(@PathVariable String name) {
		return new MessageBean(String.format("Hello World, %s", name));
	}
	
	@GetMapping("/hello-world-bean-i18n")
	public MessageBean getHelloWorldBeanPath() {
		return new MessageBean(ocu.getMessage("oc.hello", null));
	}
}
