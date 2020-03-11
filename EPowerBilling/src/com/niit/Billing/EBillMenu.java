package com.niit.Billing;

import java.util.Scanner;

public class EBillMenu {
	public static void main(String ar[]) {
		int loginChoiceFlag;
		int choice;
		int choiceFlag;
		Scanner s = new Scanner(System.in);

		do{
			System.out.println("**********WELCOME**********\n ***********TO************\n ****E-POWER BILLING****");
			System.out.println("select the option\n Press 1 if you are Admin \n Press 2 if you are consumer of our E-power Billing portal");

			choice = s.nextInt();
			do{
				// if Admin is logged in
				switch (choice){
				case 1:{
					System.out.println("Admin is loged in");
					Admin a1 = new Admin();


					System.out.println("press 1 to see the records of user \n press 2 to insert the new connection details of the user \n press 3 to update the consumed unit of the user\n press 0 to get logged out");

					int adminChoice = s.nextInt();
					switch (adminChoice){
					case 1:{
						a1.getUserDetails();
						break;
					} 
					case 2: {
						a1.insertInConnectionDetails();
						break;
					} 
					case 3:{
						a1.updateConsumedUnits();
						break;
					}



					}
					break;

				}

				// if Consumer is logged in
				case 2: {
					System.out.println("consumer is logged in");
					Consumer c1 = new Consumer();
					System.out
					.println("press 1 if you are registering for the first time \n press 2 if you want to update password and mobile number \n press 3 to get bill details \n press 0 for  logout");
					int consumerChoice = s.nextInt();
					switch(consumerChoice){
					case 1: {
						c1.insertNewRecord();
						break;
					} 
					case 2: {
						c1.passwordUpdate();
						break;
					}
					case 3:{
						c1.getBill();
						break;
					}
					default:{
						System.out.println("YOU HAVE ENTERED WRONG INPUT");
						break;
					}
					}

				}
				default:{
					System.out.println("you have entered wrong input");
					break;
				}

				}
				System.out.println("Do You Want To Stay On This Page\n press 1 for This Page\n 0 for Home Page");
				choiceFlag=s.nextInt();
			}while(choiceFlag==1);
			System.out.println("Enter 1 if you want to stay on the webApp \n enter 0 if you want to quit ");
			loginChoiceFlag= s.nextInt();
		}while(loginChoiceFlag == 1);
		s.close();
	}
}