/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systembreach;

import java.util.*;

public class CipherModule implements Module {

    List<String> data;
    Random rand = new Random();

    public CipherModule(List<String> data) {
        this.data = data;
    }

    public boolean play(Scanner sc) {

    String entry = data.get(rand.nextInt(data.size()));
    String[] parts = entry.split("\\|");

    String word = parts[0];
    String type = parts[1];

    String encoded = encode(word, type);

    System.out.println("Decode: " + encoded);
    String answer = sc.nextLine();

    boolean correct = answer.equalsIgnoreCase(word);

    if (!correct) {
        System.out.println("Incorrect.");
        System.out.println("Correct answer was: " + word);
    } else {
        System.out.println("Correct!");
    }

    return correct;
}

    private String encode(String word, String type) {

        if (type.equals("reverse")) {
            return new StringBuilder(word).reverse().toString();
        }

        if (type.equals("caesar")) {
            int shift = rand.nextInt(5) + 1;
            String result = "";

            for (char c : word.toCharArray()) {
                result += (char)(c + shift);
            }

            System.out.println("(Shift +" + shift + ")");
            return result;
        }

        return word;
    }
}