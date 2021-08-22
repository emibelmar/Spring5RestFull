package com.ebmdev.di.autowire;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circulo implements Figura {

	@Value("${circulo.radio}")
	private double radio;

	@Override
	public double calculateArea() {
		return Math.PI * Math.pow(radio, 2);
	}

}
