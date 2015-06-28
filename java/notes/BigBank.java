import java.util.ArrayList;

public class BigBank {
	ArrayList<DepositAccount> allAccounts;

	public BigBank() {
		allAccounts = new ArrayList<DepositAccount>();
	}

	public void addAccount(DepositAccount account) {
		allAccounts.add(account);
	}

	public float totalAccountBalance() {
		float result = 0;
		for(int i=0; i<allAccounts.size(); i++) {
			DepositAccount account = allAccounts.get(i);
			result += account.checkBalance();
		}

		return result;
	}

	public String toString() {
		return "Total Accounts: " + allAccounts.size() 
		+ ", Total balance: " + totalAccountBalance();
	}

	public static void main(String[] args) {
  		CheckingAccount myAccount=new CheckingAccount("Yadong", "00012345", 1000);
  		System.out.println(myAccount.toString());

  		myAccount.acceptDeposit(1000);
  		System.out.println(myAccount.toString());

  		BigBank bank = new BigBank();
  		bank.addAccount( myAccount );

  		CheckingAccount account2;
  		account2 = new CheckingAccount("Andrew", "10002000", 1000);

  		bank.addAccount(account2);

  		System.out.println( bank.toString() );

  		SavingsAccount mySavingsAccount = 
  		new SavingsAccount("Yadong", "10102020", 1009.0f);

  		bank.addAccount( mySavingsAccount );
  		System.out.println( bank.toString() );

  		SavingsAccount acct = 
  		new SavingsAccount("Yadong", "10102021", 1000010.0f);
  		acct.setRate(2.0f);
  		// acct.interestRate = 2.0f;

  		acct.earnInterest(2);
  		System.out.println( acct.toString() );

  	}

}