package q;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CorrectAnswers {

    private List<String> result = new ArrayList<>();

    public List<String> getResult() {
        return result;
    }

    public CorrectAnswers(GetURL getURL) {

        try {
            URL filePath = getURL.getUrlVysledky();
            File file = new File(filePath.getFile());
//            List<String> result = new ArrayList<>(); // Na uloženie spracovaných riadkov
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            while ((line = reader.readLine()) != null) {
                // Nájdeme prvú medzeru a vezmeme zvyšok riadku
                int firstSpaceIndex = line.indexOf(' ');
                if (firstSpaceIndex != -1) {
                    result.add(line.substring(firstSpaceIndex + 1).trim());
                }
            }
        } catch (IOException e) {
            System.err.println("Chyba pri čítaní súboru: " + e.getMessage());
        }
        // Konverzia zoznamu na pole String[]
        String[] processedLines = result.toArray(new String[0]);
    }
}
