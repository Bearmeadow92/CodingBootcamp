package com.jessefletcher.zookeeper;

public class Mammal {
	//MEMBER VARIABLES
	protected int energyLevel;
	
	
	//CONSTRUCTORS
	public Mammal() {
		this.energyLevel = 100;
	}
	
	
	
	public Mammal(int energyLevel) {
		super();
		this.energyLevel = energyLevel;
	}
	
	
	//GETTERS / SETTERS /METHODS
	
	
	
	
	public int displayEnergy(){
		System.out.println("Energy level is " + this.energyLevel);
		return energyLevel;
	}
	
	public int getEnergyLevel() {
		return energyLevel;
	}

	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}

}
