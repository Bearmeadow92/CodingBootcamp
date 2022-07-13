package com.jessefletcher.bankaccount;

public class BankAccount {
	//MEMBER VARIABLES
	private double checkBalance;
	private double savingBalance;
	private static int numberOfAccounts = 0;
	private static double moneyInAccount = 0;
	
	//CONSTRUCTOR METHOD
	public BankAccount(double checkBalance, double savingBalance) {
		super();
		this.checkBalance = checkBalance;
		this.savingBalance = savingBalance;
		numberOfAccounts++; 
	}

	
	//GETTER / SETTER / OTHER METHODS
	
	public double getCheckBalance() {
		return checkBalance;
	}

	public void setCheckBalance(double checkBalance) {
		this.checkBalance = checkBalance;
	}

	public double getSavingBalance() {
		return savingBalance;
	}

	public void setSavingBalance(double savingBalance) {
		this.savingBalance = savingBalance;
	}
	
	
	
	
	
	public void depositChecking(double cashMoney) {
		this.checkBalance += cashMoney;
		
	}
	
	public void withdrawChecking(double cashMoney) {
		if (this.checkBalance < cashMoney) {
			System.out.println("Insufficient funds");
		}
		else {
			this.checkBalance -= cashMoney;
		}
	}
	
	public double seeTotalChecking() {
		
		return this.checkBalance;
		
	}
	
	public double seeTotalSavings() {
		
		return this.savingBalance;
	}
	
	public static int getAllAccounts() {
		return numberOfAccounts;
	}
	
	public static double getMoney() {
		return moneyInAccount;
	}
	
}




			
			
			