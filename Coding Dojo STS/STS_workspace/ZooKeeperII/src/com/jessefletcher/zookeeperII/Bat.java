package com.jessefletcher.zookeeperII;
public class Bat extends Mammal{
	//MEMBER VARIABLES
	
	
	//CONSTRUCTORS
	public Bat() {
		super();
	}
	
	public Bat(int energyLevel) {
		super(energyLevel);
	}
	
	//GETTERS / SETTERS / METHODS
	public void fly() {
		System.out.println("WOOSH!");
		this.energyLevel -= 50;
		
	}
	
	public void eatHumans() {
		System.out.println("NOM NOM NOM");
		this.energyLevel += 25;
	}
	
	public void attackTown() {
		System.out.println("BURN THE VILLAGE");
		this.energyLevel -= 100;
		
	}
}
