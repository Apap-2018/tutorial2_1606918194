package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class PageController {
	@RequestMapping("/viral")
	public String index() {
		return "viral";
	}
	
	@RequestMapping("/challenge")
	public String challenge(@RequestParam(value = "name", required = false) String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping("/challenge/{name}")
	public String challengePath(@PathVariable String name, Model model) {
		model.addAttribute("name",name);
		return "challenge";
	}
	
	@RequestMapping("/generator")
	public String generator(@RequestParam(value = "a", required = false, defaultValue = "0") int a, @RequestParam(value = "b", required = false, defaultValue = "0") int b, Model model) {
		
		String result = "hm";
		
		model.addAttribute("a", a);
		model.addAttribute("b", b);
		
		for (int i = 1; i < a; i++) {
			result += "m";
		}
		
		String temp = "";
		for (int i = 0 ; i < b ; i++) {
			temp += result + " ";
			
			result = temp;
		}
		
		model.addAttribute("result", result);
		return "generator";
	}
}