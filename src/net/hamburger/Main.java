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

        String[][] crossZero = {{"_","_","_"}, {"_","_","_"}, {"_","_","_"}};
        gridGeneration(crossZero);

        for (int i = 0; i < 10; i++){
            int result = xPass(crossZero);
            int x;
            int y;
            x = (result - (result % 10))/10;
            y = result % 10;
            /* boolean validation = validation(x,y);
            if (!validation){
                System.out.println("Недопустимые координаты!");
                break;
            }   */


            gridGeneration(crossZero);
        }



    }

    public static int xPass(String[][] crossZero) {
        System.out.println("Ход игрока: Х");
        System.out.println("Первая цифра - строка");
        System.out.println("Вторая цифра - столбец");
        Scanner scannerI = new Scanner(System.in);
        String coordinate = scannerI.next();

        int iCoordinate = Character.getNumericValue(coordinate.charAt(0));
        int jCoordinate = Character.getNumericValue(coordinate.charAt(1));

        boolean isValid = validation(iCoordinate, jCoordinate);
        if (isValid){
            crossZero[iCoordinate][jCoordinate] = "X";
        } else {
            Integer nothing = null;
            iCoordinate = nothing;
            jCoordinate = nothing;
            System.out.println("Недопустимые координаты!!!");
        }

        iCoordinate = iCoordinate - 1;
        jCoordinate = jCoordinate - 1;

        return ((iCoordinate+1)*10)+jCoordinate+1;

    }


  /*  public static boolean validation(int x, int y) {
        boolean isEqual;
        if ((x<4 || y<4)) {
            isEqual = true;
        } else {
            isEqual = false;
        }
        return isEqual;
    } */

    public static boolean validation(int x, int y) {
        boolean isEqual;
        if ((x<4 || y<4)) {
            isEqual = true;
        } else {
            isEqual = false;
        }
        return isEqual;
    }

    // (crossZero[x-1][y-1]) != "X" && (crossZero[x-1][y-1]) != "0")

    public static int yPass(String[][] crossZero) {
        System.out.println("Ход игрока: 0");
        System.out.println("Первая цифра - строка");
        System.out.println("Вторая цифра - столбец");
        Scanner scannerI = new Scanner(System.in);
        String сoordinate = scannerI.next();
        int iCoordinate = Character.getNumericValue(сoordinate.charAt(0));
        int jCoordinate = Character.getNumericValue(сoordinate.charAt(1));
        iCoordinate = iCoordinate - 1;
        jCoordinate = jCoordinate - 1;
        crossZero[iCoordinate][jCoordinate] = "0";

        return (Character.getNumericValue(сoordinate.charAt(0))*10)+Character.getNumericValue(сoordinate.charAt(1));
    }

    public static void gridGeneration(String[][] crossZero) {
        for (int i = 0; i < 3; i++) {  //идём по строкам
            for (int j = 0; j < 3; j++) {//идём по столбцам
                System.out.print("[" + crossZero[i][j] + "]"); //вывод элемента
            }
            System.out.println();//перенос строки ради визуального сохранения табличной формы
        }
    }

    }

