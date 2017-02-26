package com.example.webservice.auth;

import javax.ejb.Stateless;
import javax.jws.HandlerChain;
import javax.jws.WebService;

@WebService
@Stateless
@HandlerChain(file="handler.xml")
public class TestWebservice{

	public String foo(){
		return "Hello World";
	}

}

