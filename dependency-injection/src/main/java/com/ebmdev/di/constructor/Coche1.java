package com.ebmdev.di.constructor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Coche1 {

	private String marca;
	private Integer modelo;
	private Motor1 motor;

	public Coche1() {
	}

	@Autowired
	public Coche1(@Value("VW") String marca, @Value("1981") Integer modelo, Motor1 motor) {
		this.marca = marca;
		this.modelo = modelo;
		this.motor = motor;
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

	public Motor1 getMotor() {
		return motor;
	}

	public void setMotor(Motor1 motor) {
		this.motor = motor;
	}

	@Override
	public String toString() {
		return "Coche1 [marca=" + marca + ", modelo=" + modelo + ", motor=" + motor + "]";
	}

}
