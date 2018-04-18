package com.oc.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

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
}
