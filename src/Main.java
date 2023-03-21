
//Завдання 4
//
//Використовуючи IntelliJ IDEA, створіть клас UserArray.
// Створити метод, який виконуватиме збільшення довжини масиву,
// переданого як аргумент, на 1 елемент. Елементи масиву мають зберегти своє значення та порядок індексів.
// Створити метод, який приймає два аргументи, перший аргумент типу int [] array, другий аргумент типу int value.
// У тілі методу реалізуйте можливість додавання другого аргументу методу в масив за індексом 0,
// водночас довжина нового масиву має збільшитися на 1 елемент,
// а елементи одержуваного масиву як перший аргумент мають скопіюватися в новий масив починаючи з індексу 1.

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scInput = new Scanner(System.in);
        int arrayCount;
        do{
            System.out.print("Введіть розмір масива: ");
            arrayCount = scInput.nextInt();
            if(arrayCount<=0) System.out.println("Розмір масива не може бути менше або дорівнювати 0.");
            else break;

        }while(true);

        int[] arrayNumbers = CreateArray(arrayCount);
        PrintArray(arrayNumbers);

        int key = 0;
        do{
            System.out.print("Додати лемент спочатку(1) масива чи в кінці(2): ");
            key = scInput.nextInt();
            if(key != 1 && key != 2) System.out.println("Зроблено не вірний вибір. Виберіть 1 або 2.");
            else break;
        }while(true);

        System.out.print("Введіть елемент масива: ");
        int value = scInput.nextInt();

        int[] newArrayNumbers;
        if(key == 1) newArrayNumbers = AddElement(value, arrayNumbers);
        else newArrayNumbers = AddElement(arrayNumbers, value);

        PrintArray(newArrayNumbers);

    }

    static void PrintArray(int[] arrayNumbers){
        int clock = 10;
        System.out.println("Масив: ");
        for (int i = 0; i < arrayNumbers.length; i++){
            System.out.print(arrayNumbers[i] + " ");
            clock--;
            if(clock<=0) {clock = 10; System.out.println();}

        }
        System.out.println();
    }
    static int[] CreateArray(int arrayCount){
        Random rndNumber = new Random();
        int[] tempArrayNumbers = new int[arrayCount];

        for (int i=0; i<arrayCount; i++){
            tempArrayNumbers[i] = rndNumber.nextInt(1,100);
        }

        return tempArrayNumbers;
    }

    static int[] AddElement(int[] arrayNumbers, int value){
        int[] tempArrayNumbers = new int[arrayNumbers.length+1];
        for (int i = 0; i < arrayNumbers.length; i++){
            tempArrayNumbers[i] = arrayNumbers[i];
        }
        tempArrayNumbers[tempArrayNumbers.length-1] = value;

        return tempArrayNumbers;
    }

    static int[] AddElement(int value, int[] arrayNumbers){
        int[] tempArrayNumbers = new int[arrayNumbers.length+1];
        for (int i = 0; i < arrayNumbers.length; i++){
            tempArrayNumbers[i+1] = arrayNumbers[i];
        }
        tempArrayNumbers[0] = value;

        return tempArrayNumbers;
    }

}