package net.hamburger;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        /* EXERCISE & SOLUTION 2  */
        /*
         * Exercise 2:
         * a) Re-create the Trivia Game from before. This time with 5 Questions & 5 Answers!
         *  Use Arrays to save the question and answers.
         *  Create at least two methods that make the code more readable and easier to follow.
         *    --> Hint: Duplicate code can usually be made into methods
         *  BONUS:  Use an endless while loop with if statements so the user can play until they don't want anymore.
         *
         * OPTIONAL HARDER EXERCISE (Without Solution):
         * b) Create a very simple version of Tik Tak Toe
         *  Hints: Use one array to save the board. Think about what type of data you need!
         *         Use methods to properly print out each row of the board.
         *         Make it a two Player Game (making an AI is too advanced :P)
         *         You will need to use Loops here as well!
         *
         */
        /* System.out.println("|-|-|-|-| !TRIVIA GAME! |-|-|-|-|");

        String[] questions = new String[5];
        questions[0] = "Какая компания владеет YouTube?";
        questions[1] = "Назовите столицу Италии";
        questions[2] = "В каком году началась Вторая мировая война?";
        questions[3] = "Имя первого человека, полетевшего в космос";
        questions[4] = "Как звали Ньютона?";

        String[] answers = new String[5];
        answers[0] = "google";
        answers[1] = "рим";
        answers[2] = "1939";
        answers[3] = "юрий";
        answers[4] = "исаак";

        int points = 0;

        boolean youWantContinue = true;
        while (youWantContinue) {
            int num = triviaGameAnswerCheck(questions, answers, points);
            System.out.println("Поздравляем! вы прошли викторину. Ваш счёт: " + num + "/" + questions.length);
            System.out.println("Вы хотите начать сначала? Y/N:");
            Scanner scanner = new Scanner(System.in);
            String continueTrivia = scanner.next();

            if (continueTrivia.equals("Y")) {
                youWantContinue = true;
            } else {
                youWantContinue = false;
            }
        }           */

        System.out.println("Крестики-нолики!");
        String[][] crossZero = {{"_","_","_","_","_","_","_","_","_"}, {"_","_","_","_","_","_","_","_","_"}, {"_","_","_","_","_","_","_","_","_"}};
        gridGeneration(crossZero);

        for (int i = 0; i < 10; i++){
            int result = xPass(crossZero);
            while (result == 0){
                result = xPass(crossZero);
            }
            gridGeneration(crossZero);
            result = yPass(crossZero);
            while (result == 0){
                result = yPass(crossZero);
            }
            gridGeneration(crossZero);
        }
    }

    public static int xPass(String[][] crossZero) {     // Ход игрока Х с валидацией по координатам и знаку
        System.out.println("Ход игрока: Х");
        System.out.println("Первая цифра - строка");
        System.out.println("Вторая цифра - столбец");
        Scanner scannerI = new Scanner(System.in);
        String coordinate = scannerI.next();

        int iCoordinate = Character.getNumericValue(coordinate.charAt(0));
        int jCoordinate = Character.getNumericValue(coordinate.charAt(1));

        boolean isValid = validation(iCoordinate, jCoordinate);         // Валидация по координатам (не выходить за рамки поля)
        if (isValid){
            iCoordinate = iCoordinate - 1;
            jCoordinate = jCoordinate - 1;
            if (!crossZero[iCoordinate][jCoordinate].equals("_")){      // Валидация по знаку (нельзя записать значение в занятую клетку)
                System.out.println("Данная клетка уже занята!!!");
                return 0;
            } else {
                crossZero[iCoordinate][jCoordinate] = "X";
                return ((iCoordinate+1)*10)+jCoordinate+1;
            }
        } else {
            System.out.println("Недопустимые координаты!!!");
            return 0;
        }
    }
    public static boolean validation(int x, int y) {
        boolean isEqual;
        if ((x < 4) & (y < 4)) {
            isEqual = true;
        } else {
            isEqual = false;
        }
        return isEqual;
    }
    public static int yPass(String[][] crossZero) {             // Ход игрока 0 с валидацией по координатам и знаку
        System.out.println("Ход игрока: 0");
        System.out.println("Первая цифра - строка");
        System.out.println("Вторая цифра - столбец");
        Scanner scannerI = new Scanner(System.in);
        String coordinate = scannerI.next();

        int iCoordinate = Character.getNumericValue(coordinate.charAt(0));
        int jCoordinate = Character.getNumericValue(coordinate.charAt(1));

        boolean isValid = validation(iCoordinate, jCoordinate);      // Валидация по координатам (не выходить за рамки поля)
        if (isValid){
            iCoordinate = iCoordinate - 1;
            jCoordinate = jCoordinate - 1;
            if (!crossZero[iCoordinate][jCoordinate].equals("_")){    // Валидация по знаку (нельзя записать значение в занятую клетку)
                System.out.println("Данная клетка уже занята!!!");
                return 0;
            } else {
                crossZero[iCoordinate][jCoordinate] = "0";
                return ((iCoordinate+1)*10)+jCoordinate+1;
            }
        } else {
            System.out.println("Недопустимые координаты!!!");
            return 0;
        }
    }
    public static void gridGeneration(String[][] crossZero) {
        for (int i = 0; i < 3; i++) {  //идём по строкам
            for (int j = 0; j < 3; j++) {//идём по столбцам
                System.out.print("[" + crossZero[i][j] + "]"); //вывод элемента
            }
            System.out.println();//перенос строки ради визуального сохранения табличной формы
        }
    }
    public static void checkWinner(){}
    }

