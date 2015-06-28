public class CheckingAccount extends DepositAccount {
  	// another constructor
  	public CheckingAccount(String name, String number, float initbal) {
        super(name, number, initbal);
    }

  	// methods
  	public float checkBalance() {
  		return super.checkBalance();
  	}

  	public void processCheck(float amount) {
  		if( balance > amount) {
  			balance = balance - amount;
  		} else {
  			System.out.println("Not enough balance ");
  		}
  	}

  	public void withdrawCash(float amount) {
  		if(balance > amount) {
  			balance -= amount;
  		}
  	}

  	public void withdrawCash(float amount, float surcharge) {
  		if(balance > (amount + surcharge)) {
  			balance = balance - amount - surcharge;
  		}
  	}


}