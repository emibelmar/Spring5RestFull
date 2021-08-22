package com.ebmdev.di.autowire;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculadoraAreaService {

	@Autowired
	private List<Figura> figuras;

	public double calcAreas() {
		double area = 0;
		for (Figura figura : figuras) {
			area += figura.calculateArea();
		}
		return area;
	}
}
