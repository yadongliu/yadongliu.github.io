public class SavingsAccount2 {
	// variables
  	String accountNumber;
  	String accountHolder;
  	float  interestRate;
  	float  balance;

	// constructors
  	public SavingsAccount(String name, String number, float initbal) {
     	accountHolder = name;
     	accountNumber = number;
     	balance = initbal;
    }

  	// methods
  	public float checkBalance() {
  		return balance;
  	}

  	public void acceptDeposit(int amount) {
  		balance = balance + amount;
  	}

  	public void earnInterest(int months) {
  		float interest = (interestRate/12)*months*balance;
  		balance += interest;
  	}
}

