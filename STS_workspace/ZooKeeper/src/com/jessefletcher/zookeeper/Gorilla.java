package com.jessefletcher.zookeeper;

public class Gorilla extends Mammal{
	//MEMBER VARIABLES
	
	
	//CONSTRUCTORS
	public Gorilla() {
		super();
	}
	
	public Gorilla(int energyLevel) {
		this.energyLevel=energyLevel;
	}
	
	//GETTERS / SETTERS / METHODS
	public void throwSomething() {
		System.out.println("Gorilla throws something!");
		this.energyLevel -= 5;
	}
	
	public void eatBananas() {
		System.out.println("Gorilla ate nanner!");
		System.out.println("MMM! BANANA DELICIOUS!");
		this.energyLevel += 10;
	}
	
	public void climb() {
		System.out.println("Gorilla climb!");
		this.energyLevel -= 10;
		
	}
}
