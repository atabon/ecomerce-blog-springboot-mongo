package com.ti.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class EcommerceApi {

	@GetMapping
	public String welcome() {
		return "<center><strong> Ecommerce Spring data jpa api v1</strong></center>";
	}

	@RequestMapping("/*/**")
	public ResponseEntity<Object> notFoundUrl() {
		Map<String, String> response = new HashMap<String, String>();
		response.put("status", "404");
		response.put("error", "Not Found");
		return ResponseEntity.badRequest().body(response);
	}

	public static void main(String[] args) {
		SpringApplication.run(EcommerceApi.class, args);
	}
}
