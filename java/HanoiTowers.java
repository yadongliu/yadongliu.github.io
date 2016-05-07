import java.util.Scanner;
public class HanoiTowers {
    public static int round = 1;

    void move(String pole1, String pole2) 
    {
        System.out.println("Round " + round);
        round++;
        System.out.println(pole1 + " -> " + pole2);
    }

    public void solve(int n, String start, String middle, String end) {
        if (n == 1) {
            //System.out.println(start + " -> " + end);
            move(start, end);
        } else {
            solve(n - 1, start, end, middle);
            // System.out.println(start + " -> " + end);
            move(start, end);
            solve(n - 1, middle, start, end);
        }
    }

    public static void main(String[] args) {
        HanoiTowers game = new HanoiTowers();
        System.out.print("Enter number of discs: ");
        Scanner scanner = new Scanner(System.in);
        int discs = scanner.nextInt();
        game.solve(discs, "A", "B", "C");
    }
}
