//Status: OK

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long n = scanner.nextLong();
        int cuts = 0;

        while (n > 1) {
            n = (n + 1) / 2;
            cuts++;
        }

        System.out.println(cuts);
    }
}
