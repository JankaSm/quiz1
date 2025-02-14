package q;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class LoadQuestions {

    List<String> loadQuestions = new ArrayList<>();

    public LoadQuestions(GetURL getURL) {
        try {
            URL filePath = getURL.getUrlZadanie();
            File file = new File(filePath.getFile());
            BufferedReader reader = new BufferedReader(new FileReader(file));
            StringBuilder questionBuilder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) { // Kontrola prázdneho riadku
                    if (!questionBuilder.isEmpty()) {
                        loadQuestions.add(questionBuilder.toString().trim());
                        questionBuilder.setLength(0); // Vymazať obsah pre ďalšiu otázku
                    }
                } else {
                    questionBuilder.append(line).append("\n"); // Pridať riadok do otázky
                }
            }

            if (!questionBuilder.isEmpty()) { // Uložiť poslednú otázku, ak existuje
                loadQuestions.add(questionBuilder.toString().trim());
            }
            reader.close();
        } catch (IOException e) {
            System.err.println("Chyba pri čítaní súboru: " + e.getMessage());
        }
    }

    public List<String> getLoadQuestions() {
        return loadQuestions;
    }
}
