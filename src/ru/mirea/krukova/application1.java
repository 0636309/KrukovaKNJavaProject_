import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class application1 {
    public static void main(String[] args){
        //Задание 1.
        System.out.print("Введите размер массива: ");
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] myArray = new int[len];

        //если массив вводится с клавиатуры:
        /*System.out.println("Введите элементы массива:");
        for(int i = 0; i < len; i++){
            myArray[i] = sc.nextInt();
        }*/

        //если заполняется случайно:
        Random rd = new Random();
        for(int i = 0; i < len; i++) {
            myArray[i] = rd.nextInt(-10, 10);
        }
        Arrays.sort(myArray);
        System.out.println("Исходный массив: " + Arrays.toString(myArray));
        System.out.print("Введите число для поиска: ");
        int numToFind = sc.nextInt();
        Search(myArray, numToFind);
    }
    public static void Search(int[] array, int number){
        int min = 0;
        int max = array.length - 1; //вроде очепятка в документе с кодом
        int average;

        int count = 0; //Задание 2.
        while(min <= max){
            average = (min + max) / 2;
            int num = array[average];
            if (num == number){
                System.out.println("Данное значение находится в массиве под индексом " + average);
                System.out.println("Количество операций: " + count);
                return;
            } else if (num > number){
                max = average - 1;
                count++;
            } else {
                min = average + 1;
                count++;
            }
        }
        System.out.println("Даннов значение отсутствует в массиве.");
    }
}

