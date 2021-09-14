package com.ATM;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Account {
	
	private int customerNumber;
	private int pinNumber;
	private double checkingBalance = 0;
	private double savingBalance = 0;
	
	Scanner sc  = new Scanner(System.in);
	DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
	public int getCustomerNumber() {
		return customerNumber;
	}
	public void setCustomerNumber(int customerNumber) {
		this.customerNumber = customerNumber;
	}
	public int getPinNumber() {
		return pinNumber;
	}
	public void setPinNumber(int pinNumber) {
		this.pinNumber = pinNumber;
	}
	public double getCheckingBalance() {
		return checkingBalance;
	}
	public double getSavingBalance() {
		return savingBalance;
	}
	
	// Calculatioh methods 
	
	public double calCheckingWithdraw(double amount) {
		checkingBalance = checkingBalance - amount;
		return checkingBalance;
	}
	public double calSavingWithdraw(double amount) {
		savingBalance = savingBalance - amount;
		return savingBalance;
	}
	public double calCheckingDeposit(double amount) {
		checkingBalance = checkingBalance + amount;
		return checkingBalance;
	}
	
	public double calSavingDeposit(double amount) {
		savingBalance = savingBalance + amount;
		return savingBalance;
	}
	
	
	public void getCheckingWithdrawlAmount(){
		System.out.println("checking account balance: "+moneyFormat.format(checkingBalance));
		System.out.println("Amount u wanna withdraw from current account: ");
		double amount  = sc.nextDouble();
		
		if((checkingBalance - amount)>=0) {
			calCheckingWithdraw(amount);
			System.out.println("New Balance "+ moneyFormat.format(checkingBalance));
		}else {
			System.out.println("Balance insufficient to withdrawl");
		}
	}
	public void getCheckingDepositAmount() {
		
		System.out.println("checking Account balance: "+ moneyFormat.format(checkingBalance));
		System.out.println("Amount u wanna deposit in current account: ");
		double amount  = sc.nextDouble();
		
		if((checkingBalance + amount)>=0) {
			calCheckingDeposit(amount);
			System.out.println("New Balance "+ moneyFormat.format(checkingBalance));
		}else {
			System.out.println("Not Enough balance to withdrwal");
		}
	}
	public void getSavingWithdrawlAmount() {
		System.out.println("Saving Account Balance: "+moneyFormat.format(savingBalance) );
		System.out.println("Amount Withdraw from saving account");
		double amount  = sc.nextDouble();
		
		if((savingBalance - amount)>=0) {
			calSavingWithdraw(amount);
			System.out.println("NEW saving accout balance: "+moneyFormat.format(savingBalance));
		}else {
			System.out.println("Balance cannot be less than 0: " );
		}
		
	}
	
	public void getSavingDepositAmount() {
		System.out.println("Saving Account Balance: "+moneyFormat.format(savingBalance) );
		System.out.println("Amount Deposit in saving account");
		double amount  = sc.nextDouble();
		
		if((savingBalance + amount)>=0) {
			calSavingDeposit(amount);
			System.out.println("NEW saving accout balance: "+moneyFormat.format(savingBalance));
		}else {
			System.out.println("Balance cannot be less than 0: " );
		}
	}
}
