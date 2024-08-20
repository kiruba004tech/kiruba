package info;
import java.sql.SQLException;
import java.util.*;

import register.login;
import register.bankinfo;
import show.loginshow;
import show.bankinfoshow;
public class Main {
	public static void main(String[] args) throws ClassNotFoundException, SQLException 
	{
		Scanner sc = new Scanner(System.in);
		int choice,product;
		
		login l = new login();
		loginshow lshow = new loginshow();
		bankinfo p = new bankinfo();
		bankinfoshow pshow = new bankinfoshow();
		
		do
		{
			System.out.println("1. Bank Empoly\n2. Coustmer\n3. Exit");
			System.out.println("*****************************************************");
			System.out.println("Enter your choice");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Bank Employ Login!!!");
				System.out.println("Enter the username");
				String username = sc.next();
				System.out.println("Enter the password");
				String password = sc.next();
				l.setUsername(username);
				l.setPassword(password);
				if(lshow.loginValidation(l))
				{
					System.out.println("Bank Employ successfully logged in!!!");
					do
					{
						System.out.println("*****************************************************");
						System.out.println("1. Add Account\n2. Display Detials\n3. Logout");
						System.out.println("*****************************************************");
						System.out.println("Enter your choice");
						product = sc.nextInt();
						switch(product)
						{
						case 1:
							System.out.println("Add Ammount");
							System.out.println("Enter Account ID");
							int AccountID = sc.nextInt();
							System.out.println("Enter Account Name");
							String AccountName = sc.next();
							System.out.println("Enter Address");
							String Address = sc.next();
							System.out.println("Enter Phone Number");
							int PhoneNumber = sc.nextInt();
							System.out.println("Enter Balance");
							int Balance = sc.nextInt();
							p.setAccountID(AccountID);
							p.setAccountName(AccountName);
							p.setAddress(Address);
							p.setPhoneNumber(PhoneNumber);
							p.setBalance(Balance);
							pshow.add(p);
							System.out.println("Ammount added Successfully!!!");
							break;
						case 2:
							System.out.println("Account details are below:");
							pshow.display();
							break;
						case 3:
							System.out.println("Logged out successfully!!!");
							break;
						}
					}while(product!=3);
				}
				else
				{
					System.out.println("Bank Employ failed to login!!!\nInvalid Username/Password");
				}
				break;
			case 2:
				System.out.println(" Customer Login!!!");
				System.out.println("Enter the username");
				String username1 = sc.next();
				System.out.println("Enter the password");
				String password1 = sc.next();
				l.setUsername(username1);
				l.setPassword(password1);
				if(lshow.loginValidation(l))
				{
					System.out.println("Customer successfully logged in!!!");
					do
					{
						System.out.println("*****************************************************");
						System.out.println("1. Display Detials \n2. Ammount WithDraw\n3. Logout");
						System.out.println("*****************************************************");
						System.out.println("Enter your choice");
						product = sc.nextInt();
						switch(product)
						{
						case 1:
							System.out.println("Account details are below:");
							pshow.display();
							break;
						case 2:	
							System.out.println("Enter the Ammount");
							int Withdraw = sc.nextInt();
							p.setWithdraw(Withdraw);
							if(pshow.updatebankinfo(p))
								System.out.println("WithDraw Successfully!!!");
							else
								System.out.println("Out of Balance!!!");
						case 3:
							System.out.println("Logged out successfully!!!");
							break;
						}
					}while(product!=3);
				}
				else
				{
					System.out.println("Agent failed to login!!!\nInvalid Username/Password");
				}
				break;
			case 3:
				System.out.println("Exit");
				break;
			}
		}while(choice!=3);
		sc.close();
}
}