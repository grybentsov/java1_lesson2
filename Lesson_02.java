package ru.geekbrains.lesson_02;
import java.util.Arrays;
public class Lesson_02 {

    public static void main(String[] args) {
        // Task 1:
        int[] array1 = {1, 1, 0, 0, 1, 0, 1, 1, 0, 0};
        changeElementsOfArray(array1);
        System.out.println("Changed array: " + Arrays.toString(array1));

        // Task 2:
        int[] array2 = new int[8];
        fillArrayWithValues(array2);
        System.out.println("Answer: " + Arrays.toString(array2));

        // Task 3:
        int[] array3 = {1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        changeSomeElementsOfArray(array3);
        System.out.println("Changed array is: " + Arrays.toString(array3));

        // Task 4.1 and 4.2:
        int[] array4 = {785, 236, 45, 38, 17, 652, -10, 999, 419, 29};
        System.out.println("Max element is: " + findMaxElement(array4));
        System.out.println("Min element is: " + findMinElement(array4));

        // Task 5:
        int[][] array5 = new int[10][10];
        fillDiagonalElementsOfArray(array5);

        // Task 6:
        int[] array6 = {8, 0, 4, 1, 11, 24, 21, 17, 10};
        System.out.println("Answer: " + checkBalance(array6));
        int[] array6_1 = {8, 0, 4, 1, 11, 24, 21, 17, 10, -88};
        System.out.println("Answer: " + checkBalance(array6_1));
    }

    // Task 1
    public static void changeElementsOfArray(int[] someArray) {
        for (int i = 0; i < someArray.length; i++) {
            if (someArray[i] == 0) {
                someArray[i] = 1;
            } else {
                someArray[i] = 0;
            }
        }
    }

    // Task 2
    public static void fillArrayWithValues(int[] someArray) {
        someArray[0] = 1;
        for (int i = 1, j = 1; i < someArray.length; i++) {
            someArray[i] = j += 3;
        }
    }

    // Task 3
    public static void changeSomeElementsOfArray(int[] someArray) {
        for (int i = 0; i < someArray.length; i++) {
            if (someArray[i] < 6) {
                someArray[i] *= 2;
            }
        }
    }

    // Task 4.1 - max
    public static int findMaxElement(int[] someArray) {
        int maxValue = someArray[0];
        for (int i = 0; i < someArray.length; i++) {
            if (someArray[i] > maxValue)
                maxValue = someArray[i];
        }
        return maxValue;
    }

    // Task 4.2 - min
    public static int findMinElement(int[] someArray) {
        int minValue = someArray[0];
        for (int i = 0; i < someArray.length; i++) {
            if (someArray[i] < minValue)
                minValue = someArray[i];
        }
        return minValue;
    }

    // Task 5
    public static void fillDiagonalElementsOfArray(int[][] someArray) {
        for (int i = 0, j = 0; i < someArray.length; i++, j++) {
            if (i == j) {
                someArray[i][j] = 1;
            }
            someArray[i][j] = 1;    // заполняем единицами диагональ с левого верхнего угла таблицы до нижнего правого
        }
        for (int j = someArray.length - 1, i = 0; i < someArray.length; j--, i++) {
            someArray[i][j] = 1;     // заполняем единицами вторую диагональ
        }
    }
    // Task 6 - вроде бы все работает правильно (?)
    public static boolean checkBalance(int[] someArray) {
        for (int x = 0; x < someArray.length; x++) {    // идем по массиву циклом слева направо

            int rightPart = 0, leftPart = 0;               // вводим начальное значение сумм правой и левой частей массива

            for (int y = 0; y < x; y++) {               // внутри внешнего цикла - еще один, чтобы проходить суммы слева (y < x)
                leftPart = leftPart + someArray[y];
            }

            for (int y = x; y < someArray.length; y++) {  // этот цикл также внутри внешнего, чтобы считать суммы элементов справа, начиная от y = x
                rightPart = rightPart + someArray[y];
            }

            if (leftPart == rightPart) {                   // проверка равенства частей
                return true;
            }
        }
        return false;
    }
}