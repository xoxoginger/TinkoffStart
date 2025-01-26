//Status: PARTIAL SOLUTION

import java.util.Scanner;

public class Main
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(); //кол-во сотрудников - р-р массива
        int t = scanner.nextInt(); //время, через которое сотрудник уйдет
        int numFloors[] = new int[n]; 
        for (int i = 0; i < n; i++) {
            if (scanner.hasNextInt()) {
            numFloors[i] = scanner.nextInt();
            }
        }
        int employee = scanner.nextInt() - 1; //номер сотрудника(индекс в массиве)
        
        
        if (t <= (numFloors[employee] - numFloors[0])) {
            //тогда поднимаемся сразу
            //и смотрим, куда выгоднее пойти, вверх или вниз
            if ((numFloors[n-1] - numFloors[employee]) <= (numFloors[employee] - numFloors[0]))
                System.out.println((numFloors[n-1] - numFloors[employee]) + (numFloors[n-1] - numFloors[0]));
            else System.out.println((numFloors[employee] - numFloors[0]) + (numFloors[n-1] - numFloors[0]));
        }
        else System.out.println(numFloors[n-1] - numFloors[0]);
    }
}
