package com.ebmdev.di.constructor;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Motor1 {

	private String marca;
	private Integer modelo;

	public Motor1(@Value("Xl1") String marca, @Value("1982") Integer modelo) {
		this.marca = marca;
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public Integer getModelo() {
		return modelo;
	}

	public void setModelo(Integer modelo) {
		this.modelo = modelo;
	}

	@Override
	public String toString() {
		return "Motor1 [marca=" + marca + ", modelo=" + modelo + "]";
	}

}
