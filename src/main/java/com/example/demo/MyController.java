package com.example.demo;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {

	private final MyService myService;
	private final MyComponent myComponent;
	
	public MyController(MyService myService, MyComponent myComponent) {
		this.myService = myService;
		this.myComponent = myComponent;
	}
	
	@GetMapping("/invoke")
	public ResponseEntity<String> invokeService() {
		String serviceResult = myService.doSomething();
		String appName = myComponent.getAppName();
		return ResponseEntity.ok(appName + " " +serviceResult);
	}
}
