package ATM_INTER;

import java.util.Scanner;

class Bank_account{
	
	String user_name;
	String pin;
	String accountNo;
	int transactions = 0;
	String transaction_History = "";
	float balance = 100000;
	
	public void register() {
		Scanner sc = new Scanner(System.in);
		System.out.println("\nEnter your Username: ");
		this.user_name = sc.nextLine();
		System.out.println("\nEnter your Pincode: ");
		this.pin = sc.nextLine();
		System.out.println("\nEnter your Account Number: ");
		this.accountNo = sc.nextLine();
		System.out.println("\nRegistration Successful, \nplease remember the pin. \nPlease Login to ATM");
	}
	public boolean login() {
		boolean is_Login = false;
		Scanner sc=new Scanner(System.in);
		while( !is_Login) {
			System.out.println("\nEnter your username: ");
			String Username = sc.nextLine();
			if (Username.equals(user_name)) {
				while(!is_Login) {
					System.out.println("\nEnter your pincode: ");
					String Pincode = sc.nextLine();
					if(Pincode.equals(pin)) {
						System.out.println("\nLogin Successfully.");
						is_Login = true;
					}
					else {
						System.out.println("\nIncorrect Pincode");
					}
				}
			}else {
				System.out.println("\nusername is invalid");
			}
		}
		return is_Login;
	}
	
	public void deposit() {
		System.out.println("\nEnter Amount to Deposit: ");
		Scanner sc=new Scanner(System.in); 
		float amount = sc.nextFloat();
		try {
			if(amount <= 100000) {
				transactions++;
				balance += amount;
				System.out.println("\nDeposit Successful.");
				String str = amount + "Rs deposited\n";
				transaction_History = transaction_History+(str);
			}else {
				System.out.println("\nSorry. The limit is 10000.");
			}
		}catch(Exception e) {
			
		}
		
	}
	
	public void withdraw() {
		System.out.println("\nEnter Amount to Withdraw: ");
		Scanner sc=new Scanner(System.in); 
		float amount = sc.nextFloat();
		try {
			if(balance >= amount) {
				transactions++;
				balance -= amount;
				System.out.println("\nWithdral Successful.");
				String str = amount + "Rs Withdrawn\n";
				transaction_History = transaction_History+(str);
			}else {
				System.out.println("\nInsufficient Balance.");
			}
		}catch(Exception e) {
			
		}
		
	}
	
	public void transfer() {
	    Scanner sc=new Scanner(System.in); 
		System.out.println("\nEnter Receipent's Name: ");
		String receipent = sc.nextLine();
		System.out.println("\nEnter recipentant's account no: ");
		float acc_number = sc.nextFloat();
		System.out.println("\nEnter Amount to transfer: ");
		float amount = sc.nextFloat();

		try {
			if(balance>= amount) {
			if(amount <= 50000f) {
				transactions++;
				balance -= amount;
				System.out.println("\nSuccesfully Transferred to "+ receipent);
				String str = amount + "Rs transferred to " + receipent+"\n";
				transaction_History = transaction_History+(str);
			}else {
				System.out.println("\nSorry. The limit is 50000.");
			}
		}else{
			System.out.println("\nInsufficient Balance.");
		}}catch(Exception e) {
		}
			
		}
		
	public void checkBalance() {
		System.out.println("\n"+balance+"Rs");
	}
	
	

	public void transHistory() {
		if(transactions==0) {
			System.out.println("No TRansactions happened");
		}else {
			System.out.print("\n"+transaction_History);
		}
	}
}

public class Atm_interface {
	
	public static int takenIntegerInput(int limit) {
		int menu = 0;
		boolean flag = false;
		
		while(!flag) {
			try {
				Scanner sc = new Scanner(System.in);
				menu = sc.nextInt();
				flag = true;
				
				if(flag && menu>limit || menu<1) {
					System.out.println("Choose the number between 1 to "+limit);
					flag=false;
				}
			}catch(Exception e) {
				System.out.println("Enter only integer value.");
				flag=false;
			}
		}
		return menu;
	}
	
	public static void main(String[] args) {
		System.out.println("\nWELCOME TO ATM INTERFACE");
		System.out.println("\n1.Register  \n2.Exit");
		System.out.println("Choose one option: ");
		int choose = takenIntegerInput(2);
		
		if(choose == 1) {
			Bank_account b= new Bank_account();
			b.register();
			while(true) {
				System.out.println("\n1.Login \n2.Exit");
				System.out.println("Enter your choice: ");
				int ch = takenIntegerInput(2);
				if(ch==1) {
					if(b.login()) {
						System.out.println("\nWELCOME BACK"+ b.user_name);
						boolean isFinished = false;
						while(!isFinished) {
							System.out.println("\n1.withdraw \n2.Deposit \n3.Transfer \n4.check balance \n5.Transaction History \n6.Exit");
							System.out.println("Enter your choice: ");
							int c = takenIntegerInput(6);
							switch(c) {
							  case 1:
								 b.withdraw();
								 break;
							  case 2:
								 b.deposit();
								 break;
							  case 3:
								b.transfer();
								break;
							  case 4:
								b.checkBalance();
								break;
							  case 5:
								b.transHistory();
								break;
							  case 6:
								isFinished = true;
								break;
							}
						}
					}
				}else {
					System.out.println("you're exited!");
					System.exit(0);
				}
				
			}
		}else {
			System.exit(0);
		}
	}

}