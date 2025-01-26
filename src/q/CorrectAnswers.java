//package q;
//
//import java.io.BufferedReader;
//import java.io.FileReader;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.GregorianCalendar;
//import java.util.List;
//
//public class CorrectAnswers {
//
//    private String[] yourAnswers;
//
//    public CorrectAnswers() {
//        TestType testType = new q.TestType();
//        GetURL getURL = new q.GetURL();
//        String filePath = getURL.getUrlVysledky();
//        List<String> result = new ArrayList<>(); // Na uloženie spracovaných riadkov
//        try (BufferedReader reader = new BufferedReader(new FileReader(filePath)); {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                // Nájdeme prvú medzeru a vezmeme zvyšok riadku
//                int firstSpaceIndex = line.indexOf(' ');
//                if (firstSpaceIndex != -1) {
//                    result.add(line.substring(firstSpaceIndex + 1).trim());
//                }
//            }
//        } catch (IOException e) {
//            System.err.println("Chyba pri čítaní súboru: " + e.getMessage());
//        }
//
//        // Konverzia zoznamu na pole String[]
//        String[] processedLines = result.toArray(new String[0]);
//
//        // Výpis spracovaných riadkov
//        for (String processedLine : processedLines) {
//            System.out.println(processedLine);
//        }
//    }
//
//
//}
