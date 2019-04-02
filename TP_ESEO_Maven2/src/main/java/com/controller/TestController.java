package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.dao.Requetes;
@RestController
public class TestController {
	
	public Requetes requetes;
	@RequestMapping (value="/test",method=RequestMethod.GET )
	@ResponseBody
	public String get(@RequestParam(required = false, value="value") String value) {
		this.requetes = new Requetes();
		return this.requetes.getVilles(value);
		//System.out.println("appel get");
		//System.out.println("value: "+value);
		//return value;
	}
}
