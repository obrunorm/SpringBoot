package br.com.generation.hello31.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class ObjetivosController {
	
	@GetMapping
	public String hello() {
		return "Os objetivos da semana serão aprender sobre o sping boot, revisar banco de dados e o java";
	}
}

