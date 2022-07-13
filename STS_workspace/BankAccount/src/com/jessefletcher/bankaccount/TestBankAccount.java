package com.jessefletcher.bankaccount;

public class TestBankAccount {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BankAccount jesseAccount = new BankAccount(2 , 5);
		jesseAccount.depositChecking(5);
		System.out.println(jesseAccount.seeTotalChecking());
	}
	
}
