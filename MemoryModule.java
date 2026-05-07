/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systembreach;

import java.util.*;

public class MemoryModule implements Module {

    Random rand = new Random();

    @Override
    public boolean play(Scanner sc) {

    int length = rand.nextInt(3) + 4;
    String seq = "";

    for (int i = 0; i < length; i++) {
        seq += rand.nextInt(10);
    }

    System.out.println("Memorize: " + seq);

    try { Thread.sleep(2000); } catch (Exception e) {}

    for (int i = 0; i < 50; i++) System.out.println();

    System.out.print("Enter sequence: ");
    String input = sc.nextLine();

    boolean correct = input.equals(seq);

    if (!correct) {
        System.out.println("Incorrect.");
        System.out.println("Correct sequence was: " + seq);
    } else {
        System.out.println("Perfect recall!");
    }

    return correct;
    }
}