package q;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Quiz {

    public static class Main {
        public static void main(String[] args) {
            TestType testType = new TestType();
            testType.TestType();
            GetURL getURL = new GetURL(testType);
            URL testFileURL = getURL.getUrlZadanie();
            URL evaluationFileURL = getURL.getUrlVysledky();

            CorrectAnswers correctAnswers = new CorrectAnswers(getURL);
            //Test test = new Test(getURL);
            Scanner scan = new Scanner(System.in);
            List<String> answers = new ArrayList<>();
                        LoadQuestions loadQuestions = new LoadQuestions(getURL);
            ScanAnswer scanAnswer = new ScanAnswer(answers,scan);
            long startTime = System.currentTimeMillis();
//            for (String loadQuestion : loadQuestions.getLoadQuestions()) {
//                System.out.println(loadQuestion);
//            }
//            long endTime = System.currentTimeMillis();
//            long testDuration = (endTime - startTime) / 1000 / 60;
//            System.out.println("Test ti trval: " + testDuration + " min.");

            //System.out.println("Počet otázok: " + loadQuestions.getLoadQuestions().size());

//            // Výpis otázok
            for (int i = 0; i < loadQuestions.getLoadQuestions().size(); i++) {
                if (i == 0) {
                    System.out.println(loadQuestions.getLoadQuestions().get(i));
                    //                    System.out.println("Hlavička: ");
//                    System.out.println(questions.get(i));
                    System.out.println();
//                    System.out.println();
//                    // Zaznamenanie začiatku testu
//                    startTime = System.currentTimeMillis();
                } else if (i > 0) {
//                    System.out.println("Otázka " + (i) + ":");
                   System.out.println(loadQuestions.getLoadQuestions().get(i));
                   System.out.println();
                   scanAnswer.scanAnswer();
//                    yourAnswers[i - 1] = scan.nextLine().trim();
                }
            }

//            for(
//        String yourAnswer :yourAnswers)
//
//        {
//            System.out.println(yourAnswer);
//        }

        }

    }

}
