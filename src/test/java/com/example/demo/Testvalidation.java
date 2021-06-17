package com.example.demo;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class Testvalidation {

	Validation v;
	@BeforeEach
	void initialize()
	{
		v=new Validation();
	}
	@Test
	void verifStringValues()
	{
		assertTrue(v.detectString("oumayma"));
		
	}
	@Test
	void verifUrl()
	{
		assertTrue(v.detecturl("http:www/github.com"));
	}
	
	
}
