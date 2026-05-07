/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systembreach;

import java.util.*;

public class PasswordModule implements Module {

    List<String> rules;

    public PasswordModule(List<String> rules) {
        this.rules = rules;
    }

    public boolean play(Scanner sc) {

    System.out.println("Password Rules:");
    for (String rule : rules) {
        System.out.println("- " + rule);
    }

    System.out.print("Enter password: ");
    String input = sc.nextLine();

    boolean valid = true;

    if (rules.contains("length>8") && input.length() <= 8)
        valid = false;

    if (rules.contains("mustContainNumber") && !input.matches(".*\\d.*"))
        valid = false;

    if (rules.contains("mustContainUpper") && !input.matches(".*[A-Z].*"))
        valid = false;

    if (!valid) {
        System.out.println("Incorrect password.");
        System.out.println("Example valid password: Sys7TemX");
    } else {
        System.out.println("Correct!");
    }

    return valid;
    }
}