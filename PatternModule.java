/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systembreach;

import java.util.*;

public class PatternModule implements Module {

    Random rand = new Random();

   public boolean play(Scanner sc) {

    Random rand = new Random();

    int start = rand.nextInt(10);
    int step = rand.nextInt(5) + 1;

    int a = start;
    int b = a + step;
    int c = b + step;

    int correctAnswer = c + step;

    System.out.println("Pattern: " + a + ", " + b + ", " + c + ", ?");
    int answer = sc.nextInt();
    sc.nextLine();

    boolean correct = (answer == correctAnswer);

    if (!correct) {
        System.out.println("Incorrect.");
        System.out.println("Correct answer was: " + correctAnswer);
    } else {
        System.out.println("Correct!");
    }

    return correct;
    }
}