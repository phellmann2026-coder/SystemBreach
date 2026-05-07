/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package systembreach;

import java.io.*;
import java.util.*;

public class FileHandler {

    int lives = 3;
    int startScore = 0;

    List<String> cipherData = new ArrayList<>();
    List<String> passwordRules = new ArrayList<>();

    public void loadAll() {
        loadConfig();
        loadFile("cipher_bank.txt", cipherData);
        loadFile("password_rules.txt", passwordRules);
    }

    private void loadConfig() {
        try (BufferedReader br = new BufferedReader(new FileReader("config.txt"))) {
            String line;

            while ((line = br.readLine()) != null) {
                if (line.startsWith("lives="))
                    lives = Integer.parseInt(line.split("=")[1]);
                if (line.startsWith("startScore="))
                    startScore = Integer.parseInt(line.split("=")[1]);
            }

        } catch (Exception e) {
            System.out.println("Config missing, using defaults.");
        }
    }

    private void loadFile(String file, List<String> list) {
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;

            while ((line = br.readLine()) != null) {
                list.add(line);
            }

        } catch (Exception e) {
            System.out.println("Missing file: " + file);
        }
    }

    public void saveScore(int score) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("highscores.txt", true))) {
            bw.write("Score: " + score);
            bw.newLine();
        } catch (Exception e) {
            System.out.println("Error saving score.");
        }
    }
}