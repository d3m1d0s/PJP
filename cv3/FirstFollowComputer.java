package cv3;

import java.util.Scanner;

public class FirstFollowComputer {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        StringBuilder input = new StringBuilder();
        
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) break;
            input.append(line).append("\n");
        }
        sc.close();

        Grammar grammar = new Grammar(input.toString());
        Computer computer = new Computer(grammar);
        computer.printResults();
    }
}


