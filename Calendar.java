package calendar;

import java.util.Scanner;
import static java.lang.System.out;

public class Calendar {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        String days = " Sun Mon Tue Wed Thu Fri Sat";

        int start = getInt("Enter first day of the month (1 = Sun, 7 = Sat): ");
        while (start < 1 || start > 7) {
            out.println("Invalid input. Enter a number between 1 and 7.");
            start = getInt("Enter first day of the month (1 = Sun, 7 = Sat): ");
        }

        int totalDays = getInt("Enter total days of the month (28-31): ");
        while (totalDays < 28 || totalDays > 31) {
            out.println("Invalid input. Enter 28, 29, 30, or 31.");
            totalDays = getInt("Enter total days of the month (28-31): ");
        }

        out.println(days);

        // Print initial spacing for the starting day
        int currentDay = 1;
        for (int i = 1; i < start; i++) {
            out.print("    ");
        }

        // Print all days in rows of 7
        for (int i = start; currentDay <= totalDays; i++) {
            out.printf("%4d", currentDay);
            currentDay++;
            if (i % 7 == 0) {
                out.println(); // New week
            }
        }

        out.println(); // Final newline
    }

    public static int getInt(String prompt) {
        Scanner keyboard = new Scanner(System.in);
        int data = 0;
        out.print(prompt);
        while (!keyboard.hasNextInt()) {
            out.println("Invalid input. Please enter an integer.");
            keyboard.next(); // Consume invalid input
            out.print(prompt);
        }
        data = keyboard.nextInt();
        return data;
    }
}
