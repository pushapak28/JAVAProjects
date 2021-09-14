package com.ATM;

import java.io.IOException;
import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Scanner;
//import javax.sound.midi.SysexMessage;

public class optionMenu extends Account {

		Scanner menuInput = new Scanner(System.in);
		DecimalFormat moneyFormat = new DecimalFormat("'$'###,##0.00");
		
		HashMap<Integer, Integer> data = new HashMap<Integer,Integer>();
		public void getLogin()throws IOException {
			int x = 1;
			do {
				try {
					data.put(12345, 123);
					data.put(456789,789 );
					
					System.out.println("--------------Welcome to the ATM Project-------------");
					System.out.println("Enter your Customer Number");
					setCustomerNumber(menuInput.nextInt());
					
					System.out.println("Enter your PIN number: ");
					setPinNumber(menuInput.nextInt());
				}catch(Exception e) {
					System.out.println( "\n Invalid Charcter(s). Only Numbers. ");
					x=2;
				}
				
				int cn = getCustomerNumber();
				int pn = getPinNumber();
				if(data.containsKey(cn)&&data.get(cn)==pn) {
					getAccountType();
				}else {
					System.out.println("Wrong customer Number or pin Number");
				}			
			}
			while(x==1);
		}
		public void getAccountType() {

			System.out.println("Select the Account you want to access: ");
			System.out.println("Type 1 : Checking account");
			System.out.println("Type 2 : Saving Account");
			System.out.println("Type 3 : Exit");
			
			System.out.println("Select : ");
			int selection = menuInput.nextInt();
			switch (selection) {
			case 1: {
				
				getChecking();
				break;
			}
			case 2:{
				getSaving();
				break;
			}
			case 3 :{
				System.out.println("Thanks for visiting ATM Portal");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + selection);
			}
		}
		
		public void getChecking() {
			System.out.println("Checking Account: ");
			System.out.println(" 1. Check Balance");
			System.out.println(" 2. Withdraw Amount");
			System.out.println(" 3. Deposit Amount");
			System.out.println(" 4. Exit");
			System.out.println("Select: ");
			int selection = menuInput.nextInt();
			switch (selection) {
			case 1: {
				
				System.out.println("Available Balance: "+moneyFormat.format(getCheckingBalance()));
				getAccountType();
				break;
			}
			case 2:{
				getCheckingWithdrawlAmount();
				getAccountType();
				break;
			}
			case 3:{
				getCheckingDepositAmount();
				getAccountType();
				break;
			}
			case 4:{
				System.out.println("Thanks for visiting ATM Portal");
				break;
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + selection);
			}
		}

		public void getSaving() {
			System.out.println("Welcome to Saving Account");
			System.out.println(" 1. View Balance");
			System.out.println(" 2. Amount Withdrawl");
			System.out.println(" 3. Deopsit Amount  ");
			System.out.println(" 4. Exit" );
			System.out.println("Choice: ");
			int selection  = menuInput.nextInt();
			switch (selection) {
			case 1: {
				System.out.println("Saving Account Balance: " + moneyFormat.format(getSavingBalance()));
				getAccountType();
				break;
			}
			case 2:{
				getSavingWithdrawlAmount();
				getAccountType();
				break;
			}
			case 3:{
				getSavingDepositAmount();
				getAccountType();
				break;
			}
			case 4 :{
				System.out.println("Thanks for visiting");
			}
			default:
				throw new IllegalArgumentException("Unexpected value: " + selection);
			}
		}

		
}
