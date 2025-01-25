//Status: PARTIAL SOLUTION
/*
Ограничение времени З секунды
Ограничение памяти 512 МБ 

Герман немного устал. Вот бы кто-нибудь сделал за него домашнее задание... 
Задача, которую необходимо решить Герману, звучит следующим образом. Дана последовательность a_1, a_2, ..., a_n и числа x, y, z. 
Разрешается произвольное количество (в том числе ноль} раз выполнить следующую операцию:  выбрать произвольное i (1 <= i <= n) и увеличить a_i на единицу. 
Необходимо, чтобы хотя бы один элемент из последовательности делился на x, хотя бы один элемент делился на y и хотя бы один элемент делился на z. 
Разрешается, чтобы для разных значений из набора (x, y, z) подходил один и тот же элемент из последовательности. 
Помогите Герману отдохнуть перед сессией и найдите минимальное количество операций,  которое необходимо выполнить, чтобы условие стало выполнено. 

Формат входных данных
Первая строка содержит числа n (1 <= n <= 2 * 10^5), x, y, z (1 <= x, y,z <= 10^6)
Вторая строка содержит числа a_1, a_2, ..., a_n (1 <= a_i <= 10^18) 

Формат выходных данных
Выведите одно число — минимальное количество операций, которое надо выполнить, чтобы для  каждого из чисел x, y, z 
был хотя бы один элемент в последовательности, кратный данному числу.
 

Комментарий к примеру
В примере можно дважды увеличить a_4 и один раз увеличить a_5. Тогда на 10 будет делиться a_4, на 20 будет делиться a_5, на 30 будет делиться a_4


Примеры данных
Ввод 
6 10 20 30 
8 17 5 28 39 13
Вывод
3
*/


//Не сделанное до конца решение - нет кейсов, когда все diff-ы разные + неоптимально
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        int z = scanner.nextInt();

        long[] a = new long[n];
        for (int i = 0; i < n; i++) a[i] = scanner.nextLong();
      
        long[] differenceX = new long[n];
        long[] differenceY = new long[n];
        long[] differenceZ = new long[n];
        long[] differenceSum = new long[n];
        
        //для вычисления минимального количества операций
        long minOperationsX = Long.MAX_VALUE;
        long minOperationsY = Long.MAX_VALUE;
        long minOperationsZ = Long.MAX_VALUE;
        
        /*
        long minOperationsXOld = Long.MAX_VALUE;
        long minOperationsYOld = Long.MAX_VALUE;
        long minOperationsZOld = Long.MAX_VALUE;
        long minOperationsTemp = Long.MAX_VALUE;
        //запоминать индексы для разных
        int indexX = 0; 
        int indexY = 0;
        int indexZ = 0; 
        */
        
        for (int i = 0; i < n; i++) {
            differenceX[i] = (x - a[i] % x) % x;
            differenceY[i] = (y - a[i] % y) % y;
            differenceZ[i] = (z - a[i] % z) % z;
            
            /*
            //если все разные
            if((differenceX[i] != differenceY[i]) & (differenceY[i] != differenceZ[i]) & (differenceX[i] != differenceZ[i])) {
                //проверка: если значение стало меньше, запоминаем новый индекс 
                minOperationsXOld = minOperationsX;
                minOperationsX = Math.min(minOperationsX, differenceX[i]);
                if(minOperationsX != minOperationsXOld) indexX = i;
                
                minOperationsYOld = minOperationsY;
                minOperationsY = Math.min(minOperationsY, differenceY[i]);
                if(minOperationsY != minOperationsYOld) indexY = i;
                
                minOperationsZOld = minOperationsZ;
                minOperationsZ = Math.min(minOperationsZ, differenceZ[i]);
                if(minOperationsZ != minOperationsZOld) indexZ = i;
            } */
            
        }
        /*if((indexX == indexY) & (indexX == indexZ) & (indexZ == indexY)) {
            if((a[indexX] + (x - a[indexX])) % x == 0)
        }*/
        minOperationsTemp = minOperationsX + minOperationsY + minOperationsZ;
        if(minOperationsTemp != Long.MAX_VALUE) {
            System.out.println(minOperationsTemp);
            return;
        }
        else {    
            for (int i = 0; i < n; i++) {    
                if(differenceX[i] == differenceY[i]){
                    for (int j = 0; j < n; j++) {
                        differenceSum[j] = differenceZ[j] + differenceX[i];
                    }
                    for (int j = 0; j < n; j++) { //поиск минимальной разницы стоимости операций
                        if(differenceSum[j] < minOperationsTemp) minOperationsTemp = differenceSum[j];
                    }
                }
                else if(differenceX[i] == differenceZ[i]){
                    for (int j = 0; j < n; j++) {
                        differenceSum[j] = differenceY[j] + differenceX[i];
                    }
                    for (int j = 0; j < n; j++) { //поиск минимальной разницы стоимости операций
                        if(differenceSum[j] < minOperationsTemp) minOperationsTemp = differenceSum[j];
                    }
                }
                else if(differenceY[i] == differenceZ[i]){
                    for (int j = 0; j < n; j++) {
                        differenceSum[j] = differenceZ[j] + differenceY[i];
                    }
                    for (int j = 0; j < n; j++) { //поиск минимальной разницы стоимости операций
                        if(differenceSum[j] < minOperationsTemp) minOperationsTemp = differenceSum[j];
                    }
                }
              }
        }

        // Вывод результата
        //long totalMinOperations = minOperationsX + minOperationsY + minOperationsZ;
        System.out.println(minOperationsTemp);
    }
}
