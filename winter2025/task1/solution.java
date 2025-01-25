//Status: OK

/* 
Ограничение времени Зсекунды 
Ограничение памяти 512MB 

Недавно маленький Антон научился читать некоторые буквы! Точнее, он научился читать буквы R, S и M.  
Кроме того, набор из трех букв R, S и M ему кажется правильным, если в нем символ R находится раньше, чем символ M. 
Определите, является ли строка s правильной по мнению Антона. 

Формат входных данных
Дана строка s из трех символов, содержащая один символ R, один символ S и один символ M. 
Формат выходных данных
Выведите Yes, если символ R находится в строке s раньше, чем символ M. В противном случае выведите No. 

Примеры данных
Пример 1
SMR No
Пример 2 
RSM Yes 
*/

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int indexR = s.indexOf('R');
        int indexM = s.indexOf('M');
        
        if (indexR < indexM) System.out.println("Yes");
        else System.out.println("No");
    }
}
