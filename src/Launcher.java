import java.util.Scanner;

public class Launcher {

    public static void main(String[] args) {
        while(true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Input :");
            String input = sc.nextLine();
            switch (input) {
                case "quit":
                    return;
                default:
                    System.out.println("Unknown command");
            }
        }
    }
}