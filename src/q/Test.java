package q;
//package sources;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Test {
    private List<String> questions = new ArrayList<>();
    private List<String> answers = new ArrayList<>();
    private long testDuration;

    public List<String> getAnswers() {
        return answers;
    }

    public long getTestDuration() {
        return testDuration;
    }

    public Test(GetURL getURL) {

        try {
            URL filePath = getURL.getUrlZadanie();
            File file = new File(filePath.getFile());
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder questionBuilder = new StringBuilder(); // Na zhromaždenie otázky
            String line;
            // Čítanie riadok po riadku
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) { // Kontrola prázdneho riadku
                    if (questionBuilder.length() > 0) {
                        questions.add(questionBuilder.toString().trim()); // Uložiť otázku
                        questionBuilder.setLength(0); // Vymazať obsah pre ďalšiu otázku
                    }
                } else {
                    questionBuilder.append(line).append("\n"); // Pridať riadok do otázky
                }

                // Uložiť poslednú otázku, ak existuje
                if (questionBuilder.length() > 0) {
                    questions.add(questionBuilder.toString().trim());
                }
                // Výpis otázok
                Scanner scan = new Scanner(System.in);
                for (int i = 0; i < questions.size(); i++) {
                    if (i == 0) {
                        System.out.println("Hlavička: ");
                        System.out.println(questions.get(i));
                        System.out.println("iH: "+i);
                        System.out.println();
                        System.out.println();

                        // Zaznamenanie začiatku testu
//                        startTime = System.currentTimeMillis();
                    } else if (i > 0) {
                        System.out.println("Otázka " + (i) + ":");
                        System.out.println(questions.get(i));
                        System.out.print("Tvoja odpoveď: ");
                        System.out.println("iO: "+i);
                        System.out.println();
                        answers.set(i - 1, scan.nextLine().trim());
                    }
                }
            }

        } catch (IOException e) {
            System.out.println("Chyba pri čítaní súboru: " + e.getMessage());
        }
    }
}