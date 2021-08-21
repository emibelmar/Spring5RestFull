package com.ebmdev.di.qualifiers;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Perro extends Animal {

	public Perro(@Value("Rocky") String nombre, @Value("1") Integer edad) {
		super(nombre, edad);
	}

}
