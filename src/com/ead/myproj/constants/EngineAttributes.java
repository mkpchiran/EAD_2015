package com.ead.myproj.constants;

public class EngineAttributes {

	public enum Manufacture {
		Acura, Audi, BMW, Buick, Cadillac, Chevrolet, Chrysler, Dodge, Eagle, Ferrari, Ford, GMC, Honda, Hummer, Hyundai, Infiniti, Isuzu, Jaguar, Jeep, Kia;
	}

	public enum Capacity {
		HP10, HP20, HP30, HP40, HP50;
	}

	public enum Fuletype {
		PETROL, DIESEL;
	}

	public enum Cylenders {
		ONE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT;
	}

	public enum MountingType {
		TYPE1, TYPE2;
	}
	
	public static final String[] status= {"Not Available","Available","Out of stock"};
}
