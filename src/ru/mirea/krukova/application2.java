package ru.mirea.krukova;

import java.util.*;

public class application2 {
    public static void main(String[] args){
        //Задание 3.
        System.out.print("Введите длину массивов: ");
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arrayFirst = new int[len];
        Random rd = new Random();
        for(int i = 0; i < len; i++){
            arrayFirst[i] = rd.nextInt(-10, 10);
        }
        Arrays.sort(arrayFirst);
        System.out.println("Первый массив: " + Arrays.toString(arrayFirst));

        int[] arraySecond = new int[len];
        for(int i = 0; i < len; i++){
            arraySecond[i] = rd.nextInt(-10, 10);
        }
        Arrays.sort(arraySecond);
        System.out.println("Второй массив: " + Arrays.toString(arraySecond));

        ArrayList<Integer> numbers = sameNumbers(arrayFirst, arraySecond);

        System.out.print("Повторяющиеся элементы: ");
        for (int num : numbers) { //вывод чисел в строку.
            System.out.print(num + " ");
        }
        System.out.println();
        sameNumbers(arrayFirst, arraySecond);

        //при простом способе повторяющиеся числа могут выводиться большее количество раз, чем на деле (при условии, что в одном из массивов данное число повторяется n-ое кол-во раз, а в другом < n раз)
        /* (int i = 0; i < len; i++){
            for (int j = 0; j < len; j++){
                if (arrayFirst[i] == arraySecond[j]){
                    System.out.print(arrayFirst[i] + " ");
                }
            }
        }*/

        //если усовершенствовать простой метод
        List<Integer> povtor = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (arrayFirst[i] == arraySecond[j] && !povtor.contains(arrayFirst[i])) {
                    povtor.add(arrayFirst[i]);
                }
            }
        }

        System.out.println("Повторы: " + povtor);



    }

    public static ArrayList<Integer> sameNumbers(int[] arr1, int[] arr2) {
        //Задание 4.
        //второй метод
        Set<Integer> set1 = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int num : arr1) {
            set1.add(num);
        }

        for (int num : arr2) {
            set2.add(num);
        }

        Set<Integer> sameNums = new HashSet<>(set1);
        sameNums.retainAll(set2);

        return new ArrayList<>(sameNums);
    }
}