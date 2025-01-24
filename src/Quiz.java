import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Quiz {

//Kotrola odpovedi – moze by rozne poradie, velke/male pismena, ciselna odpoved
//Ku kazdej otazke pocet bodov a aj skontrolovat a spocitat body
//Napisat vyhodnotenie
//Pocitat cas
//Kategoria – P3-P7

    public static class Main {
        public static void main(String[] args) {
            //String requiredCategory = "00";
            String category = "00";
            //boolean isvalid = true;
            String[] yourAnswers = new String[15];
           // int countdown = 3600;
            Set<String> allowedCategories = Set.of("P3", "P4", "P5", "P6", "P7");
            Scanner scan = new Scanner(System.in);
            while (true) {
                try {
                    System.out.println("Define your category (P3, P4, P5, P6, P7): ");
                    category = scan.nextLine().trim();
                    if (allowedCategories.contains(category.toUpperCase())) {
                        break;
                    } else System.out.println("Category " + category + " is not allowed.");

                } catch (Exception e) {
                    System.out.println("the category not found!");
                    scan.nextLine();
                }

            }
            //while (isvalid =false);
            String fileName = category.toUpperCase() + "_zadanie.txt";

            String filePath = "zdroje/" + fileName;

            URL url = Main.class.getClassLoader().getResource(filePath);
            File file = new File(url.getPath());
            //System.out.println("url " + url);
            try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
                StringBuilder questionBuilder = new StringBuilder(); // Na zhromaždenie otázky
                List<String> questions = new ArrayList<>(); // Zoznam otázok
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
                }

                // Uložiť poslednú otázku, ak existuje
                if (questionBuilder.length() > 0) {
                    questions.add(questionBuilder.toString().trim());
                }
                long startTime = 0;
                // Výpis otázok
                for (int i = 0; i < questions.size(); i++) {
                    if (i == 0) {
                        System.out.println("Hlavička: ");
                        System.out.println(questions.get(i));
                        System.out.println();
                        System.out.println();
                        // Zaznamenanie začiatku testu
                        startTime = System.currentTimeMillis();
                    } else if (i > 0) {
                        System.out.println("Otázka " + (i) + ":");
                        System.out.println(questions.get(i));
                        System.out.print("Tvoja odpoveď: ");
                        System.out.println();
                        yourAnswers[i - 1] = scan.nextLine().trim();
                    }
                }
                long endTime = System.currentTimeMillis();
                long timeTest = (endTime - startTime) / 1000 / 60;
                System.out.println("Test ti trval: " + timeTest + " min.");
            } catch (IOException e) {
                System.out.println("Chyba pri čítaní súboru: " + e.getMessage());
            }
            for (String yourAnswer : yourAnswers) {
                System.out.println(yourAnswer);
            }

        }

    }

}
