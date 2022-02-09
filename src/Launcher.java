import java.util.Scanner;

public class Launcher {

    static int fibo(int n) {
        if (n == 0 || n == 1) {
            return n;
        }
        return fibo(n - 1) + fibo(n - 2);
    }

    public static void main(String[] args) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input :");
            String input = sc.nextLine();
            switch (input) {
                case "quit":
                    return;
                case "fibo":
                    System.out.println("Enter number :");
                    int nb = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Fibo : " + fibo(nb));
                    break;
                default:
                    System.out.println("Unknown command");
            }
        }
    }
}