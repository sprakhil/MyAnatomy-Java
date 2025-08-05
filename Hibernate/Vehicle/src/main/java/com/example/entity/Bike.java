package com.example.entity;

import jakarta.persistence.Entity;

@Entity
public class Bike extends Vehicle {
	private boolean hasCarrier;

	public boolean isHasCarrier() {
		return hasCarrier;
	}

	public void setHasCarrier(boolean hasCarrier) {
		this.hasCarrier = hasCarrier;
	}
	
}
