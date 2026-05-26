/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systembreach;

import java.util.*;

public class Game {

    Player player;
    String playerName;
    FileHandler fileHandler;

    CipherModule cipher;
    PatternModule pattern;
    PasswordModule password;
    MemoryModule memory;

    int streak = 0;

    public void startGame() {

    fileHandler = new FileHandler();
    fileHandler.loadAll();

    player = new Player(fileHandler.startScore, fileHandler.lives);

    Scanner sc = new Scanner(System.in);

    System.out.print("Enter your hacker name: ");
    playerName = sc.nextLine();

    cipher = new CipherModule(fileHandler.cipherData);
    pattern = new PatternModule();
    password = new PasswordModule(fileHandler.passwordRules);
    memory = new MemoryModule();

    System.out.println("\n===================================");
    System.out.println("          SYSTEM BREACH");
    System.out.println("===================================\n");

    System.out.println("You have been trapped inside an AI security system.");
    System.out.println("The system has locked you into 4 firewall layers.");
    System.out.println("Each layer tests a different type of logic skill.\n");

    System.out.println("OBJECTIVE:");
    System.out.println("- Break through all 4 firewalls");
    System.out.println("- Maintain your lives (start with " + player.lives + ")");
    System.out.println("- Maximize your score\n");

    System.out.println("WARNING:");
    System.out.println("- Incorrect answers reduce lives");
    System.out.println("- Losing all lives results in system lockout\n");

    System.out.println("Press ENTER to begin breach...");
    new Scanner(System.in).nextLine();

    runLevel("Cipher Firewall", cipher);
    runLevel("Pattern Analyzer", pattern);
    runLevel("Password Breaker", password);
    runLevel("Memory Trace", memory);

    endGame();
}

    private void runLevel(String name, Module module) {
        Scanner sc = new Scanner(System.in);

        System.out.println("\n--- " + name + " ---");

        for (int i = 0; i < 3; i++) {

            if (player.lives <= 0) return;

            boolean correct = module.play(sc);

            if (correct) {
                streak++;
                player.score += 20;

                if (streak >= 3) {
                    player.score += 10;
                    System.out.println("STREAK BONUS!");
                }

                
            } else {
                streak = 0;
                player.score -= 10;
                player.lives--;
                System.out.println("Lives: " + player.lives);
            }

            System.out.println("Score: " + player.score+ "\n");
        }
    }

    private void endGame() {
        System.out.println("\n=== GAME OVER ===");

        if (player.lives > 0)
            System.out.println("SYSTEM BREACHED!");
        else
            System.out.println("SYSTEM LOCKED!");

        System.out.println("Final Score: " + player.score);

        if (player.score >= 150)
            System.out.println("Rank: SYSTEM OVERLORD");
        else if (player.score >= 100)
            System.out.println("Rank: SUCCESSFUL BREACH");
        else
            System.out.println("Rank: CONTAINED FAILURE");

        fileHandler.saveScore(player.score);
    }
}
