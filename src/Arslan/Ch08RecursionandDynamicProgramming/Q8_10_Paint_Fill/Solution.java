package Arslan.Ch08RecursionandDynamicProgramming.Q8_10_Paint_Fill;

import Arslan.ConsoleColors;

import static Arslan.ConsoleColors.BLUE_BACKGROUND_BRIGHT;
import static Arslan.ConsoleColors.GREEN_BACKGROUND_BRIGHT;

public class Solution {

    public enum Color {
        Black, White, Red, Yellow, Green
    }

    public static String PrintColor(Question.Color c) {
        switch(c) {
            case Black:
                return ConsoleColors.BLACK+"B ";
            case White:
                return BLUE_BACKGROUND_BRIGHT+"W ";
            case Red:
                return ConsoleColors.RED+"R ";
        case Yellow:
                return ConsoleColors.YELLOW+"Y ";
            case Green:
                return GREEN_BACKGROUND_BRIGHT +"G ";
        }
        return "X";
    }

    public static void PrintScreen(Question.Color[][] screen) {
        for (int r = 0; r < screen.length; r++) {
            for (int c = 0; c < screen[0].length; c++) {
                System.out.print(PrintColor(screen[r][c])+ConsoleColors.RESET);
            }
            System.out.println();
        }
    }

    public static int randomInt(int n) {
        return (int) (Math.random() * n);
    }

    public static boolean PaintFill(Question.Color[][] screen, int r, int c, Question.Color ocolor, Question.Color ncolor) {
        if (r < 0 || r >= screen.length || c < 0 || c >= screen[0].length) {
            return false;
        }
        if (screen[r][c] == ocolor) {
            screen[r][c] = ncolor;
            PaintFill(screen, r - 1, c, ocolor, ncolor); // up
            PaintFill(screen, r + 1, c, ocolor, ncolor); // down
            PaintFill(screen, r, c - 1, ocolor, ncolor); // left
            PaintFill(screen, r, c + 1, ocolor, ncolor); // right
            //PrintScreen(screen);
        }
        return true;
    }

    public static boolean PaintFill(Question.Color[][] screen, int r, int c, Question.Color ncolor) {
        if (screen[r][c] == ncolor) return false;
        return PaintFill(screen, r, c, screen[r][c], ncolor);
    }

    public static void main(String[] args) {
        int N = 10;
        Question.Color[][] screen = new Question.Color[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                screen[i][j] = Question.Color.Black;
            }
        }
        for (int i = 0; i < 100; i++) {
            screen[randomInt(N)][randomInt(N)] = Question.Color.Green;
        }
        PrintScreen(screen);
        PaintFill(screen, 2, 2, Question.Color.White);
        System.out.println();
        PrintScreen(screen);
    }

}
