//Status: PARTIAL SOLUTION

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();
        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = scanner.nextInt();
        }

        
        if (n == 2) {
            if ((heights[0] % 2 != 1 && heights[1] % 2 != 0)) {
                System.out.println("1 2");
                return;
            } 
            else {
                System.out.println("-1 -1");
                return;
            }
        }

        int oddMistakeCount = 0;
        int evenMistakeCount = 0;

        int oddMistakeIndex = -1;
        int evenMistakeIndex = -1;

        for (int i = 0; i < n; i++) {
            if ((i % 2 == 0 && heights[i] % 2 != 0)) {
                evenMistakeCount++;
                evenMistakeIndex = i + 1;
            }
            if ((i % 2 != 0 && heights[i] % 2 != 1)) {
                oddMistakeCount++;
                oddMistakeIndex = i + 1;
            }
        }

        if (oddMistakeCount == 1 && evenMistakeCount == 1)
            System.out.println(evenMistakeIndex + " " + oddMistakeIndex);
        else
            System.out.println("-1 -1");
    }
}
