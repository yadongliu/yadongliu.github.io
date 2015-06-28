public class SavingsAccount extends DepositAccount {
	  // variables
  	private float interestRate;

    // constructors
    public SavingsAccount(String name, String number, float initbal) {
        super(name, number, initbal);
    }

  	// methods
  	public void earnInterest(int months) {
  		  float interest = (interestRate/12)*months*balance;
  		  balance += interest;
  	}

    public void setRate(float rate) {
        if(balance > 1000000) {
          interestRate = rate * 1.02f;  
        } else {
          interestRate = rate;
        }
        
    }
}

