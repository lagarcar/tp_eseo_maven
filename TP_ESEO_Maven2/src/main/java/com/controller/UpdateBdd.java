package com.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.blo.Ville;
import com.dao.Requetes;
@RestController
public class UpdateBdd {
	public Requetes requetes;

	@RequestMapping (value="/put",method=RequestMethod.PUT )
	@ResponseBody
	public void put(@RequestParam(required = false, value="value") String value,
			@RequestParam(required = false, value="value2") String value2,
			@RequestParam(required = false, value="value3") String value3,
			@RequestParam(required = false, value="value4") String value4,
			@RequestParam(required = false, value="value5") String value5,
			@RequestParam(required = false, value="value6") String value6,
			@RequestParam(required = false, value="value7") String value7
			) {

		this.requetes = new Requetes();
		this.requetes.putVilles(value, value2, value3, value4, value5, value6, value7);
}
}
