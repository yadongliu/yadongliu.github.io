import java.util.Scanner;

class Tower {

	void move(String fromPole, String toPole) 
    {
        System.out.println(fromPole + " -> " + toPole);
    }


    public void solve(int n, String startPole, String middlePole, String endPole) {
    	if( n == 1 ) {
	    	// base case: move the only disc from startPole to endPole
	    	move(startPole, endPole);
    	} else {
    		// recursive case, solve Hanoi in 3 steps
    		// step 1: move (n-1) discs from start to the middle, using endPole as the intermediary
    		// step 2: move nth disc from start to end.
    		// step 3: move (n-1) discs from the middle to the endPole, using startPole as the intermediary
    		solve(n-1, startPole,  endPole, middlePole);
    		move(startPole, endPole);
    		solve(n-1, middlePole, startPole, endPole);
    	}

	}
    public static void main(String[] args) {
        Tower game = new Tower();
        System.out.print("Enter number of discs: ");
        Scanner scanner = new Scanner(System.in);
        int discs = scanner.nextInt();

        game.solve(discs, "PoleA", "PoleB", "PoleC");
	}

}






