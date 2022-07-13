package com.jessefletcher.zookeeperII;

public class Mammal {
	//MEMBER VARIABLES
	protected int energyLevel;
	
	
	//CONSTRUCTORS
	public Mammal() {
		this.energyLevel = 300;
	}
	
	
	
	public Mammal(int energyLevel) {
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