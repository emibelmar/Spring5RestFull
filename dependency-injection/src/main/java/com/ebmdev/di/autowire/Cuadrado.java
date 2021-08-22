package com.ebmdev.di.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Cuadrado implements Figura {

	@Value("${cuadrado.lado}")
	private double lado;

	@Override
	public double calculateArea() {
		return lado * lado;
	}

}
