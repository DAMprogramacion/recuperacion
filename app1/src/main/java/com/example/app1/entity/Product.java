package com.example.app1.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "products")
public class Product implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@Column(name = "nombre")
	private String name;
	
	@Column(name = "precio")
	private double prices;

	public Product(int id, String name, double prices) {
		this.id = id;
		this.name = name;
		this.prices = prices;
	}
	
	public Product(String name, double prices) {
		this.name = name;
		this.prices = prices;
	}

	public Product() {
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrices() {
		return prices;
	}

	public void setPrices(double prices) {
		this.prices = prices;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return String.format("%d,%s,%.2f", id, name, prices);
	}
	
	
	
	
}
