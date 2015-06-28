public class DepositAccount {
	// variables

 	  String accountNumber;
  	String accountHolder;
  	float  balance;

	// constructors
  	public DepositAccount(String name, String number, float initbal) {
     	accountHolder = name;
     	accountNumber = number;
     	balance = initbal;
    }

  	// methods
  	public float checkBalance() {
  		return balance;
  	}

  	public void acceptDeposit(float amount) {
  		balance = balance + amount;
  	}

    public String toString() {
      return "Account Number: "+accountNumber+
      ", Name: "+accountHolder + ", Balance: " + balance;
    }

}